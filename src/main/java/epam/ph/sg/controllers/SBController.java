package epam.ph.sg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SBController {
	@RequestMapping(value = { "/Sb.html", "/Login" }, method = RequestMethod.POST)
	public String SbGame()
	{
		return "SB/Sb";
		
	}

}
