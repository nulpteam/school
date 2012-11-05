/**
 * 
 * @author SergiyManko
 *
 */

package epam.ph.sg.controllers;

import java.io.IOException;
import java.util.Map;

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
import epam.ph.sg.models.sb.SbJSLoader;
import epam.ph.sg.models.sb.Server;

@Controller
@SessionAttributes("sbJSLoader")
public class SBMenuController {
	private static Logger log = Logger.getLogger(SBMenuController.class);

	// debug
	@RequestMapping(value = "/Sb.html", method = RequestMethod.GET)
	public String SbMenu(Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "Login";
		}
		SbJSLoader sbJSLoader = new SbJSLoader();

		sbJSLoader.addScript("jquery");
		sbJSLoader.addScript("SB/SB_coords");
		log.debug("-------------------Added JavaScriptss-------------------");
		session.setAttribute("sbJSLoader", sbJSLoader);
		return "SB/SbMenu";
	}

	// Створення нового сервера гри
	@RequestMapping(value = { "/BsCreateGame.html" }, method = RequestMethod.GET)
	public String SbMenuCreation(HttpSession session, Model model) {
		
		log.debug("-------------------Added JavaScriptss-------------------");
		SbJSLoader sbJSLoader = (SbJSLoader) session.getAttribute("sbJSLoader");
		sbJSLoader.addScript("SB/jquery-ui-1.9.0");
		sbJSLoader.addScript("SB/SB");
		sbJSLoader.addScript("SB/js_stringify");
		sbJSLoader.addScript("SB/WebSocket");
		
			
		//BOBIK
		if (session.getAttribute("Game") == null)
		{
			Game game = GamesList.addGameToListBS();
			
			Server server = new Server();
			BSPlayer player = new BSPlayer();
			BSBoard board = new BSBoard();
			
			
			player.setName(((User) session.getAttribute("user")).getName());
			server.setPlayer(player);
			server.setGameBoard(board);
			game.setServer(server);
			ActiveGames.addGame(game);
			session.setAttribute("Game",game);
			
		}
		model.addAttribute("connectionType", "server");
		System.out.println("YOU HAVE BS-GAME");
		return "SB/Sb";
	}

	// Підєднання до одного з існуючих серверів
	// Список ігор
	@RequestMapping(value = { "/BsConectGame.html" }, method = RequestMethod.GET)
	public String SbMenuConnection(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "Login";
		}
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
	 *Підєднання клієнта до сервера 
	 * 
	 */
	@RequestMapping(value = { "/SbGameSelected.html" }, method = RequestMethod.POST)
	public @ResponseBody
	String SbGameSelected(@RequestParam("gameID") int gameID,
			HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "Login";
		}
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
		model.addAttribute("connectionType", "client");
		
		
		
		
		session.setAttribute("Game", selectedGame);
		log.debug("---  START ---");
		log.debug("--- " + selectedGame + "  ---");
		log.debug("--- STOP  ---");
		return "OK";
	}

	
	@RequestMapping(value = "/BsGame.html", method = RequestMethod.GET)
	public String SbGame(Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "Login";
		}
		SbJSLoader sbJSLoader = (SbJSLoader) session.getAttribute("sbJSLoader");
		sbJSLoader.addScript("SB/jquery-ui-1.9.0");
		sbJSLoader.addScript("SB/SB");
		sbJSLoader.addScript("SB/SB_coords");
		sbJSLoader.addScript("SB/SbGameList");	
		sbJSLoader.addScript("SB/WebSocket");
		
		model.addAttribute("connectionType", "client");
		return "SB/Sb";
	}
	
	@RequestMapping(value = "/BsGameStart.html", method = RequestMethod.GET)
	public String SbGameStart(Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "Login";
		}
		SbJSLoader sbJSLoader = (SbJSLoader) session.getAttribute("sbJSLoader");
		sbJSLoader.addScript("SB/jquery-ui-1.9.0");
		sbJSLoader.addScript("SB/SB");
		sbJSLoader.addScript("SB/SB_coords");
		sbJSLoader.addScript("SB/SbGameList");	
		sbJSLoader.addScript("SB/WebSocket");
		
		return "SB/SbStart";
	}
	
	
	
	
	/**
	 * Тест - стерти коли стане не потрібним
	 */
	 
	@RequestMapping(value = { "/Test.html" }, method = RequestMethod.GET)
	public @ResponseBody
	String test(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "Login";
		}
		
		//!
		Game game = ActiveGames.getGame(1);
		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
				+ game.getServer().getConn());
		log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
				+ game.getClient().getConn());
		try {
			game.getServer().getConn().sendMessage("fiskult-privet Server");
			game.getClient().getConn().sendMessage("fiskult-privet Client");
			game.getServer().getConn().sendMessage(game.getServer().getGameBoard().toString());
			game.getClient().getConn().sendMessage(game.getClient().getGameBoard().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "OK";
	}

}