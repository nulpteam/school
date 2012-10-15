package epam.ph.sg.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.User;
import epam.ph.sg.models.xo.XOBox;
import epam.ph.sg.models.xo.XOConnector;
import epam.ph.sg.models.xo.XOPlayer;

@Controller
public class XOController {

	@RequestMapping(value = "/XO.html")
	public String xo(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "Login";
		} else return "XO/XO";
	}

	@RequestMapping(value = "/XOServerList.html")
	public String serverList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "Login";
		} else {
			model.addAttribute("serverMap", XOConnector.getServerMap());
			return "XO/XOServerList";
		}
	}

	@RequestMapping(value = "/XOGameServer.html")
	public String create(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "Login";
		} else {
			XOPlayer xo = XOConnector.create(user);
			session.setAttribute("xo", xo);
			return "XO/XOServer";
		}
	}

	@RequestMapping(value = "/XOGameClient.html", method = RequestMethod.POST)
	public String connect(@RequestParam("id") String serverID,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "Login";
		} else {
			XOPlayer xo = XOConnector.connect(serverID, user);
			session.setAttribute("xo", xo);
			return "XO/XOClient";
		}
	}
	
	@RequestMapping(value = "/XOAGetClient.html")
	public @ResponseBody
	User getClient(HttpSession session) {
		XOPlayer xo = (XOPlayer) session.getAttribute("xo");
		return xo.getGame().getClient();
	}

	@RequestMapping(value = "/XOAction.html", method = RequestMethod.POST)
	public @ResponseBody
	int put(@RequestParam("xy") String xy, HttpSession session) {
		XOPlayer xo = (XOPlayer) session.getAttribute("xo");
		int indexY = xy.indexOf('Y');
		int x = Integer.parseInt(xy.substring(1, indexY));
		int y = Integer.parseInt(xy.substring(indexY+1));
		return xo.put(x, y);
	}

	@RequestMapping(value = "/XOACheck.html")
	public @ResponseBody
	int check(HttpSession session) {
		XOPlayer xo = (XOPlayer) session.getAttribute("xo");
		return xo.check();
	}

	@RequestMapping(value = "/XOAGet.html")
	public @ResponseBody
	XOBox getBox(HttpSession session) {
		XOPlayer xo = (XOPlayer) session.getAttribute("xo");
		return xo.getGame().getLastBox();
	}
}