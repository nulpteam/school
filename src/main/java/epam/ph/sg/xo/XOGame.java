package epam.ph.sg.xo;

import epam.ph.sg.models.User;

/**
 * @author Paul Michael T.
 */
public class XOGame {
	private XOFields xoFields = new XOFields(); // XOFields of this game
	private XOAI ai = new XOAI(xoFields); // XOAI of this game
	private XOStatus status = new XOStatus(); // Status of this game
	
	private User server; // Server User instance
	private User client; // Client User instance

	/**
	 * Set game status PlayerOut and change player statistics
	 * 
	 * @param outId - Outer id
	 */
	public void out(int outId) {
		status.setLastPlayer(outId);
		status.setPlayerOut(true);
		status.setOutId(outId);

		if (outId == server.getId()) {
			XOStatistics.win(client.getId());
			XOStatistics.lose(server.getId());
		} else if (outId == client.getId()) {
			XOStatistics.win(server.getId());
			XOStatistics.lose(client.getId());
		}
	}
	
	/**
	 * Set game status GameOver and change player statistics
	 * 
	 * @param winnerID - Winner id
	 */
	public void gameOver(int winnerId) {
		status.setGameOver(true);
		status.setWinnerId(winnerId);
		
		if (winnerId == server.getId()) {
			XOStatistics.win(server.getId());
			XOStatistics.lose(client.getId());
		} else if (winnerId == client.getId()) {
			XOStatistics.win(client.getId());
			XOStatistics.lose(server.getId());
		}
	}
	
	public XOAI getAi() {
		return ai;
	}
	
	public XOFields getXoFields() {
		return xoFields;
	}

	public XOStatus getStatus() {
		return status;
	}

	public void setStatus(XOStatus status) {
		this.status = status;
	}

	public User getServer() {
		return server;
	}

	public void setServer(User server) {
		this.server = server;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
}
