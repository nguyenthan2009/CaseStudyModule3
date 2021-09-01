package controller;


import model.Coach;
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
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
            switch (action) {
                case "showCoach":
                    break;
                case "create":

                    break;
                case "edit":
                    break;
                case "search":
                    break;
                default:
                    showAllCoach(req,resp);

            }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    public void showAllCoach(HttpServletRequest req, HttpServletResponse resp){
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
}
