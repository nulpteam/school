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

		String userType = session.getAttribute("ptsUserType").toString();
		PtsGame game = (PtsGame) session.getAttribute("ptsgame"); 
		
		game.putPoint(xy, userType);
		
		return userType;
	}

	@RequestMapping(value = "/PointsCheck.html", method = RequestMethod.GET)
	public @ResponseBody
		String check(HttpSession session) {
		return "String";
	}
	
	@RequestMapping(value = "/PointCheckMove.html", method = RequestMethod.GET)
	public @ResponseBody
		boolean checkMove(HttpSession session) {
		
		PtsGame game =  (PtsGame) session.getAttribute("ptsgame");
		String userType = session.getAttribute("ptsUserType").toString();
		if (game.getClient() == null) {
			return false;
		}
		return game.isUserMove(userType);
	}
	

	@RequestMapping(value = "/PointsGetChanges.html", method = RequestMethod.GET)
	public @ResponseBody
	PtsLastChanges put(HttpSession session) {

		PtsGame game = (PtsGame) session.getAttribute("ptsgame");
		String userType = session.getAttribute("ptsUserType").toString();
		
		return game.getLasthangesInBoard(userType);
	}
	
	@RequestMapping(value = "/WaitingForClient.html", method = RequestMethod.GET)
	public @ResponseBody
	String getClient(HttpSession session) {

		PtsGame game = (PtsGame) session.getAttribute("ptsgame");
		if(game.getClient() == null)
			return "";
		
		return game.getClient().getName();
	}

}
