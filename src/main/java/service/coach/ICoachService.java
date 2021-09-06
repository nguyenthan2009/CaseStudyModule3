package service.coach;

import model.Coach;
import model.Player;
import model.weekSalaryofCoach;

import java.util.List;

public interface ICoachService {
   List<weekSalaryofCoach> WEEK_SALARYOF_COACH(int id_user);
    Coach coachdetail(int id_user);


}
