package epam.ph.sg.models.reversy;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket;

import epam.ph.sg.controllers.ReversyController;

public class ReversyWebSocketSpeeker implements WebSocket.OnTextMessage {
	public static HashMap<Integer, ReversyGame> activeGames = new HashMap<Integer, ReversyGame>();
	private static Logger log = Logger.getLogger(ReversyWebSocketSpeeker.class);
	private Connection conn;

	@Override
	public void onClose(int arg0, String arg1) {
		log.debug(ReversyController.boundle.getString("message.socket.closed"));
	}

	@Override
	public void onOpen(Connection conn) {
		conn.setMaxIdleTime(1800000);
		log.debug(ReversyController.boundle.getString("message.socket.created"));
		this.conn = conn;
		log.debug(this.conn);
	}

	@Override
	public void onMessage(String message) {
		log.debug(ReversyController.boundle.getString("message.socket.onMessage") + message);
		String[] temporary = message.split("&");
		String messageType = temporary[0];
		if (messageType.equalsIgnoreCase(ReversyController.boundle.getString("message.socket.onMessage.type.connection"))) {
			Integer gameID = Integer.parseInt(temporary[1]);
			String playerName = temporary[2];
			
			log.debug(gameID);
			log.debug(playerName);
			
			
			if (ReversyGameList.getGameList().get(gameID) != null) {
				if (playerName.equalsIgnoreCase(ReversyGameList.getGameList().get(gameID).getPlayer1().getName())) {
					ReversyGameList.getGameList().get(gameID).getPlayer1().setConnection(conn);
				} else if (playerName.equalsIgnoreCase(ReversyGameList.getGameList().get(gameID).getPlayer2().getName())) {
					ReversyGameList.getGameList().get(gameID).getPlayer2().setConnection(conn);
					activeGames.put(gameID, ReversyGameList.getGameList().get(gameID));
					ReversyGameList.removeGameFromList(gameID);
				}
			} else if (activeGames.get(gameID) != null) {
				if (playerName.equalsIgnoreCase(ReversyGameList.getGameList().get(gameID).getPlayer1().getName())) {
					activeGames.get(gameID).getPlayer1().setConnection(conn);
				} else if (playerName.equalsIgnoreCase(ReversyGameList.getGameList().get(gameID).getPlayer2().getName())) {
					activeGames.get(gameID).getPlayer2().setConnection(conn);
				}
			}
		}
	}
}
