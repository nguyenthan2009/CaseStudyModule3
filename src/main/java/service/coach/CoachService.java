package service.coach;

import config.ConnectMySQL;
import model.Coach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoachService implements ICoachService {
    Connection connection = ConnectMySQL.getConnection();
    public static final String SELECT_ALL_COACH = "select *from coach; ";
    @Override
    public List<Coach> findAll() {
        List<Coach> coachList = new ArrayList<>();
        try (
                PreparedStatement st =connection.prepareStatement(SELECT_ALL_COACH)){
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String nameCoach = rs.getString("nameCoach");
                int bornYear = rs.getInt("bornYear");
                String address = rs.getString("address");
                double salary = rs.getDouble("salary");
                Coach coach = new Coach(nameCoach,bornYear,address,salary );
                coachList.add(coach);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return coachList;
    }

    @Override
    public void save(Coach coach) {

    }

    @Override
    public void update(int id, Coach coach) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Coach findById(int id) {
        return null;
    }
}