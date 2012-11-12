package epam.ph.sg.models.infection;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket;

public class InfWebSocketSpeaker implements WebSocket.OnTextMessage {

	private static Logger log = Logger.getLogger(InfWebSocketSpeaker.class);
	private Connection conn;
	

	public InfWebSocketSpeaker() {
		
	}

	@Override
	public void onClose(int arg0, String arg1) {
		log.debug("Socket closed");
	}

	@Override
	public void onOpen(Connection conn) {
		log.debug("Socket created");
		this.conn = conn;

	}

	@Override
	public void onMessage(String json) {
		log.debug("Recieved message");
		log.debug(json);
		
		
		
        try {
			conn.sendMessage(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
}

