package controller;

import model.Player;
import model.playerStats;
import model.weekSaralyofPlayer;
import service.player.PlayerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servletPlayer",value = "/players")

public class PlayerController extends HttpServlet {
    PlayerService playerService = new PlayerService();
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
            case "detailPlayer":
                detailplayer(req, resp);
                break;
            default:
                pagePlayer(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void detailplayer(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Player player = playerService.getPlayerByID(id);
        req.setAttribute("player",player);
        playerStats playerStats = playerService.getPlayerStatsByID(id);
        req.setAttribute("playerstats",playerStats);
        weekSaralyofPlayer weekSaralyofPlayer = playerService.getSalaryPlayer(id);
        req.setAttribute("weekSaralyofPlayer",weekSaralyofPlayer);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/playerDetailofPlayer.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void pagePlayer(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Player.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

