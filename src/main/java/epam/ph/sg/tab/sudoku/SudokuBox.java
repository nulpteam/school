package epam.ph.sg.tab.sudoku;

/**
 * @author Paul Michael T.
 */
public class SudokuBox {
	private int line;
	private int colum;

	private int value = 0;
	private int boxArea;
	private boolean locked = false;

	public SudokuBox(int line, int colum) {
		this.line = line;
		this.colum = colum;
		this.boxArea = getArea(line, colum);
	}

	private int getArea(int line, int colum) {
		if (line < 3) {
			if (colum < 3)
				return 0;
			else if (colum < 6)
				return 1;
			else
				return 2;
		} else if (line < 6) {
			if (colum < 3)
				return 3;
			else if (colum < 6)
				return 4;
			else
				return 5;
		} else {
			if (colum < 3)
				return 6;
			else if (colum < 6)
				return 7;
			else
				return 8;
		}
	}

	public int getLine() {
		return line;
	}

	public int getColum() {
		return colum;
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

	// @Override
	// public int compareTo(SudokuBox o) {
	// String id1 = "" + this.getLine() + this.getColum();
	// String id2 = "" + o.getLine() + o.getColum();
	// if (id1.equals(id2))
	// return 0;
	// else
	// return 1;
	// }
}
