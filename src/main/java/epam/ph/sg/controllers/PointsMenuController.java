package epam.ph.sg.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.User;
import epam.ph.sg.models.points.PtsGame;
import epam.ph.sg.models.points.PtsGameSet;
import epam.ph.sg.models.points.PtsPlayer;

@Controller
public class PointsMenuController {

	private static Logger log = Logger.getLogger(PointsGameController.class);
	
	@RequestMapping(value = "/Points.html")
	public String pointsMenu(HttpSession session) {
		
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "redirect:/index.html";
		}
		
		if (session.getAttribute("pointGames") == null) {
			session.setAttribute("pointGames", PtsGameSet.getGames());
		}
	
		return "Points/PointsMenu";
	}
	
	@RequestMapping(value = "/PointsCreateGame.html", method = RequestMethod.GET)
	public @ResponseBody boolean createGame(HttpSession session) {
		
		User user;
		PtsPlayer server;
		PtsGame game;
		
		user = (User) session.getAttribute("user");
		server = new PtsPlayer(user.getName());
		game = new PtsGame();
		game.setServer(server);
		
		PtsGameSet.addGame(game);
		session.setAttribute("pointGames", PtsGameSet.getGames());
		return true;
	}
	
	@RequestMapping(value = "/PointsConnect.html", method = RequestMethod.GET)
	public String getGameList(HttpSession session) {
		
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "redirect:/index.html";
		}
		
		return "Points/PointsGameList";
	}
}
