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
import epam.ph.sg.sudoku.SudokuGame;

@Controller
public class XOMenuController {

	@RequestMapping("/XO.html")
	public String xo() {
		return "XO/Menu";
	}

	@RequestMapping("/XOServerList.html")
	public String serverList(Model model) {
		model.addAttribute("serverMap", XOConnector.getServerMap());
		return "XO/ServerList";
	}
	
	@RequestMapping("/XOStatistics.html")
	public String statistics(Model model) {
		model.addAttribute("xoStatList", XOStatistics.getAllStatistics());
		return "XO/Statistics";
	}

	@RequestMapping("/XOCreate.html")
	public String create(HttpSession session) {
		User user = (User) session.getAttribute("user");
		XOPlayer xo = XOConnector.create(user);
		session.setAttribute("sudoku", SudokuGame.getGame());
		session.setAttribute("xo", xo);
		return "XO/WaitPage";
	}

	@RequestMapping(value = "/XOConnect.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean connect(@RequestParam("serverID") int serverID, HttpSession session) {
		User user = (User) session.getAttribute("user");
		XOPlayer xo = XOConnector.connect(serverID, user);
		session.setAttribute("xo", xo);
		return true;
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
		return "XO/Game";
	}

	@RequestMapping("/XOClear.html")
	public @ResponseBody
	boolean clear(HttpSession session) {
		User user = (User) session.getAttribute("user");
		session.removeAttribute("xo");
		XOConnector.getServerMap().remove(user.getId());
		return true;
	}

}
