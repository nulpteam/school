package epam.ph.sg.models.sb;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketHandler;

public class SbWebSocketHandler extends WebSocketHandler {

	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest arg0, String arg1) {
		// TODO Auto-generated method stub
		return new SbWebSocketSpeeker();
	}

	

}
