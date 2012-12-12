package epam.ph.sg.tab.chat;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket;

public class ChatWebSocketSpeacker implements WebSocket.OnTextMessage {
	private static Logger log = Logger.getLogger(ChatWebSocketSpeacker.class);
	private static Set<Connection> connectionSet = new HashSet<Connection>();

	private Connection connection;

	public static void informAll() {
		for (Connection con : connectionSet) {
			try {
				con.sendMessage("bip");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onOpen(Connection connection) {
		this.connection = connection;
		connectionSet.add(connection);
		log.info("WebSocket (Chat) Connection opened");
	}

	@Override
	public void onClose(int closeCode, String message) {
		connectionSet.remove(connection);
		log.info("WebSocket (Chat) Connection closed");
	}

	@Override
	public void onMessage(String data) {
	}

}
