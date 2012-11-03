package epam.ph.sg.models.points;

/**
 * @author Kostya Skromnuy
 * 
 */

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

	// private String nextUserToMove;

	public PtsGame() {
		board = new PtsBoard();
		id = new Integer(gamesNumber++).toString();
		jsonParser = new PtsJsonParser();
		server = new PtsPlayer();
		client = new PtsPlayer();
	}

	public void makeChanges(PtsClientMessage clientMessage) {

		if (clientMessage.getType().equals("initialize")) {

			PtsGameInfoMessage message = new PtsGameInfoMessage();
			message.initializeBoard(board.getBoard());
			message.setServerLock(server.isLock());
			message.setClientLock(client.isLock());
			message.setServerName(server.getName());
			message.setClientName(client.getName());
			if (clientMessage.getUserType().equals("server"))
				sendGameInfo("server", message);
			else if (clientMessage.getUserType().equals("client"))
				sendGameInfo("client", message);
			else
				logger.error("no such user type = " + clientMessage.getUserType());
		}

		if (clientMessage.getType().equals("lastChanges")) {
			if (clientMessage.getUserType().equals("server")) {

				board.putPoint("server", clientMessage.getCoords());
				server.setLock(true);
				client.setLock(false);
				PtsClientMessage message = new PtsClientMessage();
				message.setType("lastChanges");
				message.setCoords(clientMessage.getCoords());
				message.setUserType("client");
				sendMessage("client", message);

			} else if (clientMessage.getUserType().equals("client")) {

				board.putPoint("client", clientMessage.getCoords());
				client.setLock(true);
				server.setLock(false);
				PtsClientMessage message = new PtsClientMessage();
				message.setType("lastChanges");
				message.setCoords(clientMessage.getCoords());
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

	private void sendGameInfo(String userType, PtsGameInfoMessage message) {
		
		try {

			if (userType.equals("server")) {
				
				server.getConn().sendMessage(
						jsonParser.convertGameInfoMessageToJson(message));
				

			} else if (userType.equals("client")) {

				client.getConn().sendMessage(
						jsonParser.convertGameInfoMessageToJson(message));

			}

		} catch (IOException e) {
			logger.error(e.getMessage());
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
		server.setLock(false);
		return true;
	}

	public PtsPlayer getServer() {
		return server;
	}

	public boolean setClient(PtsPlayer client) {
		if (client == null)
			return false;
		this.client = client;
		client.setLock(true);
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

	// public boolean isUserMove(String userType) {
	// if (userType.equals(nextUserToMove)) {
	// return true;
	// }
	// return false;
	// }

}
