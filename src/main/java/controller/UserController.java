package controller;


import model.Player;
import service.player.PlayerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="servlet",value = "/users")
public class UserController extends HttpServlet {
    private PlayerService playerService = new PlayerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("list");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "edit":
                break;
            case "detail":
//                showPlayerById(req,resp);
                break;
            default:
                showListPlayers(req,resp);
                break;
        }

    }

//    private void showPlayerById(HttpServletRequest req, HttpServletResponse resp) {
//        String id = req.getParameter("id");
//        int id1 = Integer.parseInt(id);
//        Player player = playerService.findById(id1);
//    }

    private void showListPlayers(HttpServletRequest req, HttpServletResponse resp) {
        List<Player> listPlayers = playerService.findAll();
        req.setAttribute("listPlayers", listPlayers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("listplayer.jsp");
        try {
            dispatcher.forward(req,resp);
            System.out.println("Ket noi thanh cong");
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
