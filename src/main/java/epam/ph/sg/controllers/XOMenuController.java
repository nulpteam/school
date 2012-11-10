package epam.ph.sg.controllers;

/**
 * @author Paul Michael T.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.User;
import epam.ph.sg.sudoku.SudokuGame;
import epam.ph.sg.xo.XOConnector;
import epam.ph.sg.xo.XOPlayer;
import epam.ph.sg.xo.XOStatistics;

@Controller
public class XOMenuController {
	private static Logger log = Logger.getLogger(XOMenuController.class);

	@RequestMapping("/XO.html")
	public String xo(HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId() + " Position: "
				+ session.getAttribute("xoCurentPos"));
		return "XO/XO";
	}

	@RequestMapping("/XOMenu.html")
	public String menu(HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		return "XO/Menu";
	}

	@RequestMapping("/XOServerList.html")
	public String serverList(HttpServletRequest request, HttpSession session,
			Model model) {
		User user = (User) session.getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		model.addAttribute("serverMap", XOConnector.getServerMap());
		return "XO/ServerList";
	}

	@RequestMapping("/XOStatistics.html")
	public String statistics(HttpServletRequest request, HttpSession session,
			Model model) {
		User user = (User) session.getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		model.addAttribute("xoStatList", XOStatistics.getAllStatistics());
		return "XO/Statistics";
	}

	@RequestMapping("/XOCreate.html")
	public String create(HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		XOPlayer xo = XOConnector.create(user);
		session.setAttribute("sudoku", SudokuGame.getGame());
		session.setAttribute("xoGame", xo);
		return "XO/WaitPage";
	}

	@RequestMapping(value = "/XOConnect.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean connect(@RequestParam("serverID") int serverID,
			HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		log.info(request.getRequestURI() + " id=" + serverID
				+ " request received. User id=" + user.getId());
		XOPlayer xo = XOConnector.connect(serverID, user);
		session.setAttribute("xoGame", xo);
		return true;
	}

	@RequestMapping(value = "/XOGame.html")
	public String game(HttpServletRequest request, HttpSession session,
			Model model) {
		User user = (User) session.getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());

		XOPlayer xo = (XOPlayer) session.getAttribute("xoGame");
		if (xo == null)
			return "redirect:/XOMenu.html";
		XOStatistics myStat = XOStatistics.getUserStatistics(xo.getId());
		model.addAttribute("myStat", myStat);
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
