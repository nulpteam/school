package epam.ph.sg.models.points;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket;

public class PtsWebSocketSpeeker implements WebSocket.OnTextMessage {

	private static Logger log = Logger.getLogger(PtsWebSocketSpeeker.class);
	private Connection conn;
	private PtsJsonParser jsonParser;

	public PtsWebSocketSpeeker() {
		jsonParser = new PtsJsonParser();
	}

	@Override
	public void onClose(int arg0, String arg1) {
		log.debug("Socket closed");
	}

	@Override
	public void onOpen(Connection conn) {
		log.debug("Socket created");
		this.conn = conn;
		System.out.println(this.conn);

	}

	@Override
	public void onMessage(String json) {
		log.debug("Recieved message");
		log.debug(json);
		
		
		PtsClientMessage clientMessage = jsonParser.parseJsonMessage(json);
		PtsGame game = PtsGameMap.getGames()
				.get(clientMessage.getGameId());
		
		if (clientMessage.getType().equals("userInfo")) {
			game.setPlayerInfo(clientMessage.getUserType(), conn);
		}
		
		game.makeChanges(clientMessage);

		// PtsLastChanges lastChanges =
		// jsonParser.parseJsonPtsLastChanges(json);

		// //json = "{\"type\":\"message\"," + json.substring(1);
		// System.out.println(jsonMessageType);
		// //conn.sendMessage(json);
	}
}
