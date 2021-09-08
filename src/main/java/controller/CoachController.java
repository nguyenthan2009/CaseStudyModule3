package controller;

import model.*;
import service.admin.AdminService;
import service.coach.CoachService;
import service.user.IUserService;
import service.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
                coachdetail(req, resp);
                break;
            case "login":
                formLogin(req,resp);
                break;
            default:
                pageCoach(req,resp);
                break;
        }
    }

    private void formLogin(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pageCoach(HttpServletRequest req, HttpServletResponse resp) {
            HttpSession session = req.getSession();
            user user = (model.user) session.getAttribute("user");
//            List<Player> list = adminService.findAllPlayer();
//            req.setAttribute("listPlayer",list);
           List<Player> list = (List<Player>) session.getAttribute("listPlayer");
           RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Coach.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                Login(req,resp);
                break;
            default:
                pageCoach(req,resp);
                break;
        }
    }

    private void Login(HttpServletRequest req, HttpServletResponse resp) {
        List<Player> list = adminService.findAllPlayer();
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        IUserService userService = new UserService();
        String destPage = "/login.jsp";
        user user = userService.findByEmailAndPassword(email,password);
        String role = userService.roleUser(email);
        if(user !=null && role.equals("player")){
            destPage = "/Player.jsp";
            session.setAttribute("user",user);
            session.setAttribute("listPlayer",list);
        }if(user !=null && role.equals("coach")){
            destPage = "/Coach.jsp";
            session.setAttribute("user",user);
            session.setAttribute("listPlayer",list);
        }if(user !=null && role.equals("admin")){
            destPage = "/Test.jsp";
            session.setAttribute("user",user);
            session.setAttribute("listPlayer",list);
        }else{
            String message = "Invalid email/password";
            req.setAttribute("message", message);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(destPage);
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void coachdetail(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Coach coach = coachService.coachdetail(id);
        req.setAttribute("coachdetail", coach);
        List<weekSalaryofCoach> weekSaralyofPlayer = coachService.WEEK_SALARYOF_COACH(id);
        req.setAttribute("salaryofWeek", weekSaralyofPlayer);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/coachdetail.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}