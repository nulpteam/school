package epam.ph.sg.controllers;

/**
 * @author Gutey Bogdan
 */
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import epam.ph.sg.models.sb.ActiveGames;
import epam.ph.sg.models.sb.BSBoard;
import epam.ph.sg.models.sb.BSSheeps;
import epam.ph.sg.models.sb.Game;
import epam.ph.sg.models.sb.JsonParser;

@Controller
@SessionAttributes("sbJSLoader")
public class SBController {
	private static Logger log = Logger.getLogger(SBController.class);

	

	@RequestMapping(value = { "/init_sheeps.html" }, method = RequestMethod.POST)
	public @ResponseBody
	String sheeps_init(@RequestParam("sheeps") String sheeps,
			Model model,	HttpSession session) {
		
		String connectionType = (String)session.getAttribute("ConnectionType");
		int gameID = (int)((Game)session.getAttribute("Game")).getId();
		JsonParser jp = new JsonParser();
		BSBoard sc = jp.parseJsonSheepsCoordenates(sheeps);
		if(connectionType.equalsIgnoreCase("server"))
		{
			ActiveGames.getGame(gameID).getServer().setGameBoard(sc);
		}
		if(connectionType.equalsIgnoreCase("client"))
		{
			ActiveGames.getGame(gameID).getClient().setGameBoard(sc);
		}
		
		return "Server says: array recieved! ;-)"+sc ;
	}

	
	@RequestMapping(value = {"/fire.html"}, method = RequestMethod.POST)
	public @ResponseBody
	String fireReciever(@RequestParam("firePoint") String firePoint,
			Model model, HttpSession session) {
		String connectionType = (String)session.getAttribute("ConnectionType");
		int gameID = (int)((Game)session.getAttribute("Game")).getId();
		log.debug(firePoint);
		log.debug(connectionType);
		log.debug(gameID);
		String fp = Game.fireCheck(gameID, connectionType, firePoint);
		log.debug(fp);
			return  fp;
	}

	
	@RequestMapping(value = {"/sheepsReady.html"}, method = RequestMethod.POST)
	public @ResponseBody String SheepsReady(@RequestParam("sheepsReady") String sheepsReady,
			Model model, HttpSession session) {
		
		JsonParser jp = new JsonParser();
		BSSheeps sheeps = jp.parseJsonSheepsReady(sheepsReady);
		log.debug("ttteeesssttt  "+sheeps);
		session.setAttribute("Sheeps", sheeps);
		return "OK";
	}
	
}
