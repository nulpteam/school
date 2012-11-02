package epam.ph.sg.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import epam.ph.sg.models.LangModel;
import epam.ph.sg.models.Message;
import epam.ph.sg.models.User;
import epam.ph.sg.models.UserCheck;
import epam.ph.sg.models.UserReg;
import epam.ph.sg.models.impl.LangModelImpl;

@Controller
@SessionAttributes({"user","msg"})
public class RegContoller {

	private static Logger log = Logger.getLogger(RegContoller.class);

	@RequestMapping("/Reg.html")
	public String log( HttpServletRequest request,
			Model model, HttpSession session) {
		session.removeAttribute("msg");
		return "Reg";
	}

	@RequestMapping(value = { "Reg.html" }, method = RequestMethod.POST)
	public String reg(@RequestParam("user_name") String name,
			@RequestParam("password") String pass, HttpServletRequest request,
			Model model, HttpSession session) {
		
		Message msg = new Message();
				
		User existuser = UserCheck.check(name, pass);
		if (existuser!=null){
			msg.setAlreadyReg(true);
			session.setAttribute("msg", msg);
			return "Reg";
		}
		UserReg.register(name, pass);
		User user = UserCheck.check(name, pass);
		if (user != null) {
			model.addAttribute(user);
		}
		return "index";

	}


}