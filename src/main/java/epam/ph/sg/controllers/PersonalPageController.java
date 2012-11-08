package epam.ph.sg.controllers;

/**
 * @author Paul Michael T.
 */
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.User;
import epam.ph.sg.personal.PersonalPage;

@Controller
public class PersonalPageController {

	@RequestMapping("/PersonalPage.html")
	public String personalPage(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("userAddInfo",
				PersonalPage.getUserAddIngo(user.getId()));
		return "PersonalPage";
	}

	@RequestMapping(value = "/ChangeName.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean changeName(@RequestParam("name") String name, HttpSession session) {
		User user = (User) session.getAttribute("user");
		PersonalPage.changeName(user.getId(), name);
		user.setName(name);
		return true;
	}

	@RequestMapping(value = "/ChangeEmail.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean changeEmail(@RequestParam("email") String email, HttpSession session) {
		User user = (User) session.getAttribute("user");
		PersonalPage.changeEmail(user.getId(), email);
		return true;
	}

	@RequestMapping(value = "/ChangeBirthday.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean changeBirthday(@RequestParam("birthday") String birthday, HttpSession session) {
		User user = (User) session.getAttribute("user");
		PersonalPage.changeBirthday(user.getId(), birthday);
		return true;
	}

	@RequestMapping(value = "/ChangeAbout.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean changeAbout(@RequestParam("about") String about, HttpSession session) {
		User user = (User) session.getAttribute("user");
		PersonalPage.changeAbout(user.getId(), about);
		return true;
	}

	@RequestMapping(value = "/ChangePass.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean changePass(@RequestParam("oldPass") String oldPass,
			@RequestParam("newPass") String newPass, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user.getPass().equals(oldPass)) {
			PersonalPage.changePass(user.getId(), newPass);
			user.setPass(newPass);
			return true;
		} else {
			return false;
		}
	}
}
