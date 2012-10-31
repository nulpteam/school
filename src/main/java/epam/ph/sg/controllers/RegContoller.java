package epam.ph.sg.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import epam.ph.sg.models.UserReg;

@Controller
public class RegContoller {

	@RequestMapping("/Reg.html")
	public String log() {
		return "Reg";
	}
	
	@RequestMapping(value = { "Reg.html" }, method = RequestMethod.POST)
	public String reg(@RequestParam("user_name") String name,
			@RequestParam("password") String pass, HttpServletRequest request,
			Model model, HttpSession session) {
		
		UserReg.register(name, pass);
		return "Login";
	}
	

}