package epam.ph.sg.sudoku;

import java.util.List;
import java.util.Set;

public class SudokuGame {
	private SudokuField sudokuField = new SudokuField();
	private SudokuAI sudokuAI = new SudokuAI(sudokuField);
	
	public boolean put(int line, int colum, int value){
		SudokuBox box = sudokuField.getBox(line, colum);
		if (!box.isLocked()){
			box.setValue(value);
			return true;
		} else {
			return false;
		}
	}
	
	public Set<SudokuBox> getFailed(){
		return sudokuAI.check();
	}
	
	public List<List<SudokuBox>> getField() {
		return sudokuField.getField();
	}
}
