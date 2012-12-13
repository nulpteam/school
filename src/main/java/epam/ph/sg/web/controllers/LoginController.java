package epam.ph.sg.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.User;
import epam.ph.sg.utils.UserUtils;

@Controller
public class LoginController {
	private static Logger log = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/LoginPage.html")
	public String loginpage() {
		return "Login";
	}

	@RequestMapping(value = "/Login.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean login(@RequestParam("user_name") String name,
			@RequestParam("password") String pass, HttpServletRequest request,
			HttpSession session) {
		User user = UserUtils.getUser(name, pass);
		if (user != null) {
			session.setAttribute("user", user);
			log.debug(user.getName() + " object added to session");
			return true;
		} else {
			log.debug("Login/Pass is not correct: Login->" + name + " Pass->"
					+ pass + " host-> " + request.getHeader("host"));
			return false;
		}
	}

	@RequestMapping("/Logout.html")
	public String logout(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		request.getSession().removeAttribute("user");
		return "Login";
	}
}