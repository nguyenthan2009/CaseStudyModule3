package service.admin;

import config.ConnectMySQL;
import model.Coach;
import model.weekSaralyofPlayer;

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
    public static final String SELECT_ID_COACHBYNAME ="select id from coach where nameCoach= ?";
    public static final String INSERT_INTO_WEEKOFCOACH = "insert into weekofcoach" + "(id_coach,week,bonus) VALUES" + "(?,?,?)";
    public static final String INSERT_INTO_PLAYERSTATS = "insert into playerstats" + "(id_player,height,weight,bmiIndex,formIndex) VALUES" + "(?,?,?,?,?)";
    public static final String INSERT_INTO_PLAYER = "insert into player" + "(id_user, namePlayer, bornYear, address, position, salary, status,image)  VALUES" + " (?, ?, ? ,?,?,?,?,?);";
    public static final String SELECT_ID_PLAYERBYNAME = "select id from player where namePlayer = ?";
    public static final String INSERT_INTO_WEEKOFPLAYER = "insert into weekofplayer" + "(id_player,week,bonus,playtimeofWeek, preformedSalary) VALUES" + "(?,?,?,?,?)";
    public static final String SELECT_SALARYWEEKOFPLAYER = "select player.namePlayer ,week,(player.salary+ preformedSalary*playtimeofWeek+bonus) as salaryofWeek from player join weekofplayer on player.id= weekofplayer.id_player where week= ? ;";
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

    @Override
    public void saveSalaryWeekofCoach(String nameCoach, int week, double bonus) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SELECT_ID_COACHBYNAME);
            statement.setString(1,nameCoach);
            ResultSet resultSet = statement.executeQuery();
            int id =0;
            while (resultSet.next()){
                id = resultSet.getInt("id");
            }
            System.out.println(id);
            PreparedStatement statement1 = connection.prepareStatement(INSERT_INTO_WEEKOFCOACH );
            statement1.setInt(1,id);
            statement1.setInt(2,week);
            statement1.setDouble(3,bonus);
            statement1.executeUpdate();
            connection.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void saveUserAndPlayer(String email, String password, String fullName, int bornYear, String address, String position, double salary, String status, String image, String role, double height, double weight, double bmiIndex, int formIndex) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement st = connection.prepareStatement(INSERT_INTO_USER);
            st.setString(1, fullName);
            st.setString(2, email);
            st.setString(3, password);
            st.executeUpdate();
            PreparedStatement st1 = connection.prepareStatement(SELECT_ID_USER);
            st1.setString(1, email);
            ResultSet rs = st1.executeQuery();
            int id_user = 0;
            while (rs.next()) {
                id_user = rs.getInt("id");
            }
            PreparedStatement st2 = connection.prepareStatement(INSERT_INTO_PLAYER);
            st2.setInt(1,id_user);
            st2.setString(2,fullName);
            st2.setInt(3,bornYear);
            st2.setString(4,address);
            st2.setString(5,position);
            st2.setDouble(6, salary);
            st2.setString(7, status);
            st2.setString(8,image);
            st2.executeUpdate();

            PreparedStatement st3 = connection.prepareStatement(SELECT_ID_PLAYERBYNAME);
            st3.setString(1,fullName);
            ResultSet resultSet = st3.executeQuery();
            int id_player =0;
            while (resultSet.next()){
                id_player = resultSet.getInt("id");
            }

            PreparedStatement st4 = connection.prepareStatement(INSERT_INTO_PLAYERSTATS);
            st4.setInt(1,id_player);
            st4.setDouble(2,height);
            st4.setDouble(3,weight);
            st4.setDouble(4,bmiIndex);
            st4.setInt(5,formIndex);
            st4.executeUpdate();

            PreparedStatement st5 = connection.prepareStatement(INSERT_INTO_UserRole);
            st5.setInt(1, id_user);
            st5.setString(2, role);
            st5.executeUpdate();

            connection.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void saveSalaryWeekofPlayer(String namePlayer, int week, double bonus, int playtimeofWeek, double preformedSalary) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SELECT_ID_PLAYERBYNAME);
            statement.setString(1,namePlayer);
            ResultSet resultSet = statement.executeQuery();
            int id_player =0;
            while (resultSet.next()){
                id_player = resultSet.getInt("id");
            }
            PreparedStatement statement1 = connection.prepareStatement(INSERT_INTO_WEEKOFPLAYER);
            statement1.setInt(1,id_player);
            statement1.setInt(2,week);
            statement1.setDouble(3,bonus);
            statement1.setInt(4,playtimeofWeek);
            statement1.setDouble(5,preformedSalary);
            statement1.executeUpdate();
            connection.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<weekSaralyofPlayer> WEEK_SALARYOF_PLAYER_LIST(int week) {
       List<weekSaralyofPlayer> listSalaryofPlayer =  new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SALARYWEEKOFPLAYER);
            preparedStatement.setInt(1,week);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String namePlayer = rs.getString("namePlayer");
                double salaryofWeek = rs.getDouble("salaryofWeek");
                weekSaralyofPlayer weekSaralyofPlayer = new weekSaralyofPlayer(namePlayer,week,salaryofWeek);
                listSalaryofPlayer.add(weekSaralyofPlayer);
            }
            return listSalaryofPlayer;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  null;
    }
}
