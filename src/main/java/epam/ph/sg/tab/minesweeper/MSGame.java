package epam.ph.sg.tab.minesweeper;

/**
 * @author Talash Pavlo
 */
import java.util.List;

public class MSGame {
	private int mines;
	private List<List<MSBox>> field;
	private MSStatus status = new MSStatus();

	public MSGame(List<List<MSBox>> field, int mines) {
		this.field = field;
		this.mines = mines;
	}

	/**
	 * Put the flag on the box
	 * 
	 * @param line
	 *            - box line
	 * @param column
	 *            - box column
	 */
	public void lock(int line, int column) {
		if (field.get(line).get(column).isLocked()) {
			field.get(line).get(column).setLocked(false);
			status.decLockedBox();
			if (field.get(line).get(column).isMine()) {
				status.decLockedMines();
			}
		} else {
			field.get(line).get(column).setLocked(true);
			status.incLockedBox();
			if (field.get(line).get(column).isMine()) {
				status.incLockedMines();
			}
		}
	}

	/**
	 * Try to open box
	 * 
	 * @param line
	 *            - box line
	 * @param column
	 *            - box column
	 */
	public void tryToOpen(int line, int column) {
		if (field.get(line).get(column).isMine()) {
			field.get(line).get(column).setVisible(true);
			status.setLoose(true);
		} else {
			open(line, column);
			status.setWin(isGameOver());
		}
	}

	/**
	 * Open box and if it's empty open all around boxes
	 * 
	 * @param line
	 *            - box line
	 * @param column
	 *            - box column
	 */
	private void open(int line, int column) {
		try {
			if (!field.get(line).get(column).isVisible()) {
				field.get(line).get(column).setVisible(true);
				if (field.get(line).get(column).getMinesAround() == 0) {
					openAllAround(line, column);
				}
			}
		} catch (IndexOutOfBoundsException e) {
		}
	}

	/**
	 * Open all around boxes
	 * 
	 * @param line
	 *            - box line
	 * @param column
	 *            - box column
	 */
	private void openAllAround(int line, int column) {
		open(line, column + 1);
		open(line, column - 1);
		open(line + 1, column + 1);
		open(line + 1, column - 1);
		open(line - 1, column + 1);
		open(line - 1, column - 1);
		open(line + 1, column);
		open(line - 1, column);
	}

	/**
	 * Check is game over
	 * 
	 * @return true or false
	 */
	private boolean isGameOver() {
		int unVisible = 0;
		for (List<MSBox> line : field) {
			for (MSBox msBox : line) {
				if (!msBox.isVisible()) {
					unVisible++;
				}
				if (unVisible > mines) {
					return false;
				}
			}
		}
		return true;
	}

	public List<List<MSBox>> getField() {
		return field;
	}

	public MSStatus getStatus() {
		return status;
	}

	public void setStatus(MSStatus status) {
		this.status = status;
	}
}
