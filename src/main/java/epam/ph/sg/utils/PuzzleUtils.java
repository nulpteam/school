package epam.ph.sg.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PuzzleUtils {

	public static List<Integer> getBoard() {
		
		List<Integer> board = new ArrayList<Integer>();
		
		for (int i = 0; i < 15; i++) {
			board.add(getRandomUniqueNumber(board));
		}
		
		return board;
		
	}
	
	private static int getRandomUniqueNumber(List<Integer> board) {
		
		Random randomGenerator = new Random();
		int number = 0;
		
		while(true) {
			
			number = randomGenerator.nextInt(15)+1;
			if (!isNumberInBoard(number, board)) {
				return number;
			}
		}
	}
	
	private static boolean isNumberInBoard(int number, List<Integer> board) {
		
		for (int i = 0; i < board.size(); i++) {
			if (board.get(i) == number)
				return true;
		}
		
		return false;
	}
}
