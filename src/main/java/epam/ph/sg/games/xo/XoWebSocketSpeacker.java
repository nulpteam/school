package epam.ph.sg.games.xo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket;

public class XoWebSocketSpeacker implements WebSocket.OnTextMessage {
	private static Logger log = Logger.getLogger(XoWebSocketSpeacker.class);
	private static Map<Integer, Connection> connectionMap = new HashMap<Integer, Connection>();

	public static void send(int id) {
		Connection con = connectionMap.get(id);
		if (con != null) {
			try {
				con.sendMessage("bip");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private Connection connection;
	private int id;

	@Override
	public void onOpen(Connection connection) {
		this.connection = connection;
		log.info("WebSocket (XO) Connection opened");
	}

	@Override
	public void onClose(int closeCode, String message) {
		connectionMap.remove(id);
		XOConnector.getServerMap().remove(id);
		log.info("WebSocket (XO) Connection closed");
	}

	@Override
	public void onMessage(String data) {
		id = Integer.parseInt(data);
		connectionMap.put(id, connection);
	}
}
