package epam.ph.sg.controllers;

/**
 * @author Talash Pavlo
 */
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.User;
import epam.ph.sg.tab.sudoku.SudokuBox;
import epam.ph.sg.tab.sudoku.SudokuGame;

@Controller
public class SudokuController {
	private static Logger log = Logger.getLogger(SudokuController.class);

	@RequestMapping("/Sudoku.html")
	public String menu(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		if (request.getSession().getAttribute("sudoku") == null) {
			request.getSession().setAttribute("sudoku", SudokuGame.getGame(1));
		}
		return "Tab/Sudoku";
	}

	@RequestMapping("/SudokuNewGame.html")
	public String newGame(@RequestParam("level") int level,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + ". Level: " + level);
		request.getSession().setAttribute("sudoku", SudokuGame.getGame(level));
		return "Tab/Sudoku";
	}

	@RequestMapping("/SudokuPut.html")
	public @ResponseBody
	boolean put(@RequestParam("id") String id,
			@RequestParam("value") int value, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + ". Position: " + id);
		SudokuGame game = (SudokuGame) request.getSession().getAttribute(
				"sudoku");
		int line = Integer.valueOf(id.substring(0, 1));
		int column = Integer.valueOf(id.substring(1));
		return game.tryToPut(line, column, value);
	}

	@RequestMapping("/SudokuGetFailed.html")
	public @ResponseBody
	SudokuBox[] getFailed(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		SudokuGame game = (SudokuGame) request.getSession().getAttribute(
				"sudoku");
		Set<SudokuBox> failed = game.getFailed();
		return failed.toArray(new SudokuBox[failed.size()]);
	}
}
