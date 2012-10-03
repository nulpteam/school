package epam.ph.sg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import epam.ph.sg.models.User;
import epam.ph.sg.models.UserCheck;

@Controller
public class LoginController {

	@RequestMapping(value = { "/Login.html", "/Login" }, method = RequestMethod.POST)
	public String dohi(@RequestParam("user_name") String name,
			@RequestParam("password") String pass, Model model) {
		User user = UserCheck.check(name, pass);
		if (user != null) {
			model.addAttribute("name", user.getName());
			return "Login";
		} else {
			model.addAttribute("name", name);
			model.addAttribute("pass", pass);
			return "notReg";
		}
	}
}
