package service.coach;

import model.Coach;
import model.Player;

import java.util.List;

public interface ICoachService {
    List<Coach> findAll();

    void save(Coach coach);

    void update(int id, Coach coach);

    void remove(int id);

    Coach findById(int id);


}
