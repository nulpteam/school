package epam.ph.sg.models.reversy;

import org.eclipse.jetty.websocket.WebSocket.Connection;

/**
 * 
 * @author SergiyManko
 *
 */

public class ReversyPlayer {
	private String name;
	private Connection connection;
	private int gameView;
	private String figure;
	public ReversyPlayer() {
		// TODO Auto-generated constructor stub
		name = "Unknown Player";
		gameView = 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public String getFigure() {
		return figure;
	}

	public void setFigure(String figure) {
		this.figure = figure;
	}

	public int getGameView() {
		return gameView;
	}

	public void setGameView(int gameView) {
		this.gameView = gameView;
	}
}