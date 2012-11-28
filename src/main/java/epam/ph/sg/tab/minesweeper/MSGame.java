package epam.ph.sg.tab.minesweeper;

import java.util.List;

public class MSGame {
	private int mines;
	private List<List<MSBox>> field;
	private MSStatus status = new MSStatus();

	public MSGame(List<List<MSBox>> field, int mines) {
		this.field = field;
		this.mines = mines;
	}

	public void lock(int line, int colum) {
		if (field.get(line).get(colum).isLocked()) {
			field.get(line).get(colum).setLocked(false);
			status.decLockedBox();
			if (field.get(line).get(colum).isMine()) {
				status.decLockedMines();
			}
		} else {
			field.get(line).get(colum).setLocked(true);
			status.incLockedBox();
			if (field.get(line).get(colum).isMine()) {
				status.incLockedMines();
			}
		}
	}

	public void put(int line, int colum) {
		if (field.get(line).get(colum).isMine()) {
			field.get(line).get(colum).setVisible(true);
			status.setLoose(true);
		} else {
			open(line, colum);
			status.setWin(isGameOver());
		}
	}

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

	private void open(int line, int colum) {
		try {
			if (!field.get(line).get(colum).isVisible()) {
				field.get(line).get(colum).setVisible(true);
				if (field.get(line).get(colum).getMinesAround() == 0) {
					openAllAround(line, colum);
				}
			}
		} catch (IndexOutOfBoundsException e) {
		}
	}

	private void openAllAround(int line, int colum) {
		open(line, colum + 1);
		open(line, colum - 1);
		open(line + 1, colum + 1);
		open(line + 1, colum - 1);
		open(line - 1, colum + 1);
		open(line - 1, colum - 1);
		open(line + 1, colum);
		open(line - 1, colum);
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
