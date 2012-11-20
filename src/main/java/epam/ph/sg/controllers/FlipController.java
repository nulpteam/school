package epam.ph.sg.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.User;
import epam.ph.sg.tab.flip.FlipGame;
import epam.ph.sg.tab.flip.FlipStatus;

@Controller
public class FlipController {
	private static Logger log = Logger.getLogger(FlipController.class);

	@RequestMapping("/FlipGame.html")
	public String game(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		FlipGame game = (FlipGame) request.getSession()
				.getAttribute("flipGame");
		if (game == null) {
			request.getSession().setAttribute("flipGame", new FlipGame(1));
		}
		return "Tab/Flip";
	}

	@RequestMapping("/FlipNewGame.html")
	public String newGame(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		request.getSession().setAttribute("flipGame", new FlipGame(1));
		return "Tab/Flip";
	}

	@RequestMapping("/FlipNextLevel.html")
	public String gameLevel(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		FlipGame game = (FlipGame) request.getSession()
				.getAttribute("flipGame");
		game.nextLevel();
		return "Tab/Flip";
	}

	@RequestMapping("/FlipResetLevel.html")
	public String resetGame(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		FlipGame game = (FlipGame) request.getSession()
				.getAttribute("flipGame");
		game.resetLevel();
		return "Tab/Flip";
	}

	@RequestMapping("/Flip.html")
	public @ResponseBody
	boolean flip(@RequestParam("id") String id, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + ". Position: " + id);
		int line = Integer.valueOf(id.substring(0, 1));
		int colum = Integer.valueOf(id.substring(1));
		FlipGame game = (FlipGame) request.getSession()
				.getAttribute("flipGame");
		game.flip(line, colum);
		return true;
	}

	@RequestMapping("FlipStatus.html")
	public @ResponseBody
	FlipStatus getStatus(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		FlipGame game = (FlipGame) request.getSession()
				.getAttribute("flipGame");
		return game.getStatus();
	}
}
