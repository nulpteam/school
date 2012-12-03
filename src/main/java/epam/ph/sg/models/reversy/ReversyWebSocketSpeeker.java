package epam.ph.sg.models.reversy;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket;

import epam.ph.sg.controllers.ReversyController;

public class ReversyWebSocketSpeeker implements WebSocket.OnTextMessage {
	
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
			
			
			if (ReversyGameList.getGame(gameID) != null) {
				if (playerName.equalsIgnoreCase(ReversyGameList.getGame(gameID).getPlayer1().getName())) {
					ReversyGameList.getGame(gameID).getPlayer1().setConnection(conn);
				} else if (playerName.equalsIgnoreCase(ReversyGameList.getGame(gameID).getPlayer2().getName())) {
					ReversyGameList.getGame(gameID).getPlayer2().setConnection(conn);
					ReversyController.activeGames.put(gameID, ReversyGameList.getGameList().get(gameID));
					ReversyGameList.removeGameFromList(gameID);
				}
			}
			if (ReversyController.activeGames.get(gameID) != null) {
				if (playerName.equalsIgnoreCase(ReversyController.activeGames.get(gameID).getPlayer1().getName())) {
					ReversyController.activeGames.get(gameID).getPlayer1().setConnection(conn);
				} else if (playerName.equalsIgnoreCase(ReversyController.activeGames.get(gameID).getPlayer2().getName())) {
					ReversyController.activeGames.get(gameID).getPlayer2().setConnection(conn);
				}
			}
		}
	}
}
