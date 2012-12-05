/**
 * 
 * @author SergiyManko
 *
 */

package epam.ph.sg.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import epam.ph.sg.models.User;
import epam.ph.sg.models.sb.ActiveGames;
import epam.ph.sg.models.sb.BSBoard;
import epam.ph.sg.models.sb.BSPlayer;
import epam.ph.sg.models.sb.Client;
import epam.ph.sg.models.sb.Game;
import epam.ph.sg.models.sb.GamesList;
import epam.ph.sg.models.sb.SBStatistics;
import epam.ph.sg.models.sb.SbJSLoader;
import epam.ph.sg.models.sb.Server;

@Controller
@SessionAttributes("sbJSLoader")
public class SBMenuController {
	private static Logger log = Logger.getLogger(SBMenuController.class);

	// debug
	@RequestMapping(value = "/Sb.html"/* , method = RequestMethod.POST */)
	public String SbMenu(Model model, HttpSession session) {
		SbJSLoader sbJSLoader = new SbJSLoader();

		sbJSLoader.addScript("jquery");
		sbJSLoader.addScript("SB/SB_coords");
		log.debug("-------------------Added JavaScriptss-------------------");
		session.setAttribute("sbJSLoader", sbJSLoader);
		// session.setAttribute("currentPos", "Sb.html");
//		session.setAttribute("currentPos", "Sb.html");
		if (session.getAttribute("Game") == null) {
			return "SB/SbMenu";
		} else {
			
			Game g = (Game) session.getAttribute("Game");
			String connType = (String) session.getAttribute("ConnectionType");
			sbJSLoader.addScript("SB/jquery-ui-1.9.0");
			sbJSLoader.addScript("SB/SB");
			sbJSLoader.addScript("SB/js_stringify");
			sbJSLoader.addScript("SB/WebSocket");
			session.setAttribute("sbJSLoader", sbJSLoader);
			if (connType.equalsIgnoreCase("server")) {
				if (g.getServer().isStarted()) {
					return "SB/SbStart";
				} else {
					return "SB/Sb";
				}
			} else if (connType.equalsIgnoreCase("client")) {
				if (g.getClient().isStarted()) {
					return "SB/SbStart";
				} else {
					return "SB/Sb";
				}
			}
			return "SB/Sb";
		}
	}

	// Створення нового сервера гри
	@RequestMapping(value = { "/BsCreateGame.html" }, method = RequestMethod.POST)
	public String SbMenuCreation(HttpSession session, Model model) {

		log.debug("-------------------Added JavaScriptss-------------------");
		SbJSLoader sbJSLoader = (SbJSLoader) session.getAttribute("sbJSLoader");
		sbJSLoader.addScript("SB/jquery-ui-1.9.0");
		sbJSLoader.addScript("SB/SB");
		sbJSLoader.addScript("SB/js_stringify");
		sbJSLoader.addScript("SB/WebSocket");

		// BOBIK
		if (session.getAttribute("Game") == null) {
			Game game = GamesList.addGameToListBS();

			Server server = new Server();
			BSPlayer player = new BSPlayer();
			BSBoard board = new BSBoard();

			player.setName(((User) session.getAttribute("user")).getName());
			server.setPlayer(player);
			server.setGameBoard(board);
			game.setServer(server);
			game.setFirstTimeMoveRight();
			ActiveGames.addGame(game);
			session.setAttribute("Game", game);
			session.setAttribute("ConnectionType", "server");

		}
		// model.addAttribute("connectionType", "server");
		System.out.println("YOU HAVE BS-GAME");
		return "SB/Sb";
	}

	// Підєднання до одного з існуючих серверів
	// Список ігор
	@RequestMapping(value = { "/BsConectGame.html" }, method = RequestMethod.POST)
	public String SbMenuConnection(HttpSession session, Model model) {
		if (session.getAttribute("Game") != null) {
			return "SB/Sb";
		}
		log.debug("-------------------Added JavaScriptss-------------------");
		SbJSLoader sbJSLoader = (SbJSLoader) session.getAttribute("sbJSLoader");
		sbJSLoader.addScript("jquery");
		sbJSLoader.addScript("SB/SbGameList");
		log.debug("<--Test-->");
		Map<Integer, Game> serversMap = GamesList.getGameListBS();
		model.addAttribute("serverMap", serversMap);
		return "SB/SbGameList";
	}

	/**
	 * Підєднання клієнта до сервера
	 * 
	 */
	@RequestMapping(value = { "/SbGameSelected.html" }, method = RequestMethod.POST)
	public @ResponseBody
	String SbGameSelected(@RequestParam("gameID") int gameID,
			HttpSession session, Model model) {
		log.debug("*/*/*/*/*/*/*/*  GAME ID =" + gameID + "  /*/*/*/*/*/*/*/");
		Game selectedGame = GamesList.getGameListBS().get(gameID);
		Client client = new Client();
		BSPlayer player = new BSPlayer();
		BSBoard board = new BSBoard();
		player.setName(((User) session.getAttribute("user")).getName());
		client.setPlayer(player);
		client.setGameBoard(board);
		selectedGame.setClient(client);

		ActiveGames.getGame(gameID).setClient(client);
		try {
			ActiveGames.getGame(gameID).getServer().getConn().sendMessage("connected");
		} catch (IOException e) {
			e.printStackTrace();
		}
		session.setAttribute("Game", selectedGame);
		session.setAttribute("ConnectionType", "client");
		// Видаляєм гру до якої підєднався клієнт з мапи ігр що очікують на
		// клієнта
		GamesList.removeGameFromListBS(gameID);

		log.debug("---  START ---");
		log.debug("--- " + selectedGame + "  ---");
		log.debug("--- STOP  ---");
		return "OK";
	}

	@RequestMapping(value = "/BsGame.html", method = RequestMethod.POST)
	public String SbGame(Model model, HttpSession session) {
		SbJSLoader sbJSLoader = (SbJSLoader) session.getAttribute("sbJSLoader");
		sbJSLoader.addScript("SB/jquery-ui-1.9.0");
		sbJSLoader.addScript("SB/SB");
		sbJSLoader.addScript("SB/SB_coords");
		sbJSLoader.addScript("SB/SbGameList");
		sbJSLoader.addScript("SB/WebSocket");

		model.addAttribute("connectionType", "client");
		return "SB/Sb";
	}

	@RequestMapping(value = "/BsGameStart.html", method = RequestMethod.POST)
	public String SbGameStart(Model model, HttpSession session) {
		SbJSLoader sbJSLoader = (SbJSLoader) session.getAttribute("sbJSLoader");
		sbJSLoader.addScript("SB/jquery-ui-1.9.0");
		sbJSLoader.addScript("SB/SB");
		sbJSLoader.addScript("SB/SB_coords");
		sbJSLoader.addScript("SB/SbGameList");
		sbJSLoader.addScript("SB/WebSocket");

		return "SB/SbStart";
	}

	@RequestMapping(value = "/Victory.html", method = RequestMethod.POST)
	public String Victory(Model model, HttpSession session) {
		SbJSLoader sbJSLoader = (SbJSLoader) session.getAttribute("sbJSLoader");
		int gameId = ((Game) session.getAttribute("Game")).getId();
		SBStatistics.win(((User)session.getAttribute("user")).getId());
		log.debug("-//--//--//user id="+((User)session.getAttribute("user")).getId());
		session.removeAttribute("Game");
		session.removeAttribute("Sheeps");
		session.removeAttribute("ConnectionType");
		session.removeAttribute("mess");
		sbJSLoader.removeScript("js/SB/WebSocket.js");
		// ActiveGames.removeGame(gameId);
		GamesList.removeGameFromListBS(gameId);
		//session.setAttribute("currentPos", "Menu.html");
		return "SB/Victory";
	}

	@RequestMapping(value = "/Loose.html", method = RequestMethod.POST)
	public String Loose(Model model, HttpSession session) {
		SbJSLoader sbJSLoader = (SbJSLoader) session.getAttribute("sbJSLoader");
		SBStatistics.lose(((User)session.getAttribute("user")).getId());
		session.removeAttribute("Game");
		session.removeAttribute("Sheeps");
		session.removeAttribute("ConnectionType");
		session.removeAttribute("mess");
		sbJSLoader.removeScript("js/SB/WebSocket.js");
		//session.setAttribute("currentPos", "Menu.html");
		return "SB/Loose";
	}
	
	@RequestMapping(value = "/SbStop.html", method = RequestMethod.POST)
	public String StopSbGame(@RequestParam("connType") String connType,
			Model model, HttpSession session) {
		SbJSLoader sbJSLoader = (SbJSLoader) session.getAttribute("sbJSLoader");
		SBStatistics.lose(((User)session.getAttribute("user")).getId());
		Game g = (Game)session.getAttribute("Game");
		int gameId = g.getId();
		if(connType.equalsIgnoreCase("server") && g.getClient()!=null)
		{
			log.debug("+*+*+*+*+*+*===server+client="+ g.getClient());
			if(g.getClient().getConn()!=null)
			{
				try {
					g.getClient().getConn().sendMessage("kill");
				} catch (IOException e) {
					log.debug("no connection on client side");
				}
			}
		}
		else if(connType.equalsIgnoreCase("client") && g.getServer()!=null)
		{
			log.debug("+*+*+*+*+*+*===client");
			try {
				g.getServer().getConn().sendMessage("kill");
			} catch (IOException e) {
				log.debug("no connection on server side");
			}
		}
		GamesList.removeGameFromListBS(gameId);
		session.removeAttribute("Game");
		session.removeAttribute("Sheeps");
		session.removeAttribute("ConnectionType");
		session.removeAttribute("mess");
		sbJSLoader.removeScript("js/SB/WebSocket.js");
		return "SB/SbMenu";
	}
	
	
	@RequestMapping(value = "/SbKill.html", method = RequestMethod.POST)
	public String killSbGame(@RequestParam("connType") String connType,
			Model model, HttpSession session) {
		Game g = (Game)session.getAttribute("Game");
		int gameId = g.getId();
		GamesList.removeGameFromListBS(gameId);
		session.removeAttribute("Game");
		session.removeAttribute("Sheeps");
		session.removeAttribute("ConnectionType");
		session.removeAttribute("mess");
		return "SB/SbMenu";
	}

	@RequestMapping("/SBStatistics.html")
	public String sbstatistics(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		List<SBStatistics> list = SBStatistics.getAllStatistics();
		if (list.size() < 10) {
			model.addAttribute("xoStatList", list);
		} else {
			model.addAttribute("xoStatList", list.subList(0, 10));
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(user.getName())) {
				model.addAttribute("myPos", i + 1);
				model.addAttribute("myStats", list.get(i));
				break;
			}
		}
		return "SB/Statistics";
	}
	@RequestMapping(value = "/rules.html", method = RequestMethod.POST)
	public String rules(Model model, HttpSession session) {
		return "SB/Rules";
	}
}