package epam.ph.sg.tab.chat;

/**
 * @author Paul Michael T.
 */
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Chat {
	private static Logger log = Logger.getLogger(Chat.class);
	
	private static List<Message> messageList = new ArrayList<Message>();

	public static void addMessage(Message msg) {
		log.info("New message: " + msg);
		messageList.add(msg);
	}

	public static List<Message> getAllMessages() {
		return messageList;
	}
}
