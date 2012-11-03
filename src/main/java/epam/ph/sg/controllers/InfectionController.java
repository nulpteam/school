package epam.ph.sg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
/*
 * author roman makovyak
 */

@Controller
@SessionAttributes("user")
public class InfectionController {

	@RequestMapping("Infection.html")
	public String menu() {
		return "Infection/InfectionMenu";
	}
	
	@RequestMapping("InfectionGame.html")
	public String game() {
		return "Infection/InfectionGame";
	}
}
