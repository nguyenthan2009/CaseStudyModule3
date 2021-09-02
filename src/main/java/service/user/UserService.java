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
    public static final String SELECT_USER = "SELECT * FROM user WHERE email = ? and password = ?";
    public static final String SELECT_roleUser = "SELECT role from role join user on role.id_user= user.id where email = ? ";

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
            connection.setAutoCommit(true);
            return user;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public String roleUser(String email) {
        try{
            PreparedStatement statement = connection.prepareStatement(SELECT_roleUser);
            statement.setString(1,email);
            ResultSet rs = statement.executeQuery();
            String role = null;
            while (rs.next()){
                role = rs.getString("role");
            }
            return role;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

