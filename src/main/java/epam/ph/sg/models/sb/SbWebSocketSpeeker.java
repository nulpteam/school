package epam.ph.sg.models.sb;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket;

public class SbWebSocketSpeeker implements WebSocket.OnTextMessage {
	private static Logger log = Logger.getLogger(SbWebSocketSpeeker.class);
	private Connection conn;
	
	static
	{
		log.debug("+++++++++++++++SbWebSocketSpeeker loaded++++++++++++++++++++++");
	}
	@Override
	public void onClose(int arg0, String arg1) {
		log.debug("++++++++++++Socket closed++++++++++++++");
		
	}

	@Override
	public void onOpen(Connection conn) {
		this.conn = conn;
		log.debug("++++++++++++Socket created++++++++++++++");
		
	}

	@Override
	public void onMessage(String message) {
		
		String[] temporary = message.split("&");
		Integer gameID = Integer.parseInt(temporary[0]);
		String userName = temporary[1];
		BSPlayer player = new BSPlayer();
		player.setName(userName);
		log.debug("++++++++++++message++++++++++++++");
		log.debug(message);
		log.debug(gameID);
		log.debug(userName);
		log.debug("player name= "+player.getName());
		log.debug("++++++++++++message++++++++++++++");
		log.debug("++++++++++++error supposed++++++++++++++");
		log.debug(GamesList.getGameListBS().get(gameID).getPlayer1().getName());
		log.debug("++++++++++++error supposed++++++++++++++");
		
//		if (GamesList.getGameListBS().get(gameID).getPlayer1() != null) {
//			log.debug("++++++++++++In if++++++++++++++");
//			GamesList.getGameListBS().get(gameID).setPlayer2(player);
//			GamesList.getGameListBS().get(gameID).setConnection2(conn);
//		} else {
//			log.debug("++++++++++++In else++++++++++++++");
//			GamesList.getGameListBS().get(gameID).setPlayer1(player);
//			GamesList.getGameListBS().get(gameID).setConnection1(conn);
//		}
		
		log.debug("++++++++++++Recieved message++++++++++++++");
		log.debug(message);
	}
}
