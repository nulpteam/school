package epam.ph.sg.models.points;

import org.eclipse.jetty.websocket.WebSocket.Connection;

public class PtsPlayer {

	private String name;
	private Connection conn;
	private String gameId;
	private boolean lock;
	
	

	public PtsPlayer() {
		name = "";
		conn = null;
		gameId = "undefined";
		lock = true;
	}

	public PtsPlayer(String name, String gameId) {
		this.name = name;
		this.gameId = gameId;
		lock = true;
	}
	
	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
