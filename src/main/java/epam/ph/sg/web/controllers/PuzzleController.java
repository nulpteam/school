package epam.ph.sg.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

import epam.ph.sg.models.User;

public class PuzzleController {

	private static Logger log = Logger.getLogger(PuzzleController.class);

	@RequestMapping("/PuzzleGame.html")
	public String menu(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			log.info(request.getRequestURI() + " request received. User id="
					+ user.getId());
		} else {
			log.info(request.getRequestURI() + " request received.");
		}

		return "Tab/Puzzle";
	}

}
