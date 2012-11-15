package epam.ph.sg.tab.sudoku;

/**
 * @author Paul Michael T.
 */
import java.util.HashSet;
import java.util.Set;

public class SudokuAI {
	private SudokuField sudokuField;
	private Set<SudokuBox> failed;

	public SudokuAI(SudokuField sudokuField) {
		this.sudokuField = sudokuField;
	}

	public Set<SudokuBox> check() {
		failed = new HashSet<SudokuBox>();
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
