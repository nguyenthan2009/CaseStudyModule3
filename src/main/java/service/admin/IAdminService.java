package service.admin;

import model.Coach;
import model.user;

import java.util.List;

public interface IAdminService {
    List<Coach> findAll();


    // Tim va hien thi chi tiet HLV theo ten
    Coach findCoachByID (String name);

    //Them huan luyen vien
    void saveNewCoach (Coach coach , user user);


}