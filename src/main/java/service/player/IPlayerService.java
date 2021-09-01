package service.player;

import model.Player;

import java.util.List;

public interface IPlayerService {
   List<Player> findAll();
   void save(Player player);
   void update(int id,Player player);
   void remove(int id);
   Player findById(int id);
   List<Player> findByStatus(String status);
   List<Player> findBySalary(double minSalary, double maxSalary);

}
