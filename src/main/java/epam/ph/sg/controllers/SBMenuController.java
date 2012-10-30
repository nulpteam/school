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

import epam.ph.sg.models.sb.BSBoard;
import epam.ph.sg.models.sb.SbJSLoader;

@Controller
@SessionAttributes("sbJSLoader")
public class SBMenuController {
	
	private static HashMap<Integer, BSBoard> gameListBS;
	private static Integer gameID;
	public static HashMap<Integer, BSBoard> getGameListBS() {
		return gameListBS;
	}

	public static Integer addGameToListBS() {
		gameID++;
		gameListBS.put(gameID, new BSBoard());
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
	public String SbMenuCreation(Model model, HttpSession session) {
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
		return "SB/Sb";
	}
	
	@RequestMapping(value = { "/BsConectGame.html"}, method = RequestMethod.GET)
	public String SbMenuConnection(Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "Login";
		}
		log.debug("<--Test-->");
		return "SB/SbMenu";
	}
}