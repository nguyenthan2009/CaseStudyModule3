package service.admin;

import model.Coach;
import model.user;

import java.util.List;

public interface IAdminService {
    List<Coach> findAll();
    void saveUserAndCoach(String email, String password,String fullname,int bornYear,String address,double salary,String role);
}
