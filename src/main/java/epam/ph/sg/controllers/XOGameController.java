package epam.ph.sg.controllers;

/**
 * @author Paul Michael T.
 */
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.models.User;
import epam.ph.sg.xo.XOConnector;
import epam.ph.sg.xo.XOStatus;
import epam.ph.sg.xo.XOPlayer;

@Controller
public class XOGameController {

	@RequestMapping(value = "/XOGetClient.html")
	public @ResponseBody
	User getClient(HttpSession session) {
		XOPlayer xo = (XOPlayer) session.getAttribute("xoGame");
		return xo.getGame().getClient();
	}

	@RequestMapping(value = "/XOPut.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean put(@RequestParam("xy") String xy, HttpSession session) {
		XOPlayer xo = (XOPlayer) session.getAttribute("xoGame");
		int indexY = xy.indexOf('Y');
		int x = Integer.parseInt(xy.substring(1, indexY));
		int y = Integer.parseInt(xy.substring(indexY + 1));
		return xo.tryToPut(x, y);
	}

	@RequestMapping(value = "/XOCheckChanges.html")
	public @ResponseBody
	boolean check(HttpSession session) {
		XOPlayer xo = (XOPlayer) session.getAttribute("xoGame");
		if (xo.getGame().getStatus().isGameOver() == true) {
			return true;
		}
		if (xo.getId() == xo.getGame().getStatus().getLastPlayer()) {
			return false;
		} else {
			return true;
		}
	}

	@RequestMapping(value = "/XOGetStatus.html")
	public @ResponseBody
	XOStatus getBox(HttpSession session) {
		XOPlayer xo = (XOPlayer) session.getAttribute("xoGame");
		return xo.getGame().getStatus();
	}

	@RequestMapping(value = "/XOPlayerOut.html")
	public @ResponseBody
	boolean playerOut(HttpSession session) {
		XOPlayer xo = (XOPlayer) session.getAttribute("xoGame");
		xo.getGame().out(xo.getId());
		session.removeAttribute("xoGame");
		return true;
	}

	@RequestMapping("/XOClear.html")
	public @ResponseBody
	boolean clear(HttpSession session) {
		User user = (User) session.getAttribute("user");
		session.removeAttribute("xoGame");
		XOConnector.getServerMap().remove(user.getId());
		return true;
	}
}
