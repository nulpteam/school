/**
 * 
 */
package epam.ph.sg.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import epam.ph.sg.models.User;
import epam.ph.sg.tab.flipper.FlipperGame;
import epam.ph.sg.tab.minesweeper.MSBox;
import epam.ph.sg.tab.minesweeper.MSGame;
import epam.ph.sg.tab.twopenguins.TwoPenguinsFieldCreator;
import epam.ph.sg.tab.twopenguins.TwoPenguinsGame;
import epam.ph.sg.tab.twopenguins.TwoPenguinsJsonParser;
import epam.ph.sg.tab.twopenguins.TwoPenguinsMessage;

/**
 * @author roman
 * 
 */
@Controller
@SessionAttributes("user")
public class TwoPenguinsController {
	private static Logger log = Logger.getLogger(TwoPenguinsController.class);

	@RequestMapping("/PenguinsGame.html")
	public String game(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {
			log.info(request.getRequestURI() + " request received. User id="
					+ user.getId());
		} else {
			log.info(request.getRequestURI() + " request received.");
		}
		
				
		return "Tab/TwoPenguins";
	}
	
	@RequestMapping("/TPRefresh.html")
	public @ResponseBody
	int[][] refresh(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			log.info(request.getRequestURI() + " request received. User id="
					+ user.getId());
		} else {
			log.info(request.getRequestURI() + " request received.");
		}
				
		return TwoPenguinsFieldCreator.generateField();
	}
}
