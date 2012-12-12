package epam.ph.sg.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.User;
import epam.ph.sg.utils.PuzzleUtils;

@Controller
public class PuzzleController {

	private static Logger log = Logger.getLogger(PuzzleController.class);

	@RequestMapping("/PuzzleGame.html")
	public String menu(HttpServletRequest request) {
		
		System.out.println("+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_");

		return "Tab/Puzzle";
	}
	
	@RequestMapping("/PuzzleGetBoard.html")
	public @ResponseBody List<Integer> getBoard(HttpServletRequest request) {

		List<Integer> board = PuzzleUtils.getBoard();
		return board;	
	}

}
