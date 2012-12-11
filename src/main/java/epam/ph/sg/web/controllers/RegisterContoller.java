package epam.ph.sg.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.User;
import epam.ph.sg.utils.UserCheck;
import epam.ph.sg.utils.UserReg;

@Controller
public class RegisterContoller {
	private static Logger log = Logger.getLogger(RegisterContoller.class);

	@RequestMapping("/RegisterPage.html")
	public String registerPage(HttpServletRequest request, Model model,
			HttpSession session) {
		log.info(request.getRequestURI() + " request received.");
		return "Register";
	}

	@RequestMapping(value = "/Register.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean register(@RequestParam("user_name") String name,
			@RequestParam("password") String pass, HttpServletRequest request,
			Model model, HttpSession session) {
		if (UserCheck.isUserExist(name) == true) {
			return false;
		} else {
			UserReg.register(name, pass);
			User user = UserCheck.check(name, pass);
			session.setAttribute("user", user);
			return true;
		}
	}
}