package epam.ph.sg.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import epam.ph.sg.models.User;
import epam.ph.sg.models.infection.INFStatistics;
import epam.ph.sg.models.infection.InfGame;
import epam.ph.sg.models.infection.InfGameMap;
import epam.ph.sg.models.infection.InfPlayer;

/*
 * author roman makovyak
 */

@Controller
@SessionAttributes("user")
public class InfectionMenuConroller {

	// Перехід на сторінку меню гри
	@RequestMapping("Infection.html")
	public String infMenu(HttpSession session) {
		return "Infection/InfectionMenu";
	}

	// перехід на сторінку гри
	@RequestMapping("InfectionGame.html")
	public String infGame(HttpSession session) {
		return "Infection/InfectionGame";
	}

	// перехід на сторінку переможця гри
	@RequestMapping("InfectionWin.html")
	public String infWinGame(HttpSession session) {
		return "Infection/InfectionGameWin";
	}

	// перехід на сторінку програвшого
	@RequestMapping("InfectionLose.html")
	public String infLoseGame(HttpSession session) {
		return "Infection/InfectionGameLose";
	}

	// перехід на сторінку правил
	@RequestMapping("InfectionRules.html")
	public String infGameRules(HttpSession session) {
		return "Infection/InfectionRules";
	}

	// створення нової гри
	@RequestMapping(value = "/InfectionCreateGame.html", method = RequestMethod.GET)
	public @ResponseBody
	boolean createGame(HttpSession session) {

		String oldGameId;
		User user;
		InfPlayer server;
		InfGame game;

		// якщо в сесії є гра то повертає на сторінку гри
		oldGameId = (String) session.getAttribute("infGameId");
		if (oldGameId != null) {
			return true;
		}
		// якщо ні проводиться створення нової гри
		user = (User) session.getAttribute("user");
		game = new InfGame();// нова гра
		server = new InfPlayer(user.getName(), game.getId());// новий гравець
		game.setServer(server);// встановлюємо сервер
		InfGameMap.addGame(game);// додаємо гру в список ігор

		session.setAttribute("userId", user.getId());
		session.setAttribute("infGamesMap", InfGameMap.getGames());
		session.setAttribute("infGameId", game.getId());
		session.setAttribute("infUserType", "server");

		return true;
	}

	@RequestMapping(value = "/InfectionConnect.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean connectToGame(@RequestParam("gameId") String gameId,
			HttpSession session) {

		InfPlayer client;
		User user;
		InfGame game;

		user = (User) session.getAttribute("user");
		game = InfGameMap.getGames().get(gameId);
		client = new InfPlayer(user.getName(), game.getId());
		game.setClient(client);

		session.setAttribute("userId", user.getId());
		session.setAttribute("infUserType", "client");
		session.setAttribute("infGameId", game.getId());

		return true;
	}

	@RequestMapping(value = "/InfectionConnectList.html")
	public String getGameList(HttpSession session) {

		String oldGameId = null;

		session.setAttribute("infGamesMap", InfGameMap.getGames());
		oldGameId = (String) session.getAttribute("infGameId");
		if (oldGameId != null) {
			return "redirect:/InfectionGame.html";
		} else {
			return "Infection/InfectionGameList";
		}

	}

	@RequestMapping(value = "/InfectionGameExit.html")
	public String quitGame(HttpSession session) {

		String gameID;

		gameID = (String) session.getAttribute("infGameId");
		InfGameMap.deleteGame(gameID);
		session.removeAttribute("infGamesMap");
		session.removeAttribute("infGameId");
		session.removeAttribute("infUserType");

		return "Infection/InfectionMenu";
	}

	@RequestMapping(value = "/InfectionStatistic.html")
	public String getGameStatistic(HttpSession session) {

		List<INFStatistics> statisticsList = INFStatistics.getAllStatistics();
		session.setAttribute("infectionStatisticList", statisticsList);

		return "Infection/InfectionStatistic";
	}

}
