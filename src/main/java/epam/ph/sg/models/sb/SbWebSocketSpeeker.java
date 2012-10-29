package epam.ph.sg.models.sb;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket;

public class SbWebSocketSpeeker implements WebSocket.OnTextMessage {
	private static Logger log = Logger.getLogger(SbWebSocketSpeeker.class);
	static
	{
		log.debug("+++++++++++++++SbWebSocketSpeeker loaded++++++++++++++++++++++");
	}
	@Override
	public void onClose(int arg0, String arg1) {
		log.debug("++++++++++++Socket closed++++++++++++++");
		
	}

	@Override
	public void onOpen(Connection arg0) {
		log.debug("++++++++++++Socket created++++++++++++++");
		
	}

	@Override
	public void onMessage(String arg0) {
		log.debug("++++++++++++Recieved message++++++++++++++");
		log.debug(arg0);
	}

}
