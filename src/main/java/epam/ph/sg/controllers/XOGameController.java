package epam.ph.sg.controllers;

/**
 * @author Talash Pavlo
 */
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import epam.ph.sg.games.xo.XOConnector;
import epam.ph.sg.games.xo.XOPlayer;
import epam.ph.sg.games.xo.XOStatus;
import epam.ph.sg.models.User;

@Controller
public class XOGameController {
	private static Logger log = Logger.getLogger(XOGameController.class);

	@RequestMapping("/XOGetClient.html")
	public @ResponseBody
	User getClient(HttpServletRequest request) {
		XOPlayer xo = (XOPlayer) request.getSession().getAttribute("xoGame");
		log.info(request.getRequestURI() + " request received. User id="
				+ xo.getId());
		xo.getGame().serverTimeOut();
		return xo.getGame().getClient();
	}

	@RequestMapping("/XOGameStarted.html")
	public @ResponseBody
	void gameStarted(HttpServletRequest request) {
		XOPlayer xo = (XOPlayer) request.getSession().getAttribute("xoGame");
		log.info(request.getRequestURI() + " request received. User id="
				+ xo.getId());
		xo.getGame().gameTimeOut(xo.getGame().getClient().getId());
	}

	@RequestMapping(value = "/XOPut.html", method = RequestMethod.POST)
	public @ResponseBody
	boolean put(@RequestParam("xy") String xy, HttpServletRequest request) {
		XOPlayer xo = (XOPlayer) request.getSession().getAttribute("xoGame");
		log.info(request.getRequestURI() + " request received. User id="
				+ xo.getId() + ". Posittion: " + xy);
		int indexY = xy.indexOf('Y');
		int x = Integer.parseInt(xy.substring(1, indexY));
		int y = Integer.parseInt(xy.substring(indexY + 1));
		return xo.tryToPut(x, y);
	}

	@RequestMapping("/XOCheckChanges.html")
	public @ResponseBody
	boolean check(HttpServletRequest request) {
		XOPlayer xo = (XOPlayer) request.getSession().getAttribute("xoGame");
		log.info(request.getRequestURI() + " request received. User id="
				+ xo.getId());
		if (xo.getGame().getStatus().isGameOver() == true) {
			return true;
		}
		if (xo.getId() == xo.getGame().getStatus().getLastPlayer()) {
			return false;
		} else {
			return true;
		}
	}

	@RequestMapping("/XOGetStatus.html")
	public @ResponseBody
	XOStatus getStatus(HttpServletRequest request) {
		XOPlayer xo = (XOPlayer) request.getSession().getAttribute("xoGame");
		log.info(request.getRequestURI() + " request received. User id="
				+ xo.getId());
		return xo.getGame().getStatus();
	}

	@RequestMapping("/XOPlayerOut.html")
	public @ResponseBody
	boolean playerOut(HttpServletRequest request) {
		XOPlayer xo = (XOPlayer) request.getSession().getAttribute("xoGame");
		log.info(request.getRequestURI() + " request received. User id="
				+ xo.getId());
		xo.getGame().out(xo.getId());
		request.getSession().removeAttribute("xoGame");
		return true;
	}

	@RequestMapping("/XOClear.html")
	public @ResponseBody
	boolean clear(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		log.info(request.getRequestURI() + " request received. User id="
				+ user.getId());
		request.getSession().removeAttribute("xoGame");
		XOConnector.getServerMap().remove(user.getId());
		return true;
	}
}
