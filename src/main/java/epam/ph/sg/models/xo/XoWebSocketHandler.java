package epam.ph.sg.models.xo;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketHandler;

public class XoWebSocketHandler extends WebSocketHandler {

	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest request,
			String protocol) {
		return new XoWebSocketSpeacker();
	}
}
