package epam.ph.sg.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PicsController {
	
	private static Logger log = Logger.getLogger(PicsController.class);

	@RequestMapping("/Pics.html")
	public String menu(HttpServletRequest request) {
			
		log.debug("+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_");

		return "Tab/Pics";
	}
		
//	@RequestMapping("/PuzzleGetBoard.html")
//	public @ResponseBody List<Integer> getBoard(HttpServletRequest request) {
//
//		List<Integer> board = PuzzleUtils.getBoard();
//		return board;	
//	}
}


