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
import epam.ph.sg.models.xo.XO;
import epam.ph.sg.models.xo.XOConnector;
import epam.ph.sg.models.xo.XOPlayer;
import epam.ph.sg.models.xo.XOStatistics;

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

	@RequestMapping(value = "XOCreate.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean create(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return false;
		} else {
			XOPlayer xo = XOConnector.create(user);
			session.setAttribute("xo", xo);
			return true;
		}
	}

	@RequestMapping(value = "XOConnect.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean connect(@RequestParam("serverID") int serverID, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return false;
		} else {
			XOPlayer xo = XOConnector.connect(serverID, user);
			session.setAttribute("xo", xo);
			return true;
		}
	}

	@RequestMapping(value = "/XOGame.html")
	public String game(HttpSession session, Model model) {
		XOPlayer xo = (XOPlayer) session.getAttribute("xo");
		User user = (User) session.getAttribute("user");
		XOStatistics myStat = XOStatistics.getUserStatistics(user.getId());
		model.addAttribute("myStat", myStat);
		if (xo.getStatus() == XO.X) {
			User client = xo.getGame().getClient();
			if (client != null) {
				model.addAttribute("oponent", client);
				model.addAttribute("opStat",
						XOStatistics.getUserStatistics(client.getId()));
			}
		} else if (xo.getStatus() == XO.O) {
			User server = xo.getGame().getServer();
			model.addAttribute("oponent", server);
			model.addAttribute("opStat",
					XOStatistics.getUserStatistics(server.getId()));
		}
		return "XO/XOGame";
	}

	@RequestMapping(value = "/XOClear.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean clear(HttpSession session) {
		session.removeAttribute("xo");
		return true;
	}

}
