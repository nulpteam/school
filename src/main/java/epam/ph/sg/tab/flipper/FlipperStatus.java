package epam.ph.sg.tab.flipper;

public class FlipperStatus {
	private boolean gameOver = false;
	private boolean nextLevel = false;
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
	 * @return the nextLevel
	 */
	public boolean isNextLevel() {
		return nextLevel;
	}
	/**
	 * @param nextLevel the nextLevel to set
	 */
	public void setNextLevel(boolean nextLevel) {
		this.nextLevel = nextLevel;
	}
}
