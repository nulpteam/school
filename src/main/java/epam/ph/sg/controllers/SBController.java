package epam.ph.sg.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import epam.ph.sg.models.sb.SbGame;

@Controller
@SessionAttributes("sbGame")
public class SBController {
	
	@RequestMapping(value = { "/Sb.html", "/Sb" }, method = RequestMethod.GET)
	public String SbGame(Model model, HttpSession session)
	{
		if (session.getAttribute("user") == null) {
			return "Login";
		}
		SbGame sbGame = new SbGame();
		model.addAttribute(sbGame);
		return "SB/Sb";
	}

}
