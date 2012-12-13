package epam.ph.sg.web.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.utils.PuzzleUtils;

@Controller
public class PuzzleController {

	@RequestMapping(value = "/PuzzleGame.html")
	public String menu(HttpSession session) {

		if (session.getAttribute("puzzlegame") == null)
			session.setAttribute("puzzlegame", true);
		if (session.getAttribute("puzzle_endgame") == null)
			session.setAttribute("puzzle_endgame", false);
		return "Tab/Puzzle";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/PuzzleGetBoard.html")
	public @ResponseBody
	List<Integer> getBoard(HttpSession session) {

		if ((Boolean) session.getAttribute("puzzlegame") == true) {
			List<Integer> board = PuzzleUtils.getBoard();
			session.setAttribute("puzzlegame", false);
			session.setAttribute("puzzleboard", board);
			return board;
		} else {
			return (List<Integer>) session.getAttribute("puzzleboard");
		}

	}

	@RequestMapping(value = "/PuzzleGetEndGameState.html")
	public @ResponseBody
	Boolean getEndGameState(HttpSession session) {

		return (Boolean) session.getAttribute("puzzle_endgame");
	}

	@RequestMapping(value = "/PuzzleSaveBoard.html", method = RequestMethod.POST)
	public @ResponseBody
	String saveBoard(@RequestParam("board") String board, HttpSession session) {

		session.setAttribute("puzzleboard", PuzzleUtils.parseBoard(board));
		return "";
	}

	@RequestMapping(value = "/PuzzleExit.html")
	public @ResponseBody
	String exit(HttpSession session) {

		session.removeAttribute("puzzlegame");
		session.removeAttribute("puzzleboard");
		session.removeAttribute("puzzle_endgame");
		return "";
	}

	@RequestMapping(value = "/PuzzleEndGame.html")
	public @ResponseBody
	String endGame(HttpSession session) {

		session.setAttribute("puzzle_endgame", true);
		return session.getAttribute("puzzle_endgame").toString();
	}

}
