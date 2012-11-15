package epam.ph.sg.controllers;

/**
 * @author Paul Michael T.
 */
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
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
	private static Logger log = Logger.getLogger(PersonalPageController.class);

	@RequestMapping("/PersonalPage.html")
	public String personalPage(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		model.addAttribute("userAddInfo",
				PersonalPage.getUserAddIngo(user.getId()));
		return "PersonalPage";
	}

	@RequestMapping(value = "/ChangeName.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean changeName(@RequestParam("name") String name,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + ". New name: " + name);
		PersonalPage.changeName(user.getId(), name);
		user.setName(name);
		return true;
	}

	@RequestMapping(value = "/ChangeEmail.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean changeEmail(@RequestParam("email") String email,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + ". New email: " + email);
		PersonalPage.changeEmail(user.getId(), email);
		return true;
	}

	@RequestMapping(value = "/ChangeBirthday.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean changeBirthday(@RequestParam("birthday") String birthday,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + ". New birthday: " + birthday);
		PersonalPage.changeBirthday(user.getId(), birthday);
		return true;
	}

	@RequestMapping(value = "/ChangeAbout.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean changeAbout(@RequestParam("about") String about,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + ". New about: " + about);
		PersonalPage.changeAbout(user.getId(), about);
		return true;
	}

	@RequestMapping(value = "/ChangePass.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean changePass(@RequestParam("oldPass") String oldPass,
			@RequestParam("newPass") String newPass, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + ". New pass: " + newPass + "; old pass: "
				+ oldPass);
		if (user.getPass().equals(oldPass)) {
			PersonalPage.changePass(user.getId(), newPass);
			user.setPass(newPass);
			return true;
		} else {
			return false;
		}
	}
}
