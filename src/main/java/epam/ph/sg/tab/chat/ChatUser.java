package epam.ph.sg.tab.chat;

/**
 * @author Talash Pavlo
 */
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ChatUser {
	private static Logger log = Logger.getLogger(ChatUser.class);

	private List<Message> loadedMsg = new ArrayList<Message>();

	public List<Message> getLoadedMsg() {
		return loadedMsg;
	}

	/**
	 * Check for new message in the chat and return it.
	 * 
	 * @return message array
	 */
	public Message[] refresh() {
		int all = Chat.getAllMessages().size();
		if (all > loadedMsg.size()) {
			Message[] msgArray = new Message[all - loadedMsg.size()];
			int j = 0;
			for (int i = loadedMsg.size(); i < all; i++) {
				msgArray[j] = Chat.getAllMessages().get(i);
				loadedMsg.add(Chat.getAllMessages().get(i));
				j++;
			}
			log.info(loadedMsg.size() + " loaded.");
			return msgArray;
		} else
			return new Message[0];
	}
}
