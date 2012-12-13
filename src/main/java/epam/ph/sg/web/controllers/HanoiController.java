package epam.ph.sg.web.controllers;

/**
 * @author MankoSergiy
 */

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HanoiController {

	@RequestMapping("/Hanoi.html")
	public String hanoiMenu(HttpServletRequest request) {
		return "Tab/Hanoi";
	}
}
