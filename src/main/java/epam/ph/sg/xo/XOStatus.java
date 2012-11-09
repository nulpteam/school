package epam.ph.sg.xo;

/**
 * @author Paul Michael T.
 */
public class XOStatus {
	private boolean gameOver;
	private int winnerId;
	private boolean playerOut;
	private int outId;
	private int lastPlayer;
	private XOBox lastBox;
	
	public boolean isGameOver() {
		return gameOver;
	}
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	public int getWinnerId() {
		return winnerId;
	}
	public void setWinnerId(int winnerId) {
		this.winnerId = winnerId;
	}
	public boolean isPlayerOut() {
		return playerOut;
	}
	public void setPlayerOut(boolean playerOut) {
		this.playerOut = playerOut;
	}
	public int getOutId() {
		return outId;
	}
	public void setOutId(int outId) {
		this.outId = outId;
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
