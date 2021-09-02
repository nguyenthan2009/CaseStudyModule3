
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
            case "create":
                addNewCoach(req,resp);
                break;
            case "edit":
                break;
            case "search":
                break;
            default:
                showAllCoach(req, resp);

        }
    }

    private void addNewCoach(HttpServletRequest req, HttpServletResponse resp) {
        String nameCoach = req.getParameter("name");
        int bornYear = Integer.parseInt(req.getParameter("bornYear"));
        String address = req.getParameter("address");
        double salary = Double.parseDouble(req.getParameter("salary"));
        Coach coach = new Coach(nameCoach, bornYear ,address, salary);

        String
        service.saveNewCoach(coach);
    }


//    String name = request.getParameter("name");
//    String email = request.getParameter("email");
//    String country = request.getParameter("country");
//    User newUser = new User(name, email, country);
//        userDAO.insertUserStore(newUser);
//    RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
//        dispatcher.forward(request, response);
//}

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
