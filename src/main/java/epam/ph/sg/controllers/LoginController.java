package epam.ph.sg.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import epam.ph.sg.models.User;
import epam.ph.sg.models.UserCheck;

@Controller
public class LoginController {

	@RequestMapping(value = { "/Login.html", "/Login" }, method = RequestMethod.POST)
	public String login(@RequestParam("user_name") String name,
			@RequestParam("password") String pass, HttpSession session) {
		User user = UserCheck.check(name, pass);
		if (user != null) {
			session.setAttribute("id", user.getId());
			session.setAttribute("name", user.getName());
			return "Login";
		} else {
			return "notReg";
		}
	}
}
