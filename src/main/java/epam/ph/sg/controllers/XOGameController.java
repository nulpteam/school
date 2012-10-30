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
import epam.ph.sg.models.xo.XOBox;
import epam.ph.sg.models.xo.XOPlayer;
import epam.ph.sg.models.xo.XOStatistics;

@Controller
public class XOGameController {

	@RequestMapping(value = "/XOGetClient.html")
	public @ResponseBody
	User getClient(HttpSession session) {
		XOPlayer xo = (XOPlayer) session.getAttribute("xo");
		return xo.getGame().getClient();
	}
	
	@RequestMapping(value = "/XOGetClientStat.html", method = RequestMethod.POST)
	public @ResponseBody
	XOStatistics getClientStat(@RequestParam("id") int id) {
		return XOStatistics.getUserStatistics(id);
	}

	@RequestMapping(value = "/XOPut.html", method = RequestMethod.POST)
	public @ResponseBody
	int put(@RequestParam("xy") String xy, HttpSession session) {
		XOPlayer xo = (XOPlayer) session.getAttribute("xo");
		int indexY = xy.indexOf('Y');
		int x = Integer.parseInt(xy.substring(1, indexY));
		int y = Integer.parseInt(xy.substring(indexY + 1));
		return xo.tryToPut(x, y);
	}

	@RequestMapping(value = "/XOCheck.html")
	public @ResponseBody
	int check(HttpSession session) {
		XOPlayer xo = (XOPlayer) session.getAttribute("xo");
		return xo.check();
	}

	@RequestMapping(value = "/XOGet.html")
	public @ResponseBody
	XOBox getBox(HttpSession session) {
		XOPlayer xo = (XOPlayer) session.getAttribute("xo");
		return xo.getGame().getLastBox();
	}

	@RequestMapping(value = "/XOLose.html")
	public @ResponseBody
	boolean lose(HttpSession session) {
		XOPlayer xo = (XOPlayer) session.getAttribute("xo");
		xo.getGame().out(xo.getId());
		return true;
	}
}
