package epam.ph.sg.tab.sudoku;

/**
 * @author Talash Pavlo
 */
import java.util.List;
import java.util.Set;

public class SudokuGame {
	public static final int EASY = 1;
	public static final int NORMAL = 2;
	public static final int HARD = 3;
	
	private int[][] staticValues;
	private SudokuField sudokuField = new SudokuField();
	private SudokuAI sudokuAI = new SudokuAI(sudokuField);
	private int level;

	public SudokuGame(int level, int[][] values) {
		this.level = level;
		this.staticValues = values;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int value = values[i][j];
				SudokuBox box = this.getSudokuField().getBox(i, j);
				if (value != 0) {
					box.setValue(value);
					box.setLocked(true);
				}
			}
		}
	}

	/**
	 * Put the number in to the box
	 * 
	 * @param line
	 *            - box line
	 * @param column
	 *            - box column
	 * @param value
	 *            - number value
	 * @return false if box locked. If box isn't locked return true
	 */
	public boolean tryToPut(int line, int column, int value) {
		SudokuBox box = sudokuField.getBox(line, column);
		if (!box.isLocked()) {
			box.setValue(value);
			return true;
		} else {
			return false;
		}
	}

	public int[][] getStaticValues() {
		return staticValues;
	}

	public Set<SudokuBox> getFailed() {
		return sudokuAI.check();
	}

	public List<List<SudokuBox>> getField() {
		return sudokuField.getField();
	}

	public SudokuField getSudokuField() {
		return sudokuField;
	}

	public int getLevel() {
		return level;
	}

	public static SudokuGame getGame(int level) {
		if (level < 1) {
			level = 1;
		} else if (level > 3) {
			level = 3;
		}
		return new SudokuGame(level, SudokuMapCreator.prepare(level));
	}
}
