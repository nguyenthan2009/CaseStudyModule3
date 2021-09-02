package service.admin;

import config.ConnectMySQL;
import model.Coach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminService implements IAdminService {
    Connection connection = ConnectMySQL.getConnection();
    public static final String SELECT_ALL_COACH = "select *from coach; ";
    public static final String INSERT_INTO_USER = "insert into user" + "(fullname, email, password) VALUES" + " (?, ?, ?);";
    public static final String SELECT_ID_USER = "SELECT id from user where email = ?";
    public static final String INSERT_INTO_COACH = "insert into coach" + "(id_user,nameCoach, bornYear ,address, salary) VALUES" + "(?,?,?,?,?)";
    public static final String INSERT_INTO_UserRole = "insert into role " + "(id_user,role) VALUES" + "(?,?);";

    @Override
    public List<Coach> findAll() {
        List<Coach> coachList = new ArrayList<>();
        try (
                PreparedStatement st =connection.prepareStatement(SELECT_ALL_COACH)){
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String nameCoach = rs.getString("nameCoach");
                int bornYear = rs.getInt("bornYear");
                String address = rs.getString("address");
                double salary = rs.getDouble("salary");
                Coach coach = new Coach(id,nameCoach,bornYear,address,salary);
                coachList.add(coach);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return coachList;
    }

    @Override
    public void saveUserAndCoach(String email, String password, String fullname, int bornYear, String address, double salary,String role) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement st = connection.prepareStatement(INSERT_INTO_USER);
            st.setString(1,fullname);
            st.setString(2,email);
            st.setString(3,password);
            st.executeUpdate();
            PreparedStatement st1 = connection.prepareStatement(SELECT_ID_USER);
            st1.setString(1,email);
            ResultSet rs = st1.executeQuery();
            int id_user = 0;
            while (rs.next()){
                 id_user = rs.getInt("id");
            }
            PreparedStatement st2 = connection.prepareStatement(INSERT_INTO_COACH);
            st2.setInt(1,id_user);
            st2.setString(2,fullname);
            st2.setInt(3,bornYear);
            st2.setString(4,address);
            st2.setDouble(5,salary);
            st2.executeUpdate();
            PreparedStatement st3 = connection.prepareStatement( INSERT_INTO_UserRole);
            st3.setInt(1,id_user);
            st3.setString(2,role);
            st3.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
