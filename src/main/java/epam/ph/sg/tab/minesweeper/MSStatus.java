package epam.ph.sg.tab.minesweeper;

public class MSStatus {
	private boolean loose = false;
	private boolean win = false;
	private int lockedBox = 0;
	private int lockedMines = 0;

	public int getLockedBox() {
		return lockedBox;
	}

	public void incLockedBox() {
		this.lockedBox++;
	}
	
	public void decLockedBox() {
		this.lockedBox--;
	}

	public int getLockedMines() {
		return lockedMines;
	}

	public void incLockedMines() {
		this.lockedMines++;
	}

	public void decLockedMines() {
		this.lockedMines--;
	}

	public boolean isLoose() {
		return loose;
	}

	public void setLoose(boolean loose) {
		this.loose = loose;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
}
