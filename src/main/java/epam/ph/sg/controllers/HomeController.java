/**
 * @author Gutey Bogdan
 */
package epam.ph.sg.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import epam.ph.sg.models.lang.LangSelector;

@Controller
@SessionAttributes("lang")
public class HomeController {

	@RequestMapping("/index.html")
	public String index(HttpSession session) {
		return "index";
	}

	@RequestMapping(value = "/chLang.html", method = RequestMethod.POST)
	public @ResponseBody
	String chLang(@RequestParam("lang") String lang,
			HttpServletRequest request, HttpSession session) {
		session.setAttribute("lang", lang);
		Map<String, String> langPack = new LangSelector().getRb((String) session
				.getAttribute("lang"));
		session.setAttribute("langPack", langPack);
		return lang;
	}

}