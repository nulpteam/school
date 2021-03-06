package epam.ph.sg.web.controllers;

/**
 * @author Talash Pavlo
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
import epam.ph.sg.models.UserAddInfo;
import epam.ph.sg.utils.UserAddInfoUtils;

@Controller
public class PersonalController {
	private static Logger log = Logger.getLogger(PersonalController.class);

	@RequestMapping("/PersonalPage.html")
	public String personalPage(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		model.addAttribute("userAddInfo",
				UserAddInfoUtils.getUserAddIngo(user.getId()));
		return "PersonalPage";
	}

	@RequestMapping("/GetUserInfo.html")
	public @ResponseBody
	UserAddInfo getUserAddInfo(@RequestParam("id") int id,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			log.info(request.getRequestURI() + " request received. User id="
					+ user.getId());
		} else {
			log.info(request.getRequestURI() + " request received.");
		}
		return UserAddInfoUtils.getUserAddIngo(id);
	}

	@RequestMapping(value = "/ChangeName.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean changeName(@RequestParam("name") String name,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + ". New name: " + name);
		if (UserAddInfoUtils.changeName(user.getId(), name) == true) {
			user.setName(name);
			return true;
		} else
			return false;
	}

	@RequestMapping(value = "/ChangeEmail.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean changeEmail(@RequestParam("email") String email,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + ". New email: " + email);
		UserAddInfoUtils.changeEmail(user.getId(), email);
		return true;
	}

	@RequestMapping(value = "/ChangeBirthday.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean changeBirthday(@RequestParam("birthday") String birthday,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + ". New birthday: " + birthday);
		UserAddInfoUtils.changeBirthday(user.getId(), birthday);
		return true;
	}

	@RequestMapping(value = "/ChangeAbout.html", method = RequestMethod.POST)
	public @ResponseBody
	String changeAbout(@RequestParam("about") String about,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + ". New about: " + about);
		UserAddInfoUtils.changeAbout(user.getId(), about);
		return UserAddInfoUtils.getUserAddIngo(user.getId()).getAbout();
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
			UserAddInfoUtils.changePass(user.getId(), newPass);
			user.setPass(newPass);
			return true;
		} else {
			return false;
		}
	}
}
