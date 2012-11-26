package epam.ph.sg.models.points;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket;

public class PtsWebSocketSpeeker implements WebSocket.OnTextMessage {

	private Logger logger;
	private Connection conn;
	private PtsJsonParser jsonParser;

	public PtsWebSocketSpeeker() {
		logger = Logger.getLogger(PtsWebSocketSpeeker.class);
		jsonParser = new PtsJsonParser();
	}

	@Override
	public void onClose(int arg0, String arg1) {
		logger.debug(PtsResources.getProperty("socket.onclose"));
	}

	@Override
	public void onOpen(Connection conn) {
		logger.debug(PtsResources.getProperty("socket.onopen") + conn);
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
			game.setPlayerInfo(clientMessage.getUserType(), conn);
		}

		game.makeChanges(clientMessage);

	}
}
