package epam.ph.sg.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class PuzzleUtils {

	private static ObjectMapper mapper = new ObjectMapper();
	private static Logger logger = Logger.getLogger(PuzzleUtils.class);

	public static List<Integer> getBoard() {

		List<Integer> board = new ArrayList<Integer>();

		for (int i = 0; i < 16; i++) {
			board.add(getRandomUniqueNumber(board));
			System.out.println(board.get(i));
		}

		return board;

	}

	private static int getRandomUniqueNumber(List<Integer> board) {

		Random randomGenerator = new Random();
		int number = 0;

		while (true) {

			number = randomGenerator.nextInt(16);
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

	@SuppressWarnings("unchecked")
	public static List<Integer> parseBoard(String jsonBoard) {

		List<Integer> readValue = null;
		
		try {
			readValue = mapper.readValue(jsonBoard, (List.class));
		} catch (JsonGenerationException e) {
			logger.error(e.getMessage());
		} catch (JsonMappingException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		
		return readValue;
	}
}
