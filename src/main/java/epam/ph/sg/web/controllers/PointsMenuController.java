package epam.ph.sg.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.User;
import epam.ph.sg.models.points.PtsStatistics;
import epam.ph.sg.models.points.PtsGame;
import epam.ph.sg.models.points.PtsGameMap;
import epam.ph.sg.models.points.PtsPlayer;

@Controller
public class PointsMenuController {

	@RequestMapping(value = "/Points.html")
	public String pointsMenu(HttpSession session) {

		Integer oldGameId;
		oldGameId = (Integer) session.getAttribute("ptsGameId");

		session.setAttribute("pointGamesMap", PtsGameMap.getGames());
		session.setAttribute("pointsGameServersMap",
				PtsGameMap.getGameServers());

		if (oldGameId != null) {

			return "redirect:/PointsGame.html";

		}

		return "Points/PointsMenu";
	}

	@RequestMapping(value = "/PointsGame.html")
	public String pointsGame(HttpSession session) {
		
		if (session.getAttribute("ptsGame") != null) {
			PtsGame game = (PtsGame)session.getAttribute("ptsGame");
			String userType = session.getAttribute("ptsUserType").toString();
			if (game.isActiveTimer(userType))
				game.stopRefreshTimer();
		}
		return "Points/PointsGame";
	}

	@RequestMapping(value = "/PointsCreateGame.html")
	public @ResponseBody
	boolean createGame(HttpSession session) {

		Integer oldGameId;
		User user;
		PtsPlayer server;
		PtsGame game;

		oldGameId = (Integer) session.getAttribute("ptsGameId");
		if (oldGameId != null) {
			return true;
		}

		user = (User) session.getAttribute("user");
		game = new PtsGame();
		server = new PtsPlayer(user.getName(), game.getId());
		game.setServer(server);

		session.setAttribute("ptsGame", game);

		PtsGameMap.addGame(game);
		session.setAttribute("pointGamesMap", PtsGameMap.getGames());
		session.setAttribute("ptsGameId", game.getId());
		session.setAttribute("ptsUserType", "server");

		return true;
	}

	@RequestMapping(value = "/PointsConnectList.html")
	public String getGameList(HttpSession session) {

		Integer oldGameId;

		oldGameId = (Integer) session.getAttribute("ptsGameId");
		if (oldGameId != null) {
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

		char[] gameIdChar = gameId.toCharArray();
		Character.isDigit(gameIdChar[0]);

		if (Character.isDigit(gameIdChar[0])) {
			game = PtsGameMap.getGames().get(Integer.parseInt(gameId));
			client = new PtsPlayer(user.getName(), game.getId());
			game.setClient(client);
			session.setAttribute("ptsGame", game);
			session.setAttribute("ptsUserType", "client");
			session.setAttribute("ptsGameId", game.getId());
			PtsGameMap.deleteGameServer(game.getId());
			session.setAttribute("pointsGameServersMap",
					PtsGameMap.getGameServers());
			return true;
		}

		return false;
	}

	@RequestMapping(value = "/PointsRules.html")
	public String goToRules(HttpSession session) {

		return "Points/PointsRules";
	}

	@RequestMapping("/PointsStatistics.html")
	public String statistics(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");

		List<PtsStatistics> list = PtsStatistics.getAllStatistics();
		if (list.size() < 10) {
			model.addAttribute("ptsStatList", list);
		} else {
			model.addAttribute("ptsStatList", list.subList(0, 10));
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(user.getName())) {
				model.addAttribute("ptsMyPos", i + 1);
				model.addAttribute("ptsMyStats", list.get(i));
				break;
			}
		}
		return "Points/PointsStatistics";
	}

	@RequestMapping(value = "/PointsEndGameWinner.html")
	public String endOfGameWinner(HttpSession session) {

		PtsStatistics.win(((User) session.getAttribute("user")).getId());
		return "Points/PointsEndGameWinner";
	}

	@RequestMapping(value = "/PointsEndGameLooser.html")
	public String endOfGameLoser(HttpSession session) {

		PtsStatistics.lose(((User) session.getAttribute("user")).getId());
		return "Points/PointsEndGameLooser";
	}

	@RequestMapping(value = "/PointsGameExit.html", method = RequestMethod.POST)
	public String exitGame(HttpSession session) {

		PtsStatistics.lose(((User) session.getAttribute("user")).getId());
		return "";
	}

	@RequestMapping(value = "/PointsClearPointsGameSession.html", method = RequestMethod.POST)
	public @ResponseBody
	String clearGameSession(HttpSession session) {

		Integer gameId = (Integer) session.getAttribute("ptsGameId");

		synchronized (PtsGameMap.getGames()) {
			if (PtsGameMap.getGames().get(gameId) != null) {
				PtsGameMap.deleteGame(gameId);
				PtsGameMap.deleteGameServer(gameId);
			}
		}

		session.removeAttribute("ptsGame");
		session.removeAttribute("ptsUserType");
		session.removeAttribute("ptsGameId");

		return "";
	}

	@RequestMapping(value = "/PointsClearPointsMenuSession.html", method = RequestMethod.POST)
	public @ResponseBody
	String clearMenuSession(HttpSession session) {

		Integer gameId = (Integer) session.getAttribute("ptsGameId");

		synchronized (PtsGameMap.getGames()) {
			if (PtsGameMap.getGames().get(gameId) != null) {
				PtsGameMap.deleteGame(gameId);
				PtsGameMap.deleteGameServer(gameId);
			}
		}

		session.removeAttribute("ptsGame");
		session.removeAttribute("ptsUserType");
		session.removeAttribute("ptsGameId");
		session.removeAttribute("ptsGameMap");
		session.removeAttribute("pointsGameServersMap");

		return "";
	}

	@RequestMapping(value = "/PointsStopTimer.html", method = RequestMethod.POST)
	public @ResponseBody
	String stopTimer(HttpSession session) {

		PtsGame game = (PtsGame) session.getAttribute("ptsGame");
		game.stopTimer();
		
		return "";
	}
}
