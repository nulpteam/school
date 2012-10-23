package epam.ph.sg.controllers;

import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import epam.ph.sg.models.LangModel;
import epam.ph.sg.models.impl.LangModelImpl;

@Controller
@SessionAttributes("lang")
public class HomeController {
	private static Logger log = Logger.getLogger(HomeController.class);
	@RequestMapping("/index.html")
	public String index(HttpSession session,Model model) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"springconfig.xml");
		LangModel lang = (LangModel)ctx.getBean("defaultLang");
		//Мова аплікухи в сесії
		log.debug("lang arttribute added to session with value="+lang.lang());
		session.setAttribute("lang",lang.lang());
		if (session.getAttribute("user") == null) {
			ResourceBundle rb = lang.getRb();
			model.addAttribute(rb);
			
			return "Login";
		} else {
		
			return "index";
		}
	}
	
}