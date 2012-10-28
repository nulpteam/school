package epam.ph.sg.models.reversy;

/**
 * 
 * @author SergiyManko
 *
 */

import java.util.ArrayList;
import java.util.List;

public class ReversyBoard {
	private int boardSize = 64;
	private List<Character> board = new ArrayList<Character>(boardSize);

	public ReversyBoard() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < boardSize; i++) {
			board.add('n');
		}
		//put first 4 figures in new game
		changeBoard(3, 3, 'x');
		changeBoard(4, 4, 'x');
		changeBoard(4, 3, 'o');
		changeBoard(3, 4, 'o');
	}

	public void changeBoard(int x, int y, Character figure) {
		int index = x * 8 + y;
		board.set(index, figure);
	}

	public List<Character> getBoard() {
		return board;
	}

	public void setBoard(List<Character> board) {
		this.board = board;
	}
}