package epam.ph.sg.web.controllers;

/**
 * @author Talash Pavlo
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import epam.ph.sg.models.User;

@Controller
public class TabController {
	private static Logger log = Logger.getLogger(TabController.class);

	@RequestMapping("TabHome.html")
	public String home(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			log.info(request.getRequestURI() + " request received. User id="
					+ user.getId());
		} else {
			log.info(request.getRequestURI() + " request received.");
		}
		return "Tab/Home";
	}

	@RequestMapping("TabCurrentPos.html")
	public String tabCurrentPos(HttpSession session) {
		String tabCurrentPos = (String) session.getAttribute("tabCurrentPos");
		if (tabCurrentPos == null) {
			tabCurrentPos = "TabHome.html";
		}
		return "redirect:" + tabCurrentPos;
	}
}
