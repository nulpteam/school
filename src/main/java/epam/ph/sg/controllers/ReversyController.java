package epam.ph.sg.controllers;

/**
 * 
 * @author SergiyManko
 *
 */

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import epam.ph.sg.models.User;

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
	@RequestMapping(value = "/ReversyMenu.html")
	public String reversyMenu(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "Login";
		} else
		return "Reversy/reversyMenu";
	}

}
