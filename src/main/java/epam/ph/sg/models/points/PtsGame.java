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
	private static int gameNumber = 0;
	private String id;
	private PtsCounturMarker counturMarker;

	public PtsGame() {
		board = new PtsBoard();
		id = new Integer(gameNumber++).toString();
		jsonParser = new PtsJsonParser();
		server = new PtsPlayer();
		client = new PtsPlayer();
		counturMarker = new PtsCounturMarker();
	}

	public void makeChanges(PtsClientMessage clientMessage) {

		if (clientMessage.getType().equals(
				PtsResources.getProperty("user.message.type.initialize"))) {

				PtsGameInfoMessage message = new PtsGameInfoMessage();
				message.initializeBoard(board.getBoard());
				message.setServerLock(server.isLock());
				message.setClientLock(client.isLock());
				message.setServerName(server.getName());
				message.setClientName(client.getName());
				if (clientMessage.getUserType().equals(
						PtsResources.getProperty("user.type.server")))
					sendGameInfo(PtsResources.getProperty("user.type.server"),
							message);
				else if (clientMessage.getUserType().equals(
						PtsResources.getProperty("user.type.client")))
					sendGameInfo(PtsResources.getProperty("user.type.client"),
							message);
				else
					logger.error(PtsResources
							.getProperty("error.user_type.don't_exist")
							+ clientMessage.getUserType());
		}

		if (clientMessage.getType().equals(
				PtsResources.getProperty("user.message.type.last_changes"))) {

				if (clientMessage.getUserType().equals(
						PtsResources.getProperty("user.type.server"))) {
	
						board.putPoint(PtsResources.getProperty("user.type.server"),
								clientMessage.getCoords());
		
						if (counturMarker.markCountur(board.getBoard(),
								board.getLastY(), board.getLastX(),
								clientMessage.getUserType())) {
							board.printBoard();
						}
		
						server.setLock(true);
						client.setLock(false);
						PtsClientMessage message = new PtsClientMessage();
						message.setType(PtsResources
								.getProperty("user.message.type.last_changes"));
						message.setCoords(clientMessage.getCoords());
						message.setUserType(PtsResources
								.getProperty("user.type.client"));
						sendMessage(PtsResources.getProperty("user.type.client"),
								message);
	
				} else if (clientMessage.getUserType().equals(
						PtsResources.getProperty("user.type.client"))) {
	
						board.putPoint(PtsResources.getProperty("user.type.client"),
								clientMessage.getCoords());
		
						if (counturMarker.markCountur(board.getBoard(),
								board.getLastY(), board.getLastX(),
								clientMessage.getUserType())) {
							board.printBoard();
						}
		
						client.setLock(true);
						server.setLock(false);
						PtsClientMessage message = new PtsClientMessage();
						message.setType(PtsResources
								.getProperty("user.message.type.last_changes"));
						message.setCoords(clientMessage.getCoords());
						message.setUserType(PtsResources
								.getProperty("user.type.server"));
						sendMessage(PtsResources.getProperty("user.type.server"),
								message);
				}
		}
	}

	public void setPlayerInfo(String playerType, Connection conn) {

		if (playerType.equals(PtsResources.getProperty("user.type.server"))) {

			server.setConn(conn);
			PtsClientMessage message = new PtsClientMessage();
			message.setType(PtsResources
					.getProperty("user.message.type.server.connect"));
			message.setServerName(server.getName());
			sendMessage(PtsResources.getProperty("user.type.server"), message);

		} else if (playerType.equals(PtsResources
				.getProperty("user.type.client"))) {

			client.setConn(conn);
			PtsClientMessage message = new PtsClientMessage();
			message.setType(PtsResources
					.getProperty("user.message.type.server.connect"));
			message.setClientName(client.getName());
			message.setServerName(server.getName());
			sendMessage(PtsResources.getProperty("user.type.client"), message);
			sendMessage(PtsResources.getProperty("user.type.server"), message);

		}
	}

	private void sendGameInfo(String userType, PtsGameInfoMessage message) {

		try {

			if (userType.equals(PtsResources.getProperty("user.type.server"))) {

				server.getConn().sendMessage(
						jsonParser.convertGameInfoMessageToJson(message));

			} else if (userType.equals(PtsResources
					.getProperty("user.type.client"))) {

				client.getConn().sendMessage(
						jsonParser.convertGameInfoMessageToJson(message));

			}

		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	private void sendMessage(String userType, PtsClientMessage message) {

		try {

			if (userType.equals(PtsResources.getProperty("user.type.server"))) {

				server.getConn().sendMessage(
						jsonParser.convertClientMessageToJson(message));

			} else if (userType.equals(PtsResources
					.getProperty("user.type.client"))) {

				client.getConn().sendMessage(
						jsonParser.convertClientMessageToJson(message));

			}

		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	public void reduceGamesNUmber() {
		gameNumber--;
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

}
