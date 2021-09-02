package service.admin;

import config.ConnectMySQL;
import model.Coach;
import model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminService implements IAdminService {
    Connection connection = ConnectMySQL.getConnection();
    public static final String SELECT_ALL_COACH = "select *from coach; ";
    public static final String INSERT_INTO_COACH = "insert into user" + "(nameCoach, bornYear ,address, salary) VALUES" + "(?,?,?,?)";
    public static final String INSERT_INTO_USER = "insert into user" + "(fullname, email, password) VALUES" + " (?, ?, ?);";

    @Override
    public List<Coach> findAll() {
        List<Coach> coachList = new ArrayList<>();
        try (
                PreparedStatement st = connection.prepareStatement(SELECT_ALL_COACH)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameCoach = rs.getString("nameCoach");
                int bornYear = rs.getInt("bornYear");
                String address = rs.getString("address");
                double salary = rs.getDouble("salary");
                Coach coach = new Coach(id, nameCoach, bornYear, address, salary);
                coachList.add(coach);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return coachList;
    }

    @Override
    public Coach findCoachByID(String name) {
        return null;
    }

    @Override
    public void saveNewCoach(Coach coach, user user ) {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try (

                PreparedStatement st = connection.prepareStatement(INSERT_INTO_COACH);
                PreparedStatement st1 = connection.prepareStatement(INSERT_INTO_USER);){
            //add vao user
            st1.setString(1, user.getFullName());
            st1.setString(2,user.getEmail());
            st1.setString(3,user.getPassWord());
            st1.executeUpdate();
            // add vao coach
            st.setString(1,coach.getNameCoach());
            st.setInt(2,coach.getBornYear());
            st.setString(3,coach.getAddress());
            st.setDouble(4,coach.getSalary());
            st.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}