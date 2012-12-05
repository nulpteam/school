package epam.ph.sg.models.points;

/**
 * @author Kostya Skromnuy
 * 
 */

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket.Connection;

public class PtsGame {

	private static Logger logger = Logger.getLogger(PtsWebSocketSpeeker.class);

	private PtsJsonParser jsonParser;
	private PtsPlayer server, client;
	private PtsBoard board, logicBoard;
	private static int gameNumber = 0;
	private int id;
	private PtsContourMarker contourMarker;
	private boolean surrenderMainMenuActive;
	private boolean surrenderPointsMenuActive;
	private String userTypeActiveMenu;

	public PtsGame() {
		board = new PtsBoard();
		logicBoard = new PtsBoard();
		id = gameNumber++;
		jsonParser = new PtsJsonParser();
		server = new PtsPlayer();
		client = new PtsPlayer();
		contourMarker = new PtsContourMarker();
		surrenderMainMenuActive = false;
		surrenderPointsMenuActive = false;
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
			message.initClientContours(board.getAllClientContours());
			message.initServerContours(board.getAllServerContours());
			message.setActiveMainMenu(surrenderMainMenuActive);
			message.setActivePointsMenu(surrenderPointsMenuActive);
			message.setUserTypeActiveMenu(userTypeActiveMenu);
			message.setLastX(board.getLastX());
			message.setLastY(board.getLastY());
			if (clientMessage.getUserType().equals(
					PtsResources.getProperty("user.type.server"))) {
				message.setUserType(PtsResources
						.getProperty("user.type.server"));
				sendGameInfo(PtsResources.getProperty("user.type.server"),
						message);
			} else if (clientMessage.getUserType().equals(
					PtsResources.getProperty("user.type.client"))) {
				message.setUserType(PtsResources
						.getProperty("user.type.client"));
				sendGameInfo(PtsResources.getProperty("user.type.client"),
						message);
			} else
				logger.error(PtsResources
						.getProperty("error.user_type.don't_exist")
						+ clientMessage.getUserType());
		}

		if (clientMessage.getType().equals(
				PtsResources.getProperty("user.message.type.surrender"))) {

			surrenderMainMenuActive = clientMessage.isActiveMainMenu();
			surrenderPointsMenuActive = clientMessage.isActivePointsMenu();
			userTypeActiveMenu = clientMessage.getUserType();
		}

		if (clientMessage.getType().equals(
				PtsResources.getProperty("user.message.type.player_loose"))) {

			PtsClientMessage message = new PtsClientMessage();
			message.setType(PtsResources
					.getProperty("user.message.type.player_win"));
			
			if (clientMessage.getUserType().equals(
					PtsResources.getProperty("user.type.server"))) {
					
				sendMessage(PtsResources.getProperty("user.type.client"), message);
				
			} else if (clientMessage.getUserType().equals(
					PtsResources.getProperty("user.type.client"))) {
				
				sendMessage(PtsResources.getProperty("user.type.server"), message);
				
			} else {
				logger.error(PtsResources
						.getProperty("error.user_type.don't_exist")
						+ clientMessage.getUserType());
			}
		}
		
		if (clientMessage.getType().equals(
				PtsResources.getProperty("user.message.type.player_win"))) {

			PtsClientMessage message = new PtsClientMessage();
			message.setType(PtsResources
					.getProperty("user.message.type.player_loose"));
			
			if (clientMessage.getUserType().equals(
					PtsResources.getProperty("user.type.server"))) {
					
				sendMessage(PtsResources.getProperty("user.type.client"), message);
				
			} else if (clientMessage.getUserType().equals(
					PtsResources.getProperty("user.type.client"))) {
				
				sendMessage(PtsResources.getProperty("user.type.server"), message);
				
			} else {
				logger.error(PtsResources
						.getProperty("error.user_type.don't_exist")
						+ clientMessage.getUserType());
			}
		}

		if (clientMessage.getType().equals(
				PtsResources.getProperty("user.message.type.last_changes"))) {

			if (clientMessage.getUserType().equals(
					PtsResources.getProperty("user.type.server"))) {

				board.putPoint(PtsResources.getProperty("user.type.server"),
						clientMessage.getCoords());
				server.setLock(true);
				client.setLock(false);
				List<List<PtsCoord>> contoursList = contourMarker.markContours(
						board.getBoard(), logicBoard.getBoard(),
						board.getLastY(), board.getLastX(),
						Pts.SERVER_UNMARKED_POINT);
				if (contoursList != null && contoursList.size() >= 1) {
					board.addContours(contoursList,
							getPlayerByContourPoint(contoursList.get(0).get(0)));
					PtsGameInfoMessage message = new PtsGameInfoMessage();
					message.setType(PtsResources
							.getProperty("user.message.type.contour"));
					message.initializeBoard(board.getBoard());
					message.initLastContours(contoursList);
					message.setUserType(getPlayerByContourPoint(contoursList
							.get(0).get(0)));
					sendGameInfo(PtsResources.getProperty("user.type.server"),
							message);
					sendGameInfo(PtsResources.getProperty("user.type.client"),
							message);
				}
				logicBoard.printBoard();
				board.printBoard();

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
				client.setLock(true);
				server.setLock(false);
				List<List<PtsCoord>> contoursList = contourMarker.markContours(
						board.getBoard(), logicBoard.getBoard(),
						board.getLastY(), board.getLastX(),
						Pts.CLIENT_UNMARKED_POINT);
				if (contoursList != null && contoursList.size() >= 1) {
					board.addContours(contoursList,
							getPlayerByContourPoint(contoursList.get(0).get(0)));
					PtsGameInfoMessage message = new PtsGameInfoMessage();
					message.setType(PtsResources
							.getProperty("user.message.type.contour"));
					message.initializeBoard(board.getBoard());
					message.initLastContours(contoursList);
					message.setUserType(getPlayerByContourPoint(contoursList
							.get(0).get(0)));
					sendGameInfo(PtsResources.getProperty("user.type.server"),
							message);
					sendGameInfo(PtsResources.getProperty("user.type.client"),
							message);
				}
				logicBoard.printBoard();
				board.printBoard();

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
					.getProperty("user.message.type.client.connect"));
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

	public int getId() {
		return id;
	}

	private String getPlayerByContourPoint(PtsCoord coord) {

		if (board.getBoard()[coord.getY()][coord.getX()] == Pts.CLIENT_MARKED_POINT) {
			return PtsResources.getProperty("user.type.client");
		} else {
			return PtsResources.getProperty("user.type.server");
		}
	}

}
