package service.player;

import model.Player;
import model.playerStats;
import model.weekSaralyofPlayer;

import java.util.List;

public interface IPlayerService {
   Player getPlayerByID(int id);
   playerStats getPlayerStatsByID (int id);
   weekSaralyofPlayer getSalaryPlayer(int id);

}
