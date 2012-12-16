/**
 * @author Gutey Bogdan
 * 
 */
package epam.ph.sg.models.sb;

import org.eclipse.jetty.websocket.WebSocket.Connection;

public class Server {
	private BSPlayer player;
	private BSBoard gameBoard;
	private Connection conn;
	private boolean started;
	
	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public BSPlayer getPlayer() {
		return player;
	}

	public void setPlayer(BSPlayer player) {
		this.player = player;
	}

	public BSBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(BSBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public String toString() {
		return player + "\n" + gameBoard+"\nStarted="+started+"\nconn="+conn;
	}
}
