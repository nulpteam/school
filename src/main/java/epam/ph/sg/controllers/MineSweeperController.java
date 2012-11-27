package epam.ph.sg.controllers;

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

@Controller
public class MineSweeperController {
	private static Logger log = Logger.getLogger(MineSweeperController.class);

	@RequestMapping("/MSGame.html")
	public String game(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		if (request.getSession().getAttribute("mineSweeper") == null) {
			request.getSession().setAttribute("mineSweeper",
					MSMapCreator.newGame(10, 10, 10));
		}
		return "Tab/MineSweeper";
	}

	@RequestMapping("/MSNewGame.html")
	public String newGame(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		request.getSession().setAttribute("mineSweeper",
				MSMapCreator.newGame(10, 10, 10));
		return "Tab/MineSweeper";
	}
	
	@RequestMapping("/MSLock.html")
	public @ResponseBody
	boolean lock(@RequestParam("id") String id, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		MSGame game = (MSGame) request.getSession().getAttribute("mineSweeper");
		int line = Integer.valueOf(id.substring(0, 1));
		int colum = Integer.valueOf(id.substring(1));
		game.lock(line, colum);
		return game.isWin();
	}

	@RequestMapping("/MSPut.html")
	public @ResponseBody
	boolean put(@RequestParam("id") String id, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		MSGame game = (MSGame) request.getSession().getAttribute("mineSweeper");
		int line = Integer.valueOf(id.substring(0, 1));
		int colum = Integer.valueOf(id.substring(1));
		game.put(line, colum);
		return game.isLose();
	}

	@RequestMapping("/MSRefresh.html")
	public @ResponseBody
	MSBox[][] refresh(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		MSGame game = (MSGame) request.getSession().getAttribute("mineSweeper");
		MSBox[][] array = new MSBox[game.getField().size()][];
		for (int i = 0; i < game.getField().size(); i++) {
			array[i] = game.getField().get(i)
					.toArray(new MSBox[game.getField().get(i).size()]);
		}
		return array;
	}
}
