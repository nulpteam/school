package epam.ph.sg.controllers;

//hfuaejgs;lhk
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping({ "/index.html" })
	public String index(HttpSession session) {
		if (session.getAttribute("user") != null) {
			return "Login";
		} else {
			return "index";
		}
	}
}