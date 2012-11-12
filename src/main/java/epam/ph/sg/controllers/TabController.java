package epam.ph.sg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TabController {

	@RequestMapping("TabHome.html")
	public String home() {
		return "Tab/Home";
	}
}
