package epam.ph.sg.models.points;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket.Connection;

public class PtsGame {
	
	private static Logger logger = Logger.getLogger(PtsWebSocketSpeeker.class);
	
	private PtsJsonParser jsonParser;
	private PtsPlayer server, client;
	private PtsBoard board;
	private static int gamesNumber = 0;
	private String id;
//	private String nextUserToMove;

	public PtsGame() {
		board = new PtsBoard();
		id = new Integer(gamesNumber++).toString();
		//nextUserToMove = "server";
		jsonParser = new PtsJsonParser();
	}

	public void makeChanges(PtsClientMessage clientMessage) {
		
		if (clientMessage.getType().equals("lastChanges")) {
			if (clientMessage.getUserType().equals("server")) {
				
				board.putPoint(clientMessage.getCoords());
				PtsClientMessage message = new PtsClientMessage();
				message.setType("lastChanges");
				message.setCoords(clientMessage.getCoords());
				message.setLock("false");
				message.setUserType("client");
				sendMessage("client", message);
				
			} else if (clientMessage.getUserType().equals("client")) {
				
				board.putPoint(clientMessage.getCoords());
				PtsClientMessage message = new PtsClientMessage();
				message.setType("lastChanges");
				message.setCoords(clientMessage.getCoords());
				message.setLock("false");
				message.setUserType("server");
				sendMessage("server", message);
			}
		}
	}

	public void setPlayerInfo(String playerType, Connection conn) {

		if (playerType.equals("server")) {

			server.setConn(conn);
			PtsClientMessage message = new PtsClientMessage();
			message.setType("serverConnect");
			message.setServerName(server.getName());
			sendMessage("server", message);

		} else if (playerType.equals("client")) {

			client.setConn(conn);
			PtsClientMessage message = new PtsClientMessage();
			message.setType("clientConnect");
			message.setClientName(client.getName());
			message.setServerName(server.getName());
			sendMessage("client", message);
			sendMessage("server", message);

		}
	}
	

	private void sendMessage(String userType, PtsClientMessage message) {

		try {
			
			if (userType.equals("server")) {

				server.getConn().sendMessage(
						jsonParser.convertClientMessageToJson(message));

			} else if (userType.equals("client")) {
				
				client.getConn().sendMessage(
						jsonParser.convertClientMessageToJson(message));
				
			}

		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	public void reduceGamesNUmber() {
		gamesNumber--;
	}

	public boolean setServer(PtsPlayer server) {
		if (server == null)
			return false;
		this.server = server;
		return true;
	}

	public PtsPlayer getServer() {
		return server;
	}

	public boolean setClient(PtsPlayer client) {
		if (client == null)
			return false;
		this.client = client;
		return true;
	}

	public PtsPlayer getClient() {
		return client;
	}

	public String getId() {
		return id;
	}

	// public void putPoint(String xy, String user) {
	// board.putPoint(xy, user);
	// if (user.equals("server")) {
	// nextUserToMove = "client";
	// } else {
	// nextUserToMove = "server";
	// }
	// }
	//
	// public PtsLastChanges getLasthangesInBoard() {
	// //if (nextUserToMove.equals(user)) {
	// return board.getLastChanges();
	// //} else {
	// // return new PtsLastChanges();
	// //}
	// }

//	public boolean isUserMove(String userType) {
//		if (userType.equals(nextUserToMove)) {
//			return true;
//		}
//		return false;
//	}

}
