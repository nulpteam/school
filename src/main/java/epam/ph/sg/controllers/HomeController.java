package epam.ph.sg.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import epam.ph.sg.models.LangModelDAO;

@Controller
@SessionAttributes("lang")
public class HomeController {

	@RequestMapping("/index.html")
	public String index(Model model, HttpSession session) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"springconfig.xml");
		LangModelDAO lang = (LangModelDAO)ctx.getBean("defaultLang");
		model.addAttribute(lang.lang());
		if (session.getAttribute("user") == null) {
			return "Login";
		} else {
			return "index";
		}
	}
	
}