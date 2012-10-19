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
import epam.ph.sg.models.chat.Chat;
import epam.ph.sg.models.chat.ChatUser;
import epam.ph.sg.models.chat.Message;

@Controller
public class ChatController {

	@RequestMapping(value = "/StartChat.html", method = RequestMethod.POST)
	public @ResponseBody
	void chat(HttpSession session) {
		if (session.getAttribute("chatUser") == null) {
			session.setAttribute("chatUser", new ChatUser());
		}
		session.setAttribute("chatUser", new ChatUser());
	}

	@RequestMapping(value = "/Send.html", method = RequestMethod.POST)
	public @ResponseBody
	Message[] send(@RequestParam("msg") String msgText, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Message msg = new Message(user, msgText);
		Chat.addMessage(msg);

		return refresh(session);
	}

	@RequestMapping(value = "/Refresh.html", method = RequestMethod.POST)
	public @ResponseBody
	Message[] refresh(HttpSession session) {
		ChatUser cu = (ChatUser) session.getAttribute("chatUser");
		return cu.refresh();
	}
}
