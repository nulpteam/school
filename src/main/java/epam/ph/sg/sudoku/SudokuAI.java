package epam.ph.sg.sudoku;

import java.util.Set;
import java.util.TreeSet;

public class SudokuAI {
	private SudokuField sudokuField;
	// private List<List<SudokuBox>> field;
	private Set<SudokuBox> failed;

	public SudokuAI(SudokuField sudokuField) {
		this.sudokuField = sudokuField;
		// this.field = sudokuField.getField();
	}

	public Set<SudokuBox> check() {
		failed = new TreeSet<SudokuBox>();
		checkHorizontal();
		checkVertical();
		checkInAreas();
		return failed;
	}

	private void checkHorizontal() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				SudokuBox box1 = sudokuField.getBox(i, j);
				if (box1.getValue() != 0) {
					for (int k = j + 1; k < 9; k++) {
						SudokuBox box2 = sudokuField.getBox(i, k);
						if (box1.getValue() == box2.getValue()) {
							failed.add(box1);
							failed.add(box2);
						}
					}
				}
			}
		}
	}

	private void checkVertical() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				SudokuBox box1 = sudokuField.getBox(j, i);
				if (box1.getValue() != 0) {
					for (int k = j + 1; k < 9; k++) {
						SudokuBox box2 = sudokuField.getBox(k, i);
						if (box1.getValue() == box2.getValue()) {
							failed.add(box1);
							failed.add(box2);
						}
					}
				}
			}
		}
	}

	private void checkInAreas() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				SudokuBox box1 = sudokuField.getBoxByArea(i, j);
				if (box1.getValue() != 0) {
					for (int k = j + 1; k < 9; k++) {
						SudokuBox box2 = sudokuField.getBoxByArea(i, k);
						if (box1.getValue() == box2.getValue()) {
							failed.add(box1);
							failed.add(box2);
						}
					}
				}
			}
		}
	}
}
