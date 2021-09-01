package service.user;

import model.user;

public interface IUserService {
    user findByEmailAndPassword(String email, String password);
}
