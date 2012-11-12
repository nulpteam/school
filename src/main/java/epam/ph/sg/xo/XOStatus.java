package epam.ph.sg.xo;

/**
 * @author Paul Michael T.
 */
public class XOStatus {
	private boolean gameOver;
	private boolean playerOut;
	private boolean timeOut;
	private int winnerId;
	private int lastPlayer;
	private XOBox lastBox;
	/**
	 * @return the gameOver
	 */
	public boolean isGameOver() {
		return gameOver;
	}
	/**
	 * @param gameOver the gameOver to set
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	/**
	 * @return the playerOut
	 */
	public boolean isPlayerOut() {
		return playerOut;
	}
	/**
	 * @param playerOut the playerOut to set
	 */
	public void setPlayerOut(boolean playerOut) {
		this.playerOut = playerOut;
	}
	/**
	 * @return the timeOut
	 */
	public boolean isTimeOut() {
		return timeOut;
	}
	/**
	 * @param timeOut the timeOut to set
	 */
	public void setTimeOut(boolean timeOut) {
		this.timeOut = timeOut;
	}
	/**
	 * @return the winnerId
	 */
	public int getWinnerId() {
		return winnerId;
	}
	/**
	 * @param winnerId the winnerId to set
	 */
	public void setWinnerId(int winnerId) {
		this.winnerId = winnerId;
	}
	/**
	 * @return the lastPlayer
	 */
	public int getLastPlayer() {
		return lastPlayer;
	}
	/**
	 * @param lastPlayer the lastPlayer to set
	 */
	public void setLastPlayer(int lastPlayer) {
		this.lastPlayer = lastPlayer;
	}
	/**
	 * @return the lastBox
	 */
	public XOBox getLastBox() {
		return lastBox;
	}
	/**
	 * @param lastBox the lastBox to set
	 */
	public void setLastBox(XOBox lastBox) {
		this.lastBox = lastBox;
	}
}
