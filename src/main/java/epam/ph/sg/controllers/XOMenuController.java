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
import epam.ph.sg.models.xo.XOConnector;
import epam.ph.sg.models.xo.XOPlayer;

@Controller
public class XOMenuController {

	@RequestMapping(value = "/XO.html")
	public String xo(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:/index.html";
		} else
			return "XO/XOMenu";
	}

	@RequestMapping(value = "/XOServerList.html")
	public String serverList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:/index.html";
		} else {
			model.addAttribute("serverMap", XOConnector.getServerMap());
			return "XO/XOServerList";
		}
	}

	@RequestMapping(value = "/XOGameServer.html")
	public String create(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:/index.html";
		} else {
			if (session.getAttribute("xo") == null) {
				XOPlayer xo = XOConnector.create(user);
				session.setAttribute("xo", xo);
			} else {
				XOPlayer xo = (XOPlayer) session.getAttribute("xo");
				model.addAttribute("oponent", xo.getGame().getClient());
			}
			return "XO/XOGame";
		}
	}

	@RequestMapping(value = "/XOGameClient.html", method = RequestMethod.GET)
	public String connect(@RequestParam("serverID") String serverID,
			HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:/index.html";
		} else {
			if (session.getAttribute("xo") == null) {
				XOPlayer xo = XOConnector.connect(serverID, user);
				session.setAttribute("xo", xo);
				model.addAttribute("oponent", xo.getGame().getServer());
			} else {
				XOPlayer xo = (XOPlayer) session.getAttribute("xo");
				model.addAttribute("oponent", xo.getGame().getServer());
			}
			return "XO/XOGame";
		}
	}

	@RequestMapping(value = "/XOClear.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean clear(HttpSession session) {
		session.removeAttribute("xo");
		return true;
	}

}
