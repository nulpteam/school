package epam.ph.sg.controllers;

/**
 * @author Talash Pavlo
 */
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.User;
import epam.ph.sg.tab.flipper.FlipperGame;
import epam.ph.sg.tab.flipper.FlipperStatus;

@Controller
public class FlipperController {
	private static Logger log = Logger.getLogger(FlipperController.class);

	@RequestMapping("/FlipperGame.html")
	public String game(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		FlipperGame game = (FlipperGame) request.getSession().getAttribute(
				"flipperGame");
		if (game == null) {
			request.getSession()
					.setAttribute("flipperGame", new FlipperGame(1));
		}
		return "Tab/Flipper";
	}

	@RequestMapping("/FlipperNewGame.html")
	public String newGame(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		request.getSession().setAttribute("flipperGame", new FlipperGame(1));
		return "Tab/Flipper";
	}

	@RequestMapping("/FlipperNextLevel.html")
	public String gameLevel(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		FlipperGame game = (FlipperGame) request.getSession().getAttribute(
				"flipperGame");
		game.nextLevel();
		return "Tab/Flipper";
	}

	@RequestMapping("/FlipperResetLevel.html")
	public String resetGame(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		FlipperGame game = (FlipperGame) request.getSession().getAttribute(
				"flipperGame");
		game.resetLevel();
		return "Tab/Flipper";
	}

	@RequestMapping("/Flip.html")
	public @ResponseBody
	boolean flip(@RequestParam("id") String id, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + ". Position: " + id);
		int line = Integer.valueOf(id.substring(0, 1));
		int column = Integer.valueOf(id.substring(1));
		FlipperGame game = (FlipperGame) request.getSession().getAttribute(
				"flipperGame");
		game.flip(line, column);
		return true;
	}

	@RequestMapping("FlipperStatus.html")
	public @ResponseBody
	FlipperStatus getStatus(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		FlipperGame game = (FlipperGame) request.getSession().getAttribute(
				"flipperGame");
		return game.getStatus();
	}
}
