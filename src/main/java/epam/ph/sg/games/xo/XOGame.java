package epam.ph.sg.games.xo;

/**
 * @author Talash Pavlo
 */
import epam.ph.sg.models.User;

public class XOGame {
	private XOField xoField = new XOField(); // XOFields of this game
	private XOAI ai = new XOAI(xoField); // XOAI of this game
	private XOStatus status = new XOStatus(); // Status of this game

	private User server = null; // Server User instance
	private User client = null; // Client User instance

	private int gameTimerCount = 0;

	/**
	 * Wait for client time out
	 */
	private int serverTimerCount = 0;

	public void serverTimeOut() {
		serverTimerCount++;
		final int myTimerCount = serverTimerCount;
		new Thread() {
			@Override
			public void run() {
				try {
					sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (myTimerCount == serverTimerCount) {
					XOConnector.getServerMap().remove(server.getId());
				}
			}
		}.start();
	}

	/**
	 * Player move time out
	 * 
	 * @param id
	 *            - Player id
	 */
	public void gameTimeOut(final int id) {
		gameTimerCount++;
		final int myTimerCount = gameTimerCount;
		new Thread() {
			@Override
			public void run() {
				try {
					sleep(17000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (myTimerCount == gameTimerCount) {
					if (status.getLastPlayer() == id) {
						status.setWinnerId(id);
						status.setTimeOut(true);
						if (id == server.getId()) {
							XOStatistics.win(server.getId());
							XOStatistics.lose(client.getId());
							status.setLastPlayer(client.getId());
						} else if (id == client.getId()) {
							XOStatistics.win(client.getId());
							XOStatistics.lose(server.getId());
							status.setLastPlayer(server.getId());
						}
					}
				}
			}
		}.start();
	}

	/**
	 * Set game status Player out and change player statistics
	 * 
	 * @param outId
	 *            - Outer id
	 */
	public void out(int outId) {
		status.setLastPlayer(outId);
		status.setPlayerOut(true);
		if (outId == server.getId()) {
			status.setWinnerId(client.getId());
			XOStatistics.win(client.getId());
			XOStatistics.lose(server.getId());
		} else if (outId == client.getId()) {
			status.setWinnerId(server.getId());
			XOStatistics.win(server.getId());
			XOStatistics.lose(client.getId());
		}
	}

	/**
	 * Set game status Game over and change player statistics
	 * 
	 * @param winnerID
	 *            - Winner id
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

	public XOField getXoFields() {
		return xoField;
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
