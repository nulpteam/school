package epam.ph.sg.models.infection;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket;

import epam.ph.sg.models.points.PtsClientMessage;
import epam.ph.sg.models.points.PtsGame;
import epam.ph.sg.models.points.PtsGameMap;
import epam.ph.sg.models.points.PtsResources;

public class InfWebSocketSpeaker implements WebSocket.OnTextMessage {

	private Logger log;
	private Connection conn;
	private InfJsonParser jsonParser;


	public InfWebSocketSpeaker() {
		log = Logger.getLogger(InfWebSocketSpeaker.class);
		jsonParser = new InfJsonParser();
	}

	@Override
	public void onClose(int arg0, String arg1) {
		log.debug("Socket closed");
	}

	@Override
	public void onOpen(Connection connection) {
		log.debug("Socket created");
		this.conn =connection;

	}

	@Override
	public void onMessage(String json) {
		log.debug("Recieved message");
		log.debug("JSON MESSAGE"+json);

		InfClientMessage clientMessage = jsonParser.parseJsonMessage(json);
		log.debug("abra"+clientMessage.getGameId()+"client"+clientMessage.getClientName()+"server"+clientMessage.getServerName());
		InfGame game = InfGameMap.getGames().get(clientMessage.getGameId());

		if (clientMessage.getType().equals("userInfo")) {
			game.setPlayerInfo(clientMessage.getUserType(), conn);
		}
        
		game.changeGame(clientMessage);
		

	}
}

