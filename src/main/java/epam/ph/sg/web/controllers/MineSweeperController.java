package epam.ph.sg.web.controllers;

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
import epam.ph.sg.tab.minesweeper.MSBox;
import epam.ph.sg.tab.minesweeper.MSGame;
import epam.ph.sg.tab.minesweeper.MSMapCreator;
import epam.ph.sg.tab.minesweeper.MSStatus;

@Controller
public class MineSweeperController {
	private static Logger log = Logger.getLogger(MineSweeperController.class);

	@RequestMapping("/MSGame.html")
	public String game(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			log.info(request.getRequestURI() + " request received. User id="
					+ user.getId());
		} else {
			log.info(request.getRequestURI() + " request received.");
		}
		if (request.getSession().getAttribute("mineSweeper") == null) {
			request.getSession().setAttribute("mineSweeper",
					MSMapCreator.newGame(10, 10, 10));
		}
		return "Tab/MineSweeper";
	}

	@RequestMapping("/MSNewGame.html")
	public String newGame(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			log.info(request.getRequestURI() + " request received. User id="
					+ user.getId());
		} else {
			log.info(request.getRequestURI() + " request received.");
		}
		request.getSession().setAttribute("mineSweeper",
				MSMapCreator.newGame(10, 10, 10));
		return "Tab/MineSweeper";
	}

	@RequestMapping("/MSLock.html")
	public @ResponseBody
	void lock(@RequestParam("id") String id, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			log.info(request.getRequestURI() + " request received. User id="
					+ user.getId());
		} else {
			log.info(request.getRequestURI() + " request received.");
		}
		MSGame game = (MSGame) request.getSession().getAttribute("mineSweeper");
		int line = Integer.valueOf(id.substring(0, 1));
		int column = Integer.valueOf(id.substring(1));
		game.lock(line, column);
	}

	@RequestMapping("/MSOpen.html")
	public @ResponseBody
	MSBox put(@RequestParam("id") String id, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			log.info(request.getRequestURI() + " request received. User id="
					+ user.getId());
		} else {
			log.info(request.getRequestURI() + " request received.");
		}
		MSGame game = (MSGame) request.getSession().getAttribute("mineSweeper");
		int line = Integer.valueOf(id.substring(0, 1));
		int column = Integer.valueOf(id.substring(1));
		game.tryToOpen(line, column);
		return game.getField().get(line).get(column);
	}

	@RequestMapping("/MSRefresh.html")
	public @ResponseBody
	MSBox[][] refresh(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			log.info(request.getRequestURI() + " request received. User id="
					+ user.getId());
		} else {
			log.info(request.getRequestURI() + " request received.");
		}
		MSGame game = (MSGame) request.getSession().getAttribute("mineSweeper");
		MSBox[][] array = new MSBox[game.getField().size()][];
		for (int i = 0; i < game.getField().size(); i++) {
			array[i] = game.getField().get(i)
					.toArray(new MSBox[game.getField().get(i).size()]);
		}
		return array;
	}

	@RequestMapping("/MSGetStatus.html")
	public @ResponseBody
	MSStatus getStatus(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			log.info(request.getRequestURI() + " request received. User id="
					+ user.getId());
		} else {
			log.info(request.getRequestURI() + " request received.");
		}
		MSGame game = (MSGame) request.getSession().getAttribute("mineSweeper");
		return game.getStatus();
	}
}
