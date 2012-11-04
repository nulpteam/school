package epam.ph.sg.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.cabinet.Cabinet;
import epam.ph.sg.models.User;
import epam.ph.sg.models.xo.XOStatistics;

@Controller
public class CabinetController {

	@RequestMapping(value = "/ChangeName.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean changeName(@RequestParam("name") String name, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Cabinet.changeName(user.getId(), name);
		user.setName(name);
		return true;
	}

	@RequestMapping(value = "/ChangePass.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean changePass(@RequestParam("oldPass") String oldPass,
			@RequestParam("newPass") String newPass, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user.getPass().equals(oldPass)) {
			Cabinet.changePass(user.getId(), newPass);
			user.setPass(newPass);
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping(value = "/GetXOStatistics.html", method = RequestMethod.POST)
	public @ResponseBody XOStatistics[] getXOstat(){
		List<XOStatistics> list = XOStatistics.getAllStatistics();
		XOStatistics[] array = new XOStatistics[list.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = list.get(i);
		}
		return array;
	}
}
