package service.user;

import model.Coach;
import model.user;

import java.util.List;

public interface IUserService {
    user findByEmailAndPassword(String email, String password);
    List<Coach> findAll();

}
