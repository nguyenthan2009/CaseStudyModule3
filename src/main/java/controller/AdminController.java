package controller;

import model.*;
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
            case "salaryWeekofCoach":
                formSalaryWeekOfCoach(req,resp);
                break;
            case  "listCoach":
                showAllCoach(req, resp);
                break;
            case "ChartofTeam":
                chartofTeam(req,resp);
                break;
            case "ChartofCoach":
                chartofCoach(req,resp);
                break;

            case "updatePlayerInfo":
                showUpdatePlayerInfo(req,resp);
                break;
            default:
                showAllPlayer(req, resp);
                break;

        }
    }

    private void formSalaryWeekOfCoach(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/weekSalaryofPlayer.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
            case "salaryWeekofCoach":
                showListSalaryWeekofCoach(req,resp);
                break;
            case "updatePlayerInfo":
                UpdatePlayerInfo(req,resp);
                break;


            default:
                break;

        }
    }

    private void showListSalaryWeekofCoach(HttpServletRequest req, HttpServletResponse resp) {
        int week = Integer.parseInt(req.getParameter("week"));
        List<weekSalaryofCoach> list = service.WEEK_SALARYOF_COACH_LIST(week);
        req.setAttribute("listSalaryCoach",list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ListSalaryWeekOfCoach.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
    public void showAllPlayer(HttpServletRequest req, HttpServletResponse resp){
        List<Player> playerList = service.findAllPlayer();
        req.setAttribute("listPlayer",playerList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Test.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void chartofTeam(HttpServletRequest req, HttpServletResponse resp){
        List<Chart> chartList = service.chartofTeam(1,2,3,4);
        req.setAttribute("chartList",chartList);
        double total = service.totalSalaryTeam();
        req.setAttribute("total",total);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/salaryChartofTeeam.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void chartofCoach(HttpServletRequest req, HttpServletResponse resp){
        List<Chart> chartList = service.chartofCoach(1,2,3,4);
        req.setAttribute("chartList",chartList);
        double total = service.totalSalaryCoach();
        req.setAttribute("total",total);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/salaryChartofCoach.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdatePlayerInfo(HttpServletRequest req, HttpServletResponse resp) {
//        int id = Integer.parseInt(req.getParameter("id"));
        int id = 1;
        Player existingPlayer =service.getPlayerByID(id);
        req.setAttribute("player", existingPlayer);
        playerStats playerStats = service.getPlayerStatsByID(id);
        req.setAttribute("playerStats", playerStats);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/updatePlayerInfo.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void UpdatePlayerInfo(HttpServletRequest req, HttpServletResponse resp) {
        String namePlayer = req.getParameter("namePlayer");
        int bornYear = Integer.parseInt(req.getParameter("bornYear"));
        String address = req.getParameter("address");
        String position = req.getParameter("position");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String status = req.getParameter("status");
        String image = req.getParameter("image");
        double height = Double.parseDouble(req.getParameter("height"));
        double weight = Double.parseDouble(req.getParameter("weight"));
        double bmiIndex = Double.parseDouble(req.getParameter("bmiIndex"));
        int formIndex = Integer.parseInt(req.getParameter("formIndex"));

        service.updatePlayer(namePlayer, bornYear, address, position, salary, status, image, height, weight, bmiIndex, formIndex);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/updatePlayerInfo.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
