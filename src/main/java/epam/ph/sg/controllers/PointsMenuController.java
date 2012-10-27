package epam.ph.sg.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.User;
import epam.ph.sg.models.points.PtsGame;
import epam.ph.sg.models.points.PtsGameMap;
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

		if (session.getAttribute("pointGamesMap") == null) {
			session.setAttribute("pointGamesMap", PtsGameMap.getGames());
		}

		return "Points/PointsMenu";
	}

	@RequestMapping(value = "/PointsCreateGame.html", method = RequestMethod.GET)
	public @ResponseBody
	boolean createGame(HttpSession session) {

		User user;
		PtsPlayer server;
		PtsGame oldGame, game;
		
		oldGame = (PtsGame) session.getAttribute("ptsgame");
		if (oldGame != null) {
			System.out.println("old");
			System.out.println(oldGame.getId());
			return true;
		} else {
			System.out.println("new");
		}

		user = (User) session.getAttribute("user");
		server = new PtsPlayer(user.getName());
		game = new PtsGame();
		game.setServer(server);

		PtsGameMap.addGame(game);
		session.setAttribute("pointGamesMap", PtsGameMap.getGames());
		session.setAttribute("ptsgame", game);
		session.setAttribute("ptsUserType", "server");
		System.out.println(game.getId());
		return true;
	}

	@RequestMapping(value = "/PointsConnectList.html", method = RequestMethod.GET)
	public String getGameList(HttpSession session) {

		PtsGame oldGame;
		
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "redirect:/index.html";
		}
		
		oldGame = (PtsGame) session.getAttribute("ptsgame");
		if (oldGame != null) {
			return "redirect:/PointsGame.html";
		} else {
			return "Points/PointsGameList";
		}

	}

	
	
	@RequestMapping(value = "/PointsConnect.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean connectToGame(@RequestParam("gameId") String gameId,
			HttpSession session) {

		PtsPlayer client;
		User user;
		PtsGame game;

		user = (User) session.getAttribute("user");
		client = new PtsPlayer(user.getName());
		game = PtsGameMap.getGames().get(gameId);
		game.setClient(client);
		session.setAttribute("ptsUserType", "client");
		session.setAttribute("ptsgame", game);

		return true;
	}
	
}
