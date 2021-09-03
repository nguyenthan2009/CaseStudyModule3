package controller;

import model.Coach;
import model.weekSaralyofPlayer;
import service.admin.AdminService;
import service.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Dictionary;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminController extends HttpServlet {
    private AdminService service = new AdminService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "newCoach":
                formCreatCoach(req, resp);
                break;
            case "newPlayer":
                formCreatePlayer(req,resp);
                break;
            case "weekOfCoach":
                showformWeekofcoach(req, resp);
                break;
            case "weekOfPlayer":
                showformWeekofPlayer(req,resp);
                break;
            case "salaryWeekofPlayer":
                formSalaryWeekOfPlayer(req,resp);
                break;

            default:
                showAllCoach(req, resp);

        }
    }

    public void showformWeekofcoach(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/weekofCoach.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewCoach(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullname");
        int bornYear = Integer.parseInt(req.getParameter("bornYear"));
        String address = req.getParameter("address");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String role = req.getParameter("role");
        service.saveUserAndCoach(email, password, fullname, bornYear, address, salary, role);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/createCoach.jsp");
        try {
            requestDispatcher.forward(req, resp);
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
            case "newCoach":
                createNewCoach(req, resp);
                break;
            case "weekOfCoach":
                createWeekOfCoach(req, resp);
                break;
            case "newPlayer":
                createNewPlayer(req,resp);
                break;
            case "weekOfPlayer":
                createWeekofPlayer(req,resp);
                break;
            case "salaryWeekofPlayer":
                showListSalaryWeekofPlayer(req,resp);
                break;


            default:
                break;

        }
    }

    public void showAllCoach(HttpServletRequest req, HttpServletResponse resp) {
        List<Coach> coachList = service.findAll();
        req.setAttribute("listCoach", coachList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/coachList.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void formCreatCoach(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/createCoach.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void formCreatePlayer(HttpServletRequest req, HttpServletResponse resp){
        RequestDispatcher dispatcher = req.getRequestDispatcher("/createPlayer.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createWeekOfCoach(HttpServletRequest req, HttpServletResponse resp) {
        String nameCoach = req.getParameter("nameCoach");
        int week = Integer.parseInt(req.getParameter("week"));
        double bonus = Double.parseDouble(req.getParameter("bonus"));
        service.saveSalaryWeekofCoach(nameCoach, week, bonus);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/weekofCoach.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void createNewPlayer(HttpServletRequest req, HttpServletResponse resp){
        String email =req.getParameter("email");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullname");
        int bornYear = Integer.parseInt(req.getParameter("bornYear"));
        String address =req.getParameter("address");
        String position = req.getParameter("position");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String status = req.getParameter("status");
        String image =  req.getParameter("image");
        String role = req.getParameter("role");
        double height = Double.parseDouble(req.getParameter("height"));
        double weight = Double.parseDouble(req.getParameter("weight"));
        double bmiIndex = Double.parseDouble(req.getParameter("bmiIndex"));
        int formIndex = Integer.parseInt(req.getParameter("formIndex"));
        service.saveUserAndPlayer(email,password,fullName,bornYear,address,position,salary,status,image,role,height,weight,bmiIndex,formIndex);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/createPlayer.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showformWeekofPlayer(HttpServletRequest req, HttpServletResponse resp){
        RequestDispatcher dispatcher = req.getRequestDispatcher("/weekofPlayer.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createWeekofPlayer(HttpServletRequest req, HttpServletResponse resp){
        String namePlayer   =  req.getParameter("namePlayer");
        int week = Integer.parseInt(req.getParameter("week"));
        double bonus = Double.parseDouble(req.getParameter("bonus"));
        int playtimeofWeek = Integer.parseInt(req.getParameter("playtimeofWeek"));
        double  preformedSalary = Double.parseDouble(req.getParameter("preformedSalary"));
        service.saveSalaryWeekofPlayer(namePlayer,week,bonus,playtimeofWeek,preformedSalary);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/weekofPlayer.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void formSalaryWeekOfPlayer(HttpServletRequest req, HttpServletResponse resp){
        RequestDispatcher dispatcher = req.getRequestDispatcher("/weekSalaryofPlayer.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showListSalaryWeekofPlayer(HttpServletRequest req, HttpServletResponse resp){
         int week = Integer.parseInt(req.getParameter("week"));
          List<weekSaralyofPlayer> list = service.WEEK_SALARYOF_PLAYER_LIST(week);
        req.setAttribute("listSalary",list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("ListSalaryWeekOfPlayer.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
