package service.player;

import config.ConnectMySQL;
import model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    private static final String SELECT_ALL_PLAYERS = "select * from player";
    ConnectMySQL connectMySQL = new ConnectMySQL();

    public PlayerService(){
    }
    public List<Player> findAll(){
        List<Player> players = new ArrayList<>();
        try (Connection connection = connectMySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PLAYERS)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("namePlayer");
                int bornYear = rs.getInt("bornYear");
                String address = rs.getString("address");
                String position = rs.getString("position");
                int salary = rs.getInt("salary");
                String status = rs.getString("status");
                String image = rs.getString("image");
                players.add(new Player(id, name, bornYear, address, position, salary,status,image));
                System.out.println("Cap nhat thanh cong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }



}