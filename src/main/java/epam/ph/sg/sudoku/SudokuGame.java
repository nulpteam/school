package epam.ph.sg.sudoku;

import java.util.List;
import java.util.Set;

public class SudokuGame {
	private int[][] staticValues;
	private SudokuField sudokuField = new SudokuField();
	private SudokuAI sudokuAI = new SudokuAI(sudokuField);
	
	public SudokuGame(int[][] values) {
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

	public boolean put(int line, int colum, int value) {
		SudokuBox box = sudokuField.getBox(line, colum);
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

	public static SudokuGame getGame() {
		int values[][] = { { 8, 0, 4, 0, 1, 9, 0, 0, 7 },
				{ 1, 0, 7, 0, 0, 0, 6, 2, 0 }, { 0, 0, 5, 4, 0, 6, 0, 0, 0 },
				{ 0, 0, 3, 0, 5, 0, 0, 6, 1 }, { 0, 7, 0, 1, 0, 2, 0, 9, 0 },
				{ 5, 1, 0, 0, 9, 0, 4, 0, 0 }, { 0, 0, 0, 8, 0, 3, 7, 0, 0 },
				{ 0, 4, 8, 0, 0, 0, 3, 0, 6 }, { 6, 0, 0, 5, 4, 0, 1, 0, 2 } };
		
		return new SudokuGame(values);
	}
}
