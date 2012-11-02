package epam.ph.sg.models.sb;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket;

public class SbWebSocketSpeeker implements WebSocket.OnTextMessage {
	private static Logger log = Logger.getLogger(SbWebSocketSpeeker.class);
	private Connection conn;

	static {
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
		String connectionType = temporary[2];
		log.debug("++++++++++++gameID = "+gameID+"++++++++++++++");
		log.debug("++++++++++++userName = "+userName+"++++++++++++++");
		log.debug("++++++++++++connectionType = "+connectionType+"++++++++++++++");
		if(connectionType.equalsIgnoreCase("server"))
		{
			log.debug("++++++++++++server v pershomu if++++++++++++++");
			if(ActiveGames.getGame(gameID).getServer().getConn()!=null)
			{
				log.debug("++++++++++++server v drugomu if++++++++++++++");
				ActiveGames.getGame(gameID).getServer().getConn().close();
			}
			ActiveGames.getGame(gameID).getServer().setConn(conn);
		}
		if(connectionType.equalsIgnoreCase("client"))
		{log.debug("++++++++++++client v pershomu if++++++++++++++");
			if(ActiveGames.getGame(gameID).getClient().getConn()!=null)
			{log.debug("++++++++++++client v pershomu if++++++++++++++");
				ActiveGames.getGame(gameID).getClient().getConn().close();
			}
			ActiveGames.getGame(gameID).getClient().setConn(conn);
		}
		/*BSPlayer player = new BSPlayer();
		player.setName(userName);*/

		/*if ((GamesList.getGameListBS().get(gameID).getPlayer1() != null)&&(!GamesList.getGameListBS().get(gameID).getPlayer1().getName().equals(userName))) {
			GamesList.getGameListBS().get(gameID).setPlayer2(player);
			GamesList.getGameListBS().get(gameID).setConnection2(conn);
		} else {
			GamesList.getGameListBS().get(gameID).setPlayer1(player);
			GamesList.getGameListBS().get(gameID).setConnection1(conn);
		}*/

		log.debug("++++++++++++Recieved message++++++++++++++");
		log.debug(message);
		
		/*try {
			conn.sendMessage("Hello " + userName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {
			if(ActiveGames.getGame(gameID).getServer().getConn()!=null )
			{
				if( ActiveGames.getGame(gameID).getServer().getConn().isOpen())
				{
					log.debug("++++++++++++server v send++++++++++++++");
					ActiveGames.getGame(gameID).getServer().getConn().sendMessage("TTTEESSSTTT server messages");
				}
				
			}
			if(ActiveGames.getGame(gameID).getClient().getConn()!=null )
			{
				if(ActiveGames.getGame(gameID).getClient().getConn().isOpen())
				{
					log.debug("++++++++++++client v send++++++++++++++");
					ActiveGames.getGame(gameID).getClient().getConn().sendMessage("TTTEESSSTTT client messages");	
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
	}
}
