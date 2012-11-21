package epam.ph.sg.controllers;

/**
 * @author Paul Michael T.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	
	@RequestMapping("/404.html")
	public String error404() {
		return "404";
	}
}