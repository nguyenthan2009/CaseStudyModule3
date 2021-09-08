package controller;


import model.Coach;
import model.Player;
import model.user;
import service.admin.AdminService;
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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="servlet",value = "/users")
public class UserController extends HttpServlet {
    AdminService adminService = new AdminService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":

                break;
            case "edit":
                break;
            case "search":
                break;
            default:
                showformLogin(req,resp);


        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":

                break;
            case "edit":
                break;
            case "search":
                break;
            default:
               login(req,resp);


        }
    }
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Player> list = adminService.findAllPlayer();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        IUserService userService = new UserService();
          String destPage = "/login.jsp";
          user user = userService.findByEmailAndPassword(email,password);
          String role = userService.roleUser(email);
          if(user !=null && role.equals("player")){
              destPage = "/Player.jsp";
              HttpSession session = req.getSession();
              session.setAttribute("user",user);
          }else if(user !=null && role.equals("coach")){
              HttpSession session = req.getSession();
              destPage = "/Coach.jsp";
              session.setAttribute("user",user);
              session.setAttribute("listPlayer",list);
          }else if(user !=null && role.equals("admin")){
              HttpSession session = req.getSession();
              destPage = "/Test.jsp";
              session.setAttribute("user",user);
              session.setAttribute("listPlayer",list);

          }else{
            String message = "Invalid email/password";
            req.setAttribute("message", message);

        }
          RequestDispatcher requestDispatcher = req.getRequestDispatcher(destPage);
          requestDispatcher.forward(req,resp);

    }
    public void showformLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, resp);
    }



}
