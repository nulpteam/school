package epam.ph.sg.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import epam.ph.sg.models.LangModel;
import epam.ph.sg.models.Message;
import epam.ph.sg.models.User;
import epam.ph.sg.models.UserCheck;
import epam.ph.sg.models.impl.LangModelImpl;

@Controller
@SessionAttributes("user")
public class LoginController {
	private static Logger log = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value ="/Login.html")
	public String loginpage(HttpServletRequest request,
			Model model, HttpSession session) {
		return "Login";
	}

	@RequestMapping(value = { "/Login.html", "/Login" }, method = RequestMethod.POST)
	public String login(@RequestParam("user_name") String name,
			@RequestParam("password") String pass, HttpServletRequest request,
			Model model, HttpSession session) {

		session.removeAttribute("msg");
		
		
		User user = UserCheck.check(name, pass);
		if (user != null) {
			model.addAttribute(user);
//			//
//			if (session.getAttribute("lang") == null) {
//				session.setAttribute("lang", "ua");
//			}

			log.debug(user.getName() + " object added to session");
			return "index";
		} else {
			log.debug("Login/Pass is not correct: Login->" + name + " Pass->"
					+ pass + " host-> " + request.getHeader("host"));
			Message msg = new Message();
			msg.setNoUserFound(true);
			session.setAttribute("msg", msg);
			return "Login";
		}
	}
	
//	@RequestMapping(value = "/chLang.html", method = RequestMethod.POST)
//	public @ResponseBody String chLang(@RequestParam("lang") String lang,
//			HttpServletRequest request, HttpSession session) {
//			session.setAttribute("lang",lang);
//	return lang;		
//	}

}