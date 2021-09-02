package controller;

import model.Coach;
import service.admin.AdminService;
import service.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
                createNewCoach(req,resp);
                break;
            case "edit":
                break;
            case "search":
                break;
            default:
                showAllCoach(req,resp);

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
        service.saveUserAndCoach(email,password,fullname,bornYear,address,salary, role);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("createCoach.jsp");
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
        super.doPost(req, resp);
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

}
