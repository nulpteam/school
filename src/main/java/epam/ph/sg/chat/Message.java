package epam.ph.sg.chat;

/**
 * @author Paul Michael T.
 */
import java.util.Date;

import epam.ph.sg.models.User;

public class Message {
	private String time;
	private User sender;
	private String text;

	@SuppressWarnings("deprecation")
	public Message(User sender, String text) {
		Date date = new Date();
		int hh = date.getHours();
		int mm = date.getMinutes();
		if (mm < 10) {
			this.time = hh + ":0" + mm;
		} else {
			this.time = hh + ":" + mm;
		}

		this.sender = sender;
		this.text = text;
	}

	public String getTime() {
		return time;
	}

	public User getSender() {
		return sender;
	}

	public String getText() {
		return text;
	}
}
