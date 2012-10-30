/**
 * 
 * @author SergiyManko
 *
 */

package epam.ph.sg.controllers;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import epam.ph.sg.models.User;
import epam.ph.sg.models.sb.BSGame;
import epam.ph.sg.models.sb.BSPlayer;
import epam.ph.sg.models.sb.SbJSLoader;

@Controller
@SessionAttributes("sbJSLoader")
public class SBMenuController {
	
	private static HashMap<Integer, BSGame> gameListBS;
	private static Integer gameID;
	
	public SBMenuController() {
		gameID = 0;
		gameListBS = new HashMap<Integer, BSGame>();
	}
	public static HashMap<Integer, BSGame> getGameListBS() {
		return gameListBS;
	}

	public static Integer addGameToListBS() {
		gameID++;
		gameListBS.put(gameID, new BSGame(gameID.intValue()));
		return gameID;
	}
	public static void removeGameFromListBS(Integer id) {
		gameListBS.remove(id);
	}

	private static Logger log = Logger.getLogger(SBMenuController.class);
	
	@RequestMapping(value = "/Sb.html" , method = RequestMethod.GET)
	public String SbMenu(Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "Login";
		}
		SbJSLoader sbJSLoader = new SbJSLoader();
		
		sbJSLoader.addScript("jquery");
		sbJSLoader.addScript("SB/SB_coords");
		log.debug("****************"+sbJSLoader.getScripts());

		log.debug("-------------------Added JavaScriptss-------------------");
		session.setAttribute("sbJSLoader", sbJSLoader);
		return "SB/SbMenu";
	}
	
	@RequestMapping(value = { "/BsCreateGame.html"}, method = RequestMethod.GET)
	public String SbMenuCreation(HttpSession session) {
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "Login";
		}

		log.debug("-------------------Added JavaScriptss-------------------");
		SbJSLoader sbJSLoader = (SbJSLoader) session.getAttribute("sbJSLoader");
		sbJSLoader.addScript("SB/jquery-ui-1.9.0");
		sbJSLoader.addScript("SB/SB");
		sbJSLoader.addScript("SB/js_stringify");
		sbJSLoader.addScript("SB/WebSocket");
		if (session.getAttribute("BSGame") == null) {
			addGameToListBS();
			BSGame game = gameListBS.get(gameID);
			BSPlayer player1 = new BSPlayer();
			player1.name = ((User)session.getAttribute("user")).getName();
			game.setPlayer1(player1);
			session.setAttribute("BSGame", game);
			//TODO
			System.out.println(game);
			System.out.println(game.getId());
			System.out.println(game.getPlayer1().name);
			// TODO
		}
		System.out.println("YOU HAVE BS-GAME");
		return "SB/Sb";
	}
	
	@RequestMapping(value = {"/BsConectGame.html"}, method = RequestMethod.GET)
	public String SbMenuConnection(HttpSession session) {
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "Login";
		}
		if (session.getAttribute("BSGame") != null) {
			return "SB/Sb";
		}
		log.debug("<--Test-->");
		return "SB/SbGameList";
	}
}