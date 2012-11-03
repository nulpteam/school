package epam.ph.sg.models.reversy;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketHandler;

public class ReversyWebSocketHandler extends WebSocketHandler {

	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest request, String arg1) {
		// TODO Auto-generated method stub
		return new ReversyWebSocketSpeeker();
	}
}