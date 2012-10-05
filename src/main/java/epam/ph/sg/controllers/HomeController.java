package epam.ph.sg.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/index.html")
	public String index(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "Login";
		} else {
			return "index";
		}
	}
	
}/*ghjkl;gh;fjh;df*/
/*77777777*/