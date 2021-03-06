package epam.ph.sg.models.points;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket;

public class PtsWebSocketSpeaker implements WebSocket.OnTextMessage {

	private Logger logger;
	private Connection conn;
	private PtsJsonParser jsonParser;
	private PtsGameMessanger gameMessanger;

	public PtsWebSocketSpeaker() {
		logger = Logger.getLogger(PtsWebSocketSpeaker.class);
		jsonParser = new PtsJsonParser();
		gameMessanger = new PtsGameMessanger();
	}

	@Override
	public void onClose(int arg0, String arg1) {
		logger.debug(PtsResources.getProperty("socket.onclose"));
		
	}

	@Override
	public void onOpen(Connection conn) {
		logger.debug(PtsResources.getProperty("socket.onopen") + conn);
		conn.setMaxIdleTime(1800000);
		this.conn = conn;

	}

	@Override
	public void onMessage(String json) {
		logger.debug(PtsResources.getProperty("socket.onmessage"));
		logger.debug(json);

		PtsClientMessage clientMessage = jsonParser.parseJsonMessage(json);
		PtsGame game = PtsGameMap.getGames().get(clientMessage.getGameId());
		

		if (clientMessage.getType().equals(
				PtsResources.getProperty("user.message.type.user_info"))) {
			gameMessanger.setPlayerInfo(clientMessage.getUserType(), conn, game);
		}

		gameMessanger.processMessage(clientMessage, game);

	}
}
