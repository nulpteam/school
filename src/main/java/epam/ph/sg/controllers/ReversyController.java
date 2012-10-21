package epam.ph.sg.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import epam.ph.sg.models.User;

/**
 * 
 * @author SergiyManko
 *
 */

@Controller
public class ReversyController {
	@RequestMapping(value = "/Reversy.html")
	public String reversy(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "Login";
		} else
		return "Reversy/reversy";
	}

}
