package epam.ph.sg.models.infection;

import java.io.Serializable;

import org.eclipse.jetty.websocket.WebSocket.Connection;

public class InfPlayer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7574095889596112245L;
	private String name;
	private Connection conn;
	private String gameId;
	private boolean lock;
	
	

	public InfPlayer() {
		name = "";
		conn = null;
		gameId = "";
		lock = true;
	}

	public InfPlayer(String name, String gameId) {
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
