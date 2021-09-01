package service.user;

import config.ConnectMySQL;
import model.Coach;
import model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements  IUserService {
    Connection connection = ConnectMySQL.getConnection();
    public static final String SELECT_USER = "SELECT * FROM user WHERE email = ? and passWord = ?";
    public static final String SELECT_PLAYER = "SELECT*FROM player";


    @Override
    public user findByEmailAndPassword(String email, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();

            user user = null;

            if (result.next()) {
                user = new user();
                user.setFullName(result.getString("fullname"));
                user.setEmail(email);
                user.setPassWord(password);
            }
            System.out.println("SELECT -->"+statement);
            connection.setAutoCommit(true);  //Neu de connection.close() hoac connection.commit() thi chi dang nhap duoc 1 lan
            //Su khac biet cua setAutoCommit(true) la co the tu dong cap nhat lai query
            return user;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static final String SELECT_ALL_COACH = "select *from coach; ";
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



}

