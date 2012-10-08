package epam.ph.sg.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import epam.ph.sg.models.User;
import epam.ph.sg.models.UserCheck;
import epam.ph.sg.models.impl.Lang;

@Controller
@SessionAttributes({"user","servletLang"})
public class LoginController {
	private static Logger log = Logger.getLogger(LoginController.class);
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"springconfig.xml");
	private Lang servletLang = (Lang)ctx.getBean("lang");
	
	
	@RequestMapping(value = { "/Login.html", "/Login" }, method = RequestMethod.POST)
	public String login(@RequestParam("user_name") String name,
			@RequestParam("password") String pass, HttpServletRequest request,
			Model model) {
		log.error("lang======================="+servletLang.getLang());
		
		//Lang lang = new Lang("ru");
		
		User user = UserCheck.check(name, pass);
		if (user != null && user.getId() != null) {
			model.addAttribute(user);
			model.addAttribute(servletLang);
			log.debug(user.getName() + " Session: created");
			return "index";
		} else {
			log.debug("Login/Pass is not correct: Login->" + name + " Pass->"
					+ pass + " host-> " + request.getHeader("host"));
			return "notReg";
		}
	}
}