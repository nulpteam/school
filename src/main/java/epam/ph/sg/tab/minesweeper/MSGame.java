package epam.ph.sg.tab.minesweeper;

import java.util.List;

public class MSGame {
	private List<List<MSBox>> field;
	private int lockedMines = 0;
	private boolean lose = false;
	private boolean win = false;

	public MSGame(List<List<MSBox>> field) {
		this.field = field;
	}

	public void lock(int line, int colum) {
		if (field.get(line).get(colum).isLocked()) {
			field.get(line).get(colum).setLocked(false);
			if (field.get(line).get(colum).isMine()) {
				lockedMines--;
			}
		} else {
			field.get(line).get(colum).setLocked(true);
			if (field.get(line).get(colum).isMine()) {
				lockedMines++;
				if (lockedMines > 9) {
					win = true;
				}
			}
		}
	}

	public void put(int line, int colum) {
		if (field.get(line).get(colum).isMine()) {
			lose = true;
		} else {
			open(line, colum);
		}
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

	public boolean isLose() {
		return lose;
	}

	public boolean isWin() {
		return win;
	}
}
