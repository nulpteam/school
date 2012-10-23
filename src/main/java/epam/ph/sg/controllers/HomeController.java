/**@author Gutey Bogdan
 * 
 */
package epam.ph.sg.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import epam.ph.sg.models.LangModel;
import epam.ph.sg.models.lang.LangSelector;

@Controller
@SessionAttributes("lang")
public class HomeController {
	private static Logger log = Logger.getLogger(HomeController.class);

	@RequestMapping("/index.html")
	public ModelAndView index(HttpSession session) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"springconfig.xml");
		LangModel lang = (LangModel) ctx.getBean("defaultLang");
		ModelAndView model = null;

		// Мова аплікухи в сесії
		if (session.getAttribute("lang") == null) {
			session.setAttribute("lang", lang.lang());
			log.debug("lang arttribute added to session with value="
					+ lang.lang());
		}

		if (session.getAttribute("user") == null) {
			model = new ModelAndView("Login");
			Map<String, String> rbl = new LangSelector().getRb((String) session
					.getAttribute("lang"));
			/*
			 * Доробити кукіси
			 */
			model.addObject(rbl);
			log.debug("Language map" + session.getAttribute("lang")
					+ " added to model");
			return model;
		} else {
			return new ModelAndView("index");
		}
	}
	
	
	
	@RequestMapping(value = "/chLang.html", method = RequestMethod.POST)
	public @ResponseBody String chLang(@RequestParam("lang") String lang,
			HttpServletRequest request, HttpSession session) {
			session.setAttribute("lang",lang);
	return lang;		
	}

}