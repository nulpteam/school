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
import epam.ph.sg.models.sb.BSGame;
import epam.ph.sg.models.sb.BSPlayer;
import epam.ph.sg.models.sb.GamesList;
import epam.ph.sg.models.sb.SbJSLoader;

@Controller
@SessionAttributes("sbJSLoader")
public class SBMenuController {
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
			
			int gameID = GamesList.addGameToListBS();
			BSGame game = GamesList.getGameListBS().get(gameID);
			BSPlayer player1 = new BSPlayer();
			player1.setName(((User)session.getAttribute("user")).getName());
			game.setPlayer1(player1);
			session.setAttribute("BSGame", game);
			//TODO
			System.out.println(game);
			System.out.println(game.getId());
			System.out.println(game.getPlayer1().getName());
			// TODO
		}
		System.out.println("YOU HAVE BS-GAME");
		return "SB/Sb";
	}
	
	@RequestMapping(value = {"/BsConectGame.html"}, method = RequestMethod.GET)
	public String SbMenuConnection(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "Login";
		}
		if (session.getAttribute("BSGame") != null) {
			return "SB/Sb";
		}
		log.debug("-------------------Added JavaScriptss-------------------");
		SbJSLoader sbJSLoader = (SbJSLoader) session.getAttribute("sbJSLoader");
		sbJSLoader.addScript("jquery");
		sbJSLoader.addScript("SB/SbGameList");
		log.debug("<--Test-->");
		Map<Integer, BSGame> serversMap = GamesList.getGameListBS();
		for (Map.Entry<Integer, BSGame> entry : serversMap.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		model.addAttribute("serverMap", serversMap);
		return "SB/SbGameList";
	}
	
	
	
	/*БРЄД*/
	@RequestMapping(value = {"/SbGameSelected.html"}, method = RequestMethod.POST)
	public @ResponseBody String SbGameSelected(@RequestParam("gameID") int gameID,
	HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "Login";
		}
		log.debug("*/*/*/*/*/*/*/*  GAME ID ="+gameID+"  /*/*/*/*/*/*/*/");
		BSGame selectedGame = GamesList.getGameListBS().get(gameID);
				
		BSPlayer player2 = new BSPlayer();
		player2.setName(((User)session.getAttribute("user")).getName());
		selectedGame.setPlayer2(player2);
		session.setAttribute("BSGame", selectedGame);
		log.debug("---  START ---");
		log.debug("--- selectedGame id= "+ selectedGame.getId() +"  ---");
		log.debug("--- selectedGame player2 name= "+ selectedGame.getPlayer2().getName() +"  ---");
		log.debug("---   ---");
		log.debug("---   ---");
		log.debug("---   ---");
		log.debug("---   ---");
		log.debug("---   ---");
		log.debug("--- STOP  ---");
		return "OK";
	}
	
	
	
	
	@RequestMapping(value = {"/Test.html"}, method = RequestMethod.GET)
	public @ResponseBody String test(HttpSession session, Model model) {
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "Login";
		}
		
		
	log.debug("---Sending Websoc to player 2   ---");
	try {
		BSGame game = (BSGame)session.getAttribute("BSGame");
		log.debug("---"+game.getConnection1().hashCode()+"---");
		log.debug("---"+game.getConnection2().hashCode()+"---");
		game.getConnection1().sendMessage("Привіт плейер 1");
		game.getConnection2().sendMessage("Привіт плейер 2");
	} catch (IOException e) {
		e.printStackTrace();
	}
	return "OK";
	}
	
	
	
	
}