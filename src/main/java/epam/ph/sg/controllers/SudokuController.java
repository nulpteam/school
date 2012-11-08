package epam.ph.sg.controllers;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.sudoku.SudokuBox;
import epam.ph.sg.sudoku.SudokuGame;

@Controller
public class SudokuController {

	@RequestMapping("/Sudoku.html")
	public String sudoku(HttpSession session) {
		if (session.getAttribute("sudoku") == null) {
			session.setAttribute("sudoku", SudokuGame.getGame());
		}
		return "Tab/Sudoku";
	}

	@RequestMapping("/SudokuNewGame.html")
	public @ResponseBody
	int[] newGame(HttpSession session) {
		SudokuGame game = SudokuGame.getGame();
		session.setAttribute("sudoku", game);
		int[] values1 = new int[81];
		int[][] values2 = game.getStaticValues();
		int x = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				values1[x] = values2[i][j];
				x++;
			}
		}
		return values1;
	}

	@RequestMapping("/SudokuPut.html")
	public @ResponseBody
	boolean put(@RequestParam("id") String id,
			@RequestParam("value") int value, HttpSession session) {
		SudokuGame game = (SudokuGame) session.getAttribute("sudoku");
		int line = Integer.valueOf(id.substring(0, 1));
		int colum = Integer.valueOf(id.substring(1));
		return game.put(line, colum, value);
	}

	@RequestMapping("/SudokuGetFailed.html")
	public @ResponseBody
	SudokuBox[] getFailed(HttpSession session) {
		SudokuGame game = (SudokuGame) session.getAttribute("sudoku");
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
