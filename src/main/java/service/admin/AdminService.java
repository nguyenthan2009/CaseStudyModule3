package service.admin;

import config.ConnectMySQL;
import model.*;

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
    public static final String SELECT_SALARYWEEKOFCOACH = "select coach.nameCoach, week,( coach.salary + bonus) as salaryofWeek from coach join weekofcoach on coach.id = weekofcoach.id_coach where week= ?; ";
    public static final String SELECT_TOTALSALARYOF_PLAYER_OFALLWEEK = "select sum(player.salary+ preformedSalary*playtimeofWeek+bonus) as totalSalaryWeekofPlayer from player join weekofplayer on player.id= weekofplayer.id_player ;";
    public static final String SELECT_TOTALSALARYOF_COACH_OFALLWEEK ="select sum(coach.salary + bonus) as totalSalaryWeekofCoach from  coach join weekofcoach on coach.id = weekofcoach.id_coach ;";
    public static final String SELECT_TOTALSALARY_COACH_OFWEEK = "select sum(coach.salary + bonus) as totalSalaryWeekofCoachofWeek from  coach join weekofcoach on coach.id = weekofcoach.id_coach where week= ?;";
    public static final String SELECT_TOTALSALARY_PLAYER_OFWEEK ="select sum(player.salary+ preformedSalary*playtimeofWeek+bonus) as totalSalaryWeekofPlayerofWeek from player join weekofplayer on player.id= weekofplayer.id_player where week =? ;";
    public static final  String SELECT_ALL_PLAYER = "select*from player;";
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
                int week1 = rs.getInt("week");
                double salaryofWeek = rs.getDouble("salaryofWeek");
                weekSaralyofPlayer weekSaralyofPlayer = new weekSaralyofPlayer(namePlayer,week1,salaryofWeek);
                listSalaryofPlayer.add(weekSaralyofPlayer);
            }
            return listSalaryofPlayer;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  null;
    }

    @Override
    public List<Player> findAllPlayer() {
        List<Player> playerList = new ArrayList<>();
        try (
                PreparedStatement st = connection.prepareStatement(SELECT_ALL_PLAYER)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String namePlayer = rs.getString("namePlayer");
                int bornYear = rs.getInt("bornYear");
                String address = rs.getString("address");
                String position = rs.getString("position");
                int salary = rs.getInt("salary");
                String status = rs.getString("status");
                String image = rs.getString("image");
                Player player = new Player(id, namePlayer, bornYear, address, position, salary, status, image);
                playerList.add(player);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return playerList;

    }

    @Override
    public List<weekSalaryofCoach> WEEK_SALARYOF_COACH_LIST(int week) {
        List<weekSalaryofCoach> weekSalaryofCoaches =  new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SALARYWEEKOFCOACH);
            preparedStatement.setInt(1,week);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String nameCoach = rs.getString("nameCoach");
                int week1 = rs.getInt("week");
                double salaryofWeek = rs.getDouble("salaryofWeek");
                 weekSalaryofCoach weekSalaryofCoach = new weekSalaryofCoach(nameCoach,week1,salaryofWeek);
                weekSalaryofCoaches.add(weekSalaryofCoach);
            }
            return weekSalaryofCoaches;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  null;
    }

    @Override
    public List<Chart> chartofTeam(int week1, int week2, int week3, int week4) {
        List<Chart> chartList = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement( SELECT_TOTALSALARYOF_PLAYER_OFALLWEEK);
            ResultSet rs = st.executeQuery();
             double totalSalaryWeekofPlayer =0;
            while (rs.next()){
                totalSalaryWeekofPlayer = rs.getDouble("totalSalaryWeekofPlayer");
            }
            PreparedStatement st1 = connection.prepareStatement(SELECT_TOTALSALARYOF_COACH_OFALLWEEK );
            ResultSet rs1 = st1.executeQuery();
            double totalSalaryWeekofCoach =0;
            while(rs1.next()){
                 totalSalaryWeekofCoach = rs1.getDouble("totalSalaryWeekofCoach");
            }
            double totalSalaryTeam = totalSalaryWeekofPlayer +  totalSalaryWeekofCoach;
            PreparedStatement st2 = connection.prepareStatement(SELECT_TOTALSALARY_COACH_OFWEEK);
            st2.setInt(1,week1);
            ResultSet rs2 = st2.executeQuery();
            double totalSalaryWeekofCoachofWeek =0;
            while (rs2.next()){
                totalSalaryWeekofCoachofWeek = rs2.getDouble("totalSalaryWeekofCoachofWeek");
            }
            PreparedStatement st3 = connection.prepareStatement(SELECT_TOTALSALARY_PLAYER_OFWEEK);
            st3.setInt(1,week1);
            ResultSet rs3 = st3.executeQuery();
            double totalSalaryWeekofPlayerofWeek =0;
            while(rs3.next()){
                totalSalaryWeekofPlayerofWeek = rs3.getDouble("totalSalaryWeekofPlayerofWeek");
            }
             double totalSalaryTeamofWeek = totalSalaryWeekofCoachofWeek + totalSalaryWeekofPlayerofWeek;
            int percentWeek1 = (int) ((totalSalaryTeamofWeek/totalSalaryTeam) *100);

            PreparedStatement st4 = connection.prepareStatement(SELECT_TOTALSALARY_COACH_OFWEEK);
            st4.setInt(1,week2);
            ResultSet rs4 = st4.executeQuery();
            double totalSalaryWeekofCoachofWeek2 =0;
            while (rs4.next()){
                totalSalaryWeekofCoachofWeek2 = rs4.getDouble("totalSalaryWeekofCoachofWeek");
            }
            PreparedStatement st5 = connection.prepareStatement(SELECT_TOTALSALARY_PLAYER_OFWEEK);
            st5.setInt(1,week2);
            ResultSet rs5 = st5.executeQuery();
            double totalSalaryWeekofPlayerofWeek2 =0;
            while(rs5.next()){
                totalSalaryWeekofPlayerofWeek2 = rs5.getDouble("totalSalaryWeekofPlayerofWeek");
            }
            double totalSalaryTeamofWeek2 = totalSalaryWeekofCoachofWeek2 + totalSalaryWeekofPlayerofWeek2;
            int percentWeek2 = (int) ((totalSalaryTeamofWeek2/totalSalaryTeam) *100);

            PreparedStatement st6 = connection.prepareStatement(SELECT_TOTALSALARY_COACH_OFWEEK);
            st6.setInt(1,week3);
            ResultSet rs6 = st6.executeQuery();
            double totalSalaryWeekofCoachofWeek3 =0;
            while (rs6.next()){
                totalSalaryWeekofCoachofWeek3 = rs6.getDouble("totalSalaryWeekofCoachofWeek");
            }
            PreparedStatement st7 = connection.prepareStatement(SELECT_TOTALSALARY_PLAYER_OFWEEK);
            st7.setInt(1,week3);
            ResultSet rs7 = st7.executeQuery();
            double totalSalaryWeekofPlayerofWeek3 =0;
            while(rs7.next()){
                totalSalaryWeekofPlayerofWeek3 = rs7.getDouble("totalSalaryWeekofPlayerofWeek");
            }
            double totalSalaryTeamofWeek3 = totalSalaryWeekofCoachofWeek3 + totalSalaryWeekofPlayerofWeek3;
            int percentWeek3 = (int) ((totalSalaryTeamofWeek3/totalSalaryTeam) *100);


            PreparedStatement st8 = connection.prepareStatement(SELECT_TOTALSALARY_COACH_OFWEEK);
            st8.setInt(1,week4);
            ResultSet rs8 = st8.executeQuery();
            double totalSalaryWeekofCoachofWeek4 =0;
            while (rs8.next()){
                totalSalaryWeekofCoachofWeek4 = rs8.getDouble("totalSalaryWeekofCoachofWeek");
            }
            PreparedStatement st9 = connection.prepareStatement(SELECT_TOTALSALARY_PLAYER_OFWEEK);
            st9.setInt(1,week4);
            ResultSet rs9 = st9.executeQuery();
            double totalSalaryWeekofPlayerofWeek4 =0;
            while(rs3.next()){
                totalSalaryWeekofPlayerofWeek4 = rs9.getDouble("totalSalaryWeekofPlayerofWeek");
            }
            double totalSalaryTeamofWeek4 = totalSalaryWeekofCoachofWeek4 + totalSalaryWeekofPlayerofWeek4;
            int percentWeek4 = (int) ((totalSalaryTeamofWeek4/totalSalaryTeam) *100);

            chartList.add( new Chart(percentWeek1,week1, totalSalaryTeamofWeek));
            chartList.add( new Chart(percentWeek2,week2, totalSalaryTeamofWeek2));
            chartList.add( new Chart(percentWeek3,week3, totalSalaryTeamofWeek3));
            chartList.add( new Chart(percentWeek4,week4, totalSalaryTeamofWeek4));
            return chartList;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

}
