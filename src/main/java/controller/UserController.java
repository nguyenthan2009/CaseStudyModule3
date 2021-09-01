package controller;


import model.Coach;
import model.user;
import service.user.IUserService;
import service.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="servlet",value = "/users")
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
               // trang đăng nhập
               login(req,resp);


        }
    }
    public void login(HttpServletRequest req, HttpServletResponse resp){
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        IUserService userService = new UserService();
          user user = userService.findByEmailAndPassword(email,password);
          String role = userService.roleUser(email);
          if(user !=null && role.equals("player")){
              // tới trang (/plays)
          }if(user !=null && role.equals("coach")){
              // tới trang (/coach)
        }if(user !=null && role.equals("admin")){
              // tới trang (/admin)
        }else{
              // tới trang đăng nhập (/users)
        }
    }



}
