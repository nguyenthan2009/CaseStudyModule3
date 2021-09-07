package service.player;

import config.ConnectMySQL;
import model.Player;
import model.playerStats;
import model.weekSaralyofPlayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerService implements IPlayerService {
  Connection connection = ConnectMySQL.getConnection();
  public static final String SELECT_PLAYER ="select namePlayer,bornYear,address,salary,status,image,position from player join user on player.id_user = user.id where user.id =?";
  public static final String SELECT_PLAYERSTATS ="select height,weight,bmiIndex,formIndex from playerstats join player on playerstats.id_player =player.id join user on player.id_user = user.id where user.id =?";
  public static final String SELECT_WEEKOF_PLAYER ="select namePlayer,week,(salary+bonus+playtimeofWeek*preformedSalary) as SalaryofWeek from weekofplayer join player on weekofplayer.id_player = player.id join user on player.id_user = user.id where user.id =?";

  @Override
  public Player getPlayerByID(int id) {
    Player player = null;
    try {
      PreparedStatement statement = connection.prepareStatement(SELECT_PLAYER);
      statement.setInt(1, id);
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        String namePlayer = rs.getString("namePlayer");
        int bornYear = rs.getInt("bornYear");
        String address = rs.getString("address");
        String position = rs.getString("position");
        int salary = rs.getInt("salary");
        String status = rs.getString("status");
        String image = rs.getString("image");

        player = new Player(namePlayer, bornYear, address, position, salary, status, image);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return player;
  }
  @Override
  public playerStats getPlayerStatsByID(int id_player) {
    playerStats playerStats = null;
    try {
      PreparedStatement statement = connection.prepareStatement(SELECT_PLAYERSTATS);
      statement.setInt(1, id_player);
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        double height = rs.getDouble("height");
        double weight = rs.getDouble("weight");
        double bmiIndex = rs.getDouble("bmiIndex");
        int formIndex = rs.getInt("formIndex");

        playerStats = new playerStats(height, weight, bmiIndex, formIndex);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return playerStats;


  }

  @Override
  public weekSaralyofPlayer getSalaryPlayer(int id) {
    weekSaralyofPlayer weekSaralyofPlayer = null;
    try {
      PreparedStatement statement = connection.prepareStatement(SELECT_WEEKOF_PLAYER);
      statement.setInt(1,id);
      ResultSet rs = statement.executeQuery();
      while (rs.next()){
        String namePlayer = rs.getString("namePlayer");
        int week = rs.getInt("week");
        double salaryofWeek =rs.getDouble("SalaryofWeek");
        weekSaralyofPlayer = new weekSaralyofPlayer(namePlayer,week,salaryofWeek);

      }
      return weekSaralyofPlayer;

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;
  }
}




