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

import epam.ph.sg.models.sb.BSBoard;
import epam.ph.sg.models.sb.JsonParser;
import epam.ph.sg.models.sb.SbJSLoader;

@Controller
@SessionAttributes("sbJSLoader")
public class SBController {
	private static Logger log = Logger.getLogger(SBController.class);

//	@RequestMapping(value = { "/BS.html", "/Sb" }, method = RequestMethod.GET)
//	public String SbMenu(Model model, HttpSession session) {
//		if (session.getAttribute("user") == null) {
//			new HomeController().index(session);
//			return "Login";
//		}
//		SbGame sbGame = new SbGame();
//		sbGame.addScript("jquery");
//		sbGame.addScript("SB/SB_coords");
//
//		log.debug("-------------------Added JavaScriptss-------------------");
//		model.addAttribute(sbGame);
//		return "SB/SbMenu";
//	}

	@RequestMapping(value = { "/BsGame.html", "/Bs" }, method = RequestMethod.GET)
	public String SbGame(Model model, HttpSession session) {
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

	@RequestMapping(value = { "/init_sheeps.html" }, method = RequestMethod.POST)
	public @ResponseBody
	String sheeps_init(@RequestParam("sheeps") String sheeps, Model model,
			HttpSession session) {
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "Login";
			// new HomeController().index(session);

		}
		log.debug("sheeps" + sheeps);
		JsonParser jp = new JsonParser();
		BSBoard sc = jp.parseJsonSheepsCoordenates(sheeps);
		return "Server says: array recieved! ;-)"+sc ;
	}

	@RequestMapping(value = { "/fire.html" }, method = RequestMethod.POST)
	public @ResponseBody
	String fireReciever(@RequestParam("firePoint") String firePoint,
			Model model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "Login";
		}
		
			return  firePoint;
		

	}

}
