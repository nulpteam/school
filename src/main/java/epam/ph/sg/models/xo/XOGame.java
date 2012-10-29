package epam.ph.sg.models.xo;

import epam.ph.sg.models.User;

/**
 * @author Paul Michael T.
 */
public class XOGame {
	private XOFields xoFields = new XOFields(); // XOFields of this game
	private XOAI ai = new XOAI(xoFields); // XOAI of this game
	private User server; // Server User instance
	private User client; // Client User instance

	private int status = XO.WITHOUT_CLIENT; // Status of this game
	private XOBox lastBox = null; // Last changed box on the field;

	/**
	 * Set game status XO.OUT and change player statistics
	 * 
	 * @param winnerID
	 */
	public void out(int loserID) {
		status = XO.OUT;

		if (loserID == server.getId()) {
			XOStatistics.win(client.getId());
			XOStatistics.lose(server.getId());
		} else if (loserID == client.getId()) {
			XOStatistics.win(server.getId());
			XOStatistics.lose(client.getId());
		}
	}
	
	/**
	 * Set game status XO.GAME_OVER and change player statistics
	 * 
	 * @param winnerID
	 */
	public void gameOver(int winnerID) {
		status = XO.GAME_OVER;

		if (winnerID == server.getId()) {
			XOStatistics.win(server.getId());
			XOStatistics.lose(client.getId());
		} else if (winnerID == client.getId()) {
			XOStatistics.win(client.getId());
			XOStatistics.lose(server.getId());
		}
	}

	/**
	 * XOAI getter
	 * 
	 * @return XOAI of this game
	 */
	public XOAI getAi() {
		return ai;
	}

	/**
	 * XOFields getter
	 * 
	 * @return XOFields of this game
	 */
	public XOFields getXoFields() {
		return xoFields;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public XOBox getLastBox() {
		return lastBox;
	}

	public void setLastBox(XOBox lastBox) {
		this.lastBox = lastBox;
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
