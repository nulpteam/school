package epam.ph.sg.controllers;

/**
 * @author Talash Pavlo
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.games.xo.XOConnector;
import epam.ph.sg.games.xo.XOPlayer;
import epam.ph.sg.games.xo.XOStatistics;
import epam.ph.sg.games.xo.XoWebSocketSpeacker;
import epam.ph.sg.models.User;

@Controller
public class XOMenuController {
	private static Logger log = Logger.getLogger(XOMenuController.class);

	@RequestMapping("/XOMenu.html")
	public String menu(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		return "XO/Menu";
	}

	@RequestMapping("/XOServerList.html")
	public String serverList(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		model.addAttribute("serverMap", XOConnector.getServerMap());
		return "XO/ServerList";
	}

	@RequestMapping("/XOStatistics.html")
	public String statistics(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		List<XOStatistics> list = XOStatistics.getAllStatistics();
		if (list.size() < 10) {
			model.addAttribute("xoStatList", list);
		} else {
			model.addAttribute("xoStatList", list.subList(0, 10));
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(user.getName())) {
				model.addAttribute("myPos", i + 1);
				model.addAttribute("myStats", list.get(i));
				break;
			}
		}
		return "XO/Statistics";
	}

	@RequestMapping("/XOCreate.html")
	public String create(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		request.getSession().setAttribute("xoGame", XOConnector.create(user));
		return "XO/WaitPage";
	}

	@RequestMapping(value = "/XOConnect.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean connect(@RequestParam("serverID") int serverID,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + ". Server id=" + serverID);
		XOPlayer xo = XOConnector.connect(serverID, user);
		if (xo == null) {
			return false;
		} else {
			request.getSession().setAttribute("xoGame", xo);
			XoWebSocketSpeacker.send(serverID);
			return true;
		}
	}

	@RequestMapping(value = "/XOGame.html")
	public String game(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());

		XOPlayer xo = (XOPlayer) request.getSession().getAttribute("xoGame");
		if (xo == null)
			return "redirect:/XOMenu.html";
		model.addAttribute("myStat", XOStatistics.getUserStatistics(xo.getId()));
		if (xo.getId() == xo.getGame().getServer().getId()) {
			User client = xo.getGame().getClient();
			if (client != null) {
				model.addAttribute("oponent", client);
				model.addAttribute("opStat",
						XOStatistics.getUserStatistics(client.getId()));
			}
		} else if (xo.getId() == xo.getGame().getClient().getId()) {
			User server = xo.getGame().getServer();
			model.addAttribute("oponent", server);
			model.addAttribute("opStat",
					XOStatistics.getUserStatistics(server.getId()));
		}
		return "XO/Game";
	}
}
