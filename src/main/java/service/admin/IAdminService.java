package service.admin;

import model.Coach;
import model.user;
import model.weekSaralyofPlayer;

import java.util.List;

public interface IAdminService {
    List<Coach> findAll();
    void saveUserAndCoach(String email, String password,String fullname,int bornYear,String address,double salary,String role);
    void saveSalaryWeekofCoach(String nameCoach,int week,double bonus);
    void saveUserAndPlayer(String email, String password, String fullName, int bornYear, String address, String position, double salary, String status, String image, String role,double height,double weight,double bimIndex,int formIndex);
    void saveSalaryWeekofPlayer(String namePlayer,int week,double bonus,int playtimeofWeek,double  preformedSalary);
    List<weekSaralyofPlayer> WEEK_SALARYOF_PLAYER_LIST(int week);
}
