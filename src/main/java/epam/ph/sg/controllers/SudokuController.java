package epam.ph.sg.controllers;

/**
 * @author Paul Michael T.
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

	@RequestMapping("/SudokuMenu.html")
	public String menu(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		return "Tab/SudokuMenu";
	}

	@RequestMapping("/SudokuNewGame.html")
	public String newGame(@RequestParam("level") int level,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + ". Level: " + level);
		SudokuGame game = SudokuGame.getGame(level);
		request.getSession().setAttribute("sudoku", game);
		return "redirect:/SudokuGame.html";
	}

	@RequestMapping("/SudokuGame.html")
	public String game(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		if (request.getSession().getAttribute("sudoku") == null) {
			return "redirect:/Sudoku.html";
		}
		return "Tab/SudokuGame";
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
		int colum = Integer.valueOf(id.substring(1));
		return game.put(line, colum, value);
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
		SudokuBox[] failedArray = new SudokuBox[failed.size()];
		int i = 0;
		for (SudokuBox sudokuBox : failed) {
			failedArray[i] = sudokuBox;
			i++;
		}
		return failedArray;
	}
}
