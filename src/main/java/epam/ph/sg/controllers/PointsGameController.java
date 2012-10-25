package epam.ph.sg.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.points.PtsGame;
import epam.ph.sg.models.points.PtsGameMap;
import epam.ph.sg.models.points.PtsLastChanges;

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

	@RequestMapping(value = "/PointPut.html", method = RequestMethod.POST)
	public @ResponseBody
	String putPoint(@RequestParam("point_xy") String xy, HttpSession session) {

		String gameId = session.getAttribute("gameId").toString();
		String userType = session.getAttribute("userType").toString();
		PtsGame game = PtsGameMap.getGames().get(gameId); 
		
		game.putPoint(xy, userType);
		
		return userType;
	}

	@RequestMapping(value = "/PointsCheck.html", method = RequestMethod.GET)
	public @ResponseBody
		String check(HttpSession session) {
		return "String";
	}
	

	@RequestMapping(value = "/PointsGetChanges.html", method = RequestMethod.GET)
	public @ResponseBody
	PtsLastChanges put(HttpSession session) {
		
		String gameId = session.getAttribute("gameId").toString();
		PtsGame game = PtsGameMap.getGames().get(gameId); 
		
		System.out.println(game.getLasthangesInBoard().getCoordsOfChanges());
		System.out.println(game.getLasthangesInBoard().getUserThatChanged());
		return game.getLasthangesInBoard();
	}

}
