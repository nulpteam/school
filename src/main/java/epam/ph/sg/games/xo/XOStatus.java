package epam.ph.sg.games.xo;

/**
 * @author Talash Pavlo
 */
public class XOStatus {
	private boolean gameOver = false;
	private boolean playerOut = false;
	private boolean timeOut = false;
	private int winnerId;
	private int lastPlayer;
	private XOBox lastBox;

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public boolean isPlayerOut() {
		return playerOut;
	}

	public void setPlayerOut(boolean playerOut) {
		this.playerOut = playerOut;
	}

	public boolean isTimeOut() {
		return timeOut;
	}

	public void setTimeOut(boolean timeOut) {
		this.timeOut = timeOut;
	}

	public int getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(int winnerId) {
		this.winnerId = winnerId;
	}

	public int getLastPlayer() {
		return lastPlayer;
	}

	public void setLastPlayer(int lastPlayer) {
		this.lastPlayer = lastPlayer;
	}

	public XOBox getLastBox() {
		return lastBox;
	}

	public void setLastBox(XOBox lastBox) {
		this.lastBox = lastBox;
	}
}
