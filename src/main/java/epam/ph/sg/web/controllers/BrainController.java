package epam.ph.sg.web.controllers;

/**
 * @author MankoSergiy
 */

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BrainController {

	@RequestMapping("/Brain.html")
	public String brainMenu(HttpServletRequest request) {
		return "Tab/Brain";
	}
}
