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
		this.text = msgPrepare(text);
	}

	private static String msgPrepare(String text) {
		int wordlenght = 20;
		String preparedText = "";
		String[] words = text.split(" ");
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > wordlenght) {
				String newWord = words[i].substring(0, wordlenght);
				newWord = newWord.concat("...");
				preparedText += " " + newWord;
			} else {
				preparedText += " " + words[i];
			}
		}
		return preparedText.trim();
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
