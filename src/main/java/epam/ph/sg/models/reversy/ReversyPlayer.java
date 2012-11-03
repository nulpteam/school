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
	public ReversyPlayer() {
		// TODO Auto-generated constructor stub
		name = "Unknown Player";
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
}