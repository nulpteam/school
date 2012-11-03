package epam.ph.sg.models.reversy;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket;

import epam.ph.sg.controllers.ReversyController;

public class ReversyWebSocketSpeeker implements WebSocket.OnTextMessage {

	private static Logger log = Logger.getLogger(ReversyWebSocketSpeeker.class);
	private Connection conn;

	public ReversyWebSocketSpeeker() {
		
	}

	@Override
	public void onClose(int arg0, String arg1) {
		log.debug(ReversyController.boundle.getString("message.socket.closed"));
	}

	@Override
	public void onOpen(Connection conn) {
		log.debug(ReversyController.boundle.getString("message.socket.created"));
		this.conn = conn;
		log.debug(this.conn);
	}

	@Override
	public void onMessage(String message) {
		log.debug(ReversyController.boundle.getString("message.socket.onMessage") + message);
	}
}
