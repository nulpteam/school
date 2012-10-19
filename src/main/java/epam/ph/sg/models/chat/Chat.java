package epam.ph.sg.models.chat;

/**
 * @author Paul Michael T.
 */
import java.util.ArrayList;
import java.util.List;

public class Chat {
	private static List<Message> messageList = new ArrayList<Message>();

	public static void addMessage(Message msg) {
		messageList.add(msg);
	}

	public static List<Message> getAllMessages() {
		return messageList;
	}
}
