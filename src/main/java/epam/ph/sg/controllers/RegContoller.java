package epam.ph.sg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegContoller {

	@RequestMapping("/Reg.html")
	public String reg() {
		return "Reg";
	}

}