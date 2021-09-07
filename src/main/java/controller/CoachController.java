package controller;

import model.Coach;
import model.weekSalaryofCoach;
import model.weekSaralyofPlayer;
import service.admin.AdminService;
import service.coach.CoachService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "servletCoach",value = "/coach")

public class CoachController extends HttpServlet {
    CoachService coachService = new CoachService();
    AdminService adminService = new AdminService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "newPlayer":
                break;
            case "coachdetail":
                coachdetail(req,resp);
                break;
            default:
                pageCoach(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private void coachdetail(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
         Coach coach =   coachService.coachdetail(id);
         req.setAttribute("coachdetail",coach);
         List<weekSalaryofCoach> weekSaralyofPlayer = coachService.WEEK_SALARYOF_COACH(id);
         req.setAttribute("salaryofWeek",weekSaralyofPlayer);
         RequestDispatcher requestDispatcher = req.getRequestDispatcher("/coachdetail.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void pageCoach(HttpServletRequest req, HttpServletResponse resp){


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Coach.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
