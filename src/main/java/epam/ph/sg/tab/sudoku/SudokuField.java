package epam.ph.sg.tab.sudoku;

/**
 * @author Talash Pavlo
 */
import java.util.ArrayList;
import java.util.List;

public class SudokuField {
	private List<List<SudokuBox>> field;
	private List<List<SudokuBox>> areas;

	public SudokuField() {
		field = new ArrayList<List<SudokuBox>>();
		ArrayList<SudokuBox> line;
		for (int i = 0; i < 9; i++) {
			line = new ArrayList<SudokuBox>();
			for (int j = 0; j < 9; j++) {
				line.add(new SudokuBox(i, j));
			}
			field.add(line);
		}
		createAreas();
	}

	/**
	 * Create List of box areas
	 */
	private void createAreas() {
		areas = new ArrayList<List<SudokuBox>>();
		for (int i = 0; i < 9; i++) {
			areas.add(new ArrayList<SudokuBox>());
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				SudokuBox box = getBox(i, j);
				areas.get(box.getBoxArea()).add(box);
			}
		}
	}

	public SudokuBox getBox(int line, int column) {
		return field.get(line).get(column);
	}

	public SudokuBox getBoxByArea(int areaNumber, int boxNumber) {
		return areas.get(areaNumber).get(boxNumber);
	}

	public List<List<SudokuBox>> getField() {
		return field;
	}
}
