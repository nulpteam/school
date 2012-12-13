package epam.ph.sg.models.points;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket.Connection;

public class PtsGameMessanger {

	private PtsJsonParser jsonParser;
	private static Logger logger;

	public PtsGameMessanger() {

		jsonParser = new PtsJsonParser();
		logger = Logger.getLogger(PtsGameMessanger.class);
	}

	public void processMessage(PtsClientMessage clientMessage, PtsGame game) {

		if (clientMessage.getType().equals(
				PtsResources.getProperty("user.message.type.initialize"))) {
			PtsGameInfoMessage message = new PtsGameInfoMessage();
			message.initializeBoard(game.getGameTable());
			message.setServerLock(game.getServer().isLock());
			message.setClientLock(game.getClient().isLock());
			message.setServerName(game.getServer().getName());
			message.setClientName(game.getClient().getName());
			message.initClientContours(game.getBoard()
					.getAllClientContours());
			message.initServerContours(game.getBoard()
					.getAllServerContours());
			message.setActiveMainMenu(game.isSurrenderMainMenuActive());
			message.setActivePointsMenu(game.isSurrenderPointsMenuActive());
			message.setUserTypeActiveMenu(game.getUserTypeActiveMenu());
			message.setLastX(game.getBoard().getLastX());
			message.setLastY(game.getBoard().getLastY());
			message.setTimerState(game.getTimerState());
			if (clientMessage.getUserType().equals(
					PtsResources.getProperty("user.type.server"))) {
				message.setUserType(PtsResources
						.getProperty("user.type.server"));
				sendGameInfo(message, game.getServer().getConn());
			} else if (clientMessage.getUserType().equals(
					PtsResources.getProperty("user.type.client"))) {
				message.setUserType(PtsResources
						.getProperty("user.type.client"));
				sendGameInfo(message, game.getClient().getConn());
			} else
				logger.error(PtsResources
						.getProperty("error.user_type.don't_exist")
						+ clientMessage.getUserType());
		}

		if (clientMessage.getType().equals(
				PtsResources.getProperty("user.message.type.surrender"))) {

			game.setSurrenderMainMenuActive(clientMessage.isActiveMainMenu());
			game.setSurrenderPointsMenuActive(clientMessage
					.isActivePointsMenu());
			game.setUserTypeActiveMenu(clientMessage.getUserType());
		}
		
		if (clientMessage.getType().equals(
				PtsResources.getProperty("user.message.type.time"))) {

			if (clientMessage.getTimerState().equals("start"))
				game.startTimer();
			else 
				game.stopTimer();
			
		}

		if (clientMessage.getType().equals(
				PtsResources.getProperty("user.message.type.player_loose"))) {

			PtsClientMessage message = new PtsClientMessage();
			message.setType(PtsResources
					.getProperty("user.message.type.player_win"));

			if (clientMessage.getUserType().equals(
					PtsResources.getProperty("user.type.server"))) {

				sendMessage(message, game.getClient().getConn());

			} else if (clientMessage.getUserType().equals(
					PtsResources.getProperty("user.type.client"))) {

				sendMessage(message, game.getServer().getConn());

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

				sendMessage(message, game.getClient().getConn());

			} else if (clientMessage.getUserType().equals(
					PtsResources.getProperty("user.type.client"))) {

				sendMessage(message, game.getServer().getConn());

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

				game.getBoard().putPoint(
						PtsResources.getProperty("user.type.server"),
						clientMessage.getCoords());
				game.getServer().setLock(true);
				game.getClient().setLock(false);
				List<List<PtsCoord>> contoursList = PtsContourMarker.markContours(
						game.getGameTable(), game.getLogicBoard().getBoard(), game
								.getBoard().getLastY(), game.getBoard()
								.getLastX(), Pts.SERVER_UNMARKED_POINT);
				
				if (contoursList != null && contoursList.size() >= 1) {
					game.getBoard().addContours(
							contoursList,
							getPlayerByContourPoint(contoursList.get(0).get(0),
									game.getGameTable()));
					PtsGameInfoMessage message = new PtsGameInfoMessage();
					message.setType(PtsResources
							.getProperty("user.message.type.contour"));
					message.initializeBoard(game.getBoard().getBoard());
					message.initLastContours(contoursList);
					message.setUserType(getPlayerByContourPoint(contoursList
							.get(0).get(0), game.getGameTable()));
					sendGameInfo(message, game.getServer().getConn());
					sendGameInfo(message, game.getClient().getConn());
				}

				PtsClientMessage message = new PtsClientMessage();
				message.setType(PtsResources
						.getProperty("user.message.type.last_changes"));
				message.setCoords(clientMessage.getCoords());
				message.setUserType(PtsResources
						.getProperty("user.type.client"));
				sendMessage(message, game.getClient().getConn());

			} else if (clientMessage.getUserType().equals(
					PtsResources.getProperty("user.type.client"))) {

				game.getBoard().putPoint(
						PtsResources.getProperty("user.type.client"),
						clientMessage.getCoords());
				game.getClient().setLock(true);
				game.getServer().setLock(false);
				List<List<PtsCoord>> contoursList = PtsContourMarker.markContours(
						game.getGameTable(), game.getLogicBoard().getBoard(), game
								.getBoard().getLastY(), game.getBoard()
								.getLastX(), Pts.CLIENT_UNMARKED_POINT);
				if (contoursList != null && contoursList.size() >= 1) {
					game.getBoard().addContours(
							contoursList,
							getPlayerByContourPoint(contoursList.get(0).get(0),
									game.getGameTable()));
					PtsGameInfoMessage message = new PtsGameInfoMessage();
					message.setType(PtsResources
							.getProperty("user.message.type.contour"));
					message.initializeBoard(game.getGameTable());
					message.initLastContours(contoursList);
					message.setUserType(getPlayerByContourPoint(contoursList
							.get(0).get(0), game.getGameTable()));
					sendGameInfo(message, game.getServer().getConn());
					sendGameInfo(message, game.getClient().getConn());
				}

				PtsClientMessage message = new PtsClientMessage();
				message.setType(PtsResources
						.getProperty("user.message.type.last_changes"));
				message.setCoords(clientMessage.getCoords());
				message.setUserType(PtsResources
						.getProperty("user.type.server"));
				sendMessage(message, game.getServer().getConn());
			}
		}
	}

	public void setPlayerInfo(String playerType, Connection conn, PtsGame game) {

		if (playerType.equals(PtsResources.getProperty("user.type.server"))) {

			game.getServer().setConn(conn);
			PtsClientMessage message = new PtsClientMessage();
			message.setType(PtsResources
					.getProperty("user.message.type.server.connect"));
			message.setServerName(game.getServer().getName());
			sendMessage(message, game.getServer().getConn());

		} else if (playerType.equals(PtsResources
				.getProperty("user.type.client"))) {

			game.getClient().setConn(conn);
			PtsClientMessage message = new PtsClientMessage();
			message.setType(PtsResources
					.getProperty("user.message.type.client.connect"));
			message.setClientName(game.getClient().getName());
			message.setServerName(game.getServer().getName());
			sendMessage(message, game.getClient().getConn());
			
			PtsClientMessage messageToServer = new PtsClientMessage();
			messageToServer.setType(PtsResources
					.getProperty("user.message.type.server.connect"));
			messageToServer.setClientName(game.getClient().getName());
			messageToServer.setServerName(game.getServer().getName());
			if (game.isSetTimer() == true) {
				messageToServer.setTimer(true);
				game.setSetTimer(false);
			}
			sendMessage(messageToServer, game.getServer().getConn());

		}
	}

	private void sendGameInfo(PtsGameInfoMessage message, Connection conn) {

		try {
			conn.sendMessage(jsonParser.convertGameInfoMessageToJson(message));
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	private void sendMessage(PtsClientMessage message, Connection conn) {

		try {
			conn.sendMessage(jsonParser.convertClientMessageToJson(message));
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	private String getPlayerByContourPoint(PtsCoord coord, int[][] board) {

		if (board[coord.getY()][coord.getX()] == Pts.CLIENT_MARKED_POINT) {
			return PtsResources.getProperty("user.type.client");
		} else {
			return PtsResources.getProperty("user.type.server");
		}
	}
}
