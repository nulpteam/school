package epam.ph.sg.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PointsGameController {

	private static Logger log = Logger.getLogger(PointsGameController.class);

	@RequestMapping(value = "/PointsGame.html")
	public String pointsGame(HttpSession session) {
		
		if (session.getAttribute("user") == null) {
			new HomeController().index(session);
			return "redirect:/index.html";
		}
	
		return "Points/PointsGame";
	}
	
	@RequestMapping(value = "/PointsCheck.html", method = RequestMethod.POST)
	public @ResponseBody 
	String put(@RequestParam("point_xy") String xy, HttpSession session) {
		return "\'../images/Points/point_hover.png\'";
	}
	
	@RequestMapping(value = "/PointsGetChanges.html", method = RequestMethod.GET)
	public @ResponseBody String getChanges(HttpSession session) {
		return "\'../images/Points/point_hover.png\'";
	}

}
