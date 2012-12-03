package epam.ph.sg.tab.flipper;

/**
 * @author Talash Pavlo
 */
public class FlipperStatus {
	private boolean gameOver = false;
	private boolean nextLevel = false;

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public boolean isNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(boolean nextLevel) {
		this.nextLevel = nextLevel;
	}
}
