package epam.ph.sg.tab.chat;

/**
 * @author Paul Michael T.
 */
public class ChatUser {
	private int loadedMsg = 0;

	public int getLoadedMsg() {
		return loadedMsg;
	}

	public void setLoadedMsg(int loadedMsg) {
		this.loadedMsg = loadedMsg;
	}

	public Message[] refresh() {
		int all = Chat.getAllMessages().size();
		if (all > loadedMsg) {
			Message[] msgArray = new Message[all - loadedMsg];
			int j = 0;
			for (int i = loadedMsg; i < all; i++) {
				msgArray[j] = Chat.getAllMessages().get(i);
				j++;
			}
			setLoadedMsg(all);
			return msgArray;
		} else
			return new Message[0];
	}
}
