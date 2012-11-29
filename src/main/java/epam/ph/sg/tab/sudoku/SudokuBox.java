package epam.ph.sg.tab.sudoku;

/**
 * @author Talash Pavlo
 */
public class SudokuBox {
	private int line;
	private int column;

	private int value = 0;
	private int boxArea;
	private boolean locked = false;

	public SudokuBox(int line, int column) {
		this.line = line;
		this.column = column;
		this.boxArea = getArea(line, column);
	}

	/**
	 * Calculate the area from line and column
	 * 
	 * @param line
	 *            - box line
	 * @param column
	 *            - box column
	 * @return box area
	 */
	private static int getArea(int line, int column) {
		if (line < 3) {
			if (column < 3)
				return 0;
			else if (column < 6)
				return 1;
			else
				return 2;
		} else if (line < 6) {
			if (column < 3)
				return 3;
			else if (column < 6)
				return 4;
			else
				return 5;
		} else {
			if (column < 3)
				return 6;
			else if (column < 6)
				return 7;
			else
				return 8;
		}
	}

	public int getLine() {
		return line;
	}

	public int getColum() {
		return column;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getBoxArea() {
		return boxArea;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@Override
	public boolean equals(Object obj) {
		SudokuBox box = (SudokuBox) obj;
		String id1 = "" + this.getLine() + this.getColum();
		String id2 = "" + box.getLine() + box.getColum();
		if (id1.equals(id2))
			return true;
		else
			return false;
	}
}
