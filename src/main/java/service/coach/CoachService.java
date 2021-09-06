package service.coach;

import config.ConnectMySQL;
import model.Coach;
import model.weekSalaryofCoach;
import model.weekSaralyofPlayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CoachService implements ICoachService {
    Connection connection = ConnectMySQL.getConnection();
    public static final String SELECT_SALARYOFCOACH_BYID = " select coach.nameCoach, week,( coach.salary + bonus) as salaryofWeek from weekofcoach join coach on weekofcoach.id_coach = coach.id  join user on coach.id_user = user.id where user.id =?;";
    public static final String SELECT_COACHDETAIL_BYIDUSER = "select coach.id ,nameCoach, address, bornYear, salary from coach join user on coach.id_user = user.id where user.id =?;";
    @Override
    public List<weekSalaryofCoach> WEEK_SALARYOF_COACH(int user_id) {
        try {
           List <weekSalaryofCoach> listweekSalaryofCoach = null;
            PreparedStatement statement = connection.prepareStatement(SELECT_SALARYOFCOACH_BYID );
            statement.setInt(1,user_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String nameCoach = resultSet.getString("nameCoach");
                int week = resultSet.getInt("week");
                double salaryofCoach = resultSet.getDouble("salaryofWeek");
                weekSalaryofCoach  weekSalaryofCoach= new weekSalaryofCoach(nameCoach,week,salaryofCoach);
                listweekSalaryofCoach.add(weekSalaryofCoach);
            }
            return listweekSalaryofCoach;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Coach coachdetail(int id_user) {
        Coach coach = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COACHDETAIL_BYIDUSER);
            preparedStatement.setInt(1,id_user);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nameCoach = rs.getString("nameCoach");
                String address = rs.getString("address");
                int bornYear = rs.getInt("bornYear");
                double salary = rs.getDouble("salary");
                coach = new Coach(id,nameCoach,bornYear,address,salary);
            }
            return  coach;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;


    }
}
