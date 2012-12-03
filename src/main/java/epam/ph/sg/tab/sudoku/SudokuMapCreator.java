package epam.ph.sg.tab.sudoku;

/**
 * @author Talash Pavlo
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SudokuMapCreator {
	private static Random random = new Random();
	private static List<String> easy = read(SudokuMapCreator.class
			.getClassLoader().getResource("/sudoku/Easy.map").getFile()
			.replaceAll("%20", " "));
	private static List<String> normal = read(SudokuMapCreator.class
			.getClassLoader().getResource("/sudoku/Normal.map").getFile()
			.replaceAll("%20", " "));
	private static List<String> hard = read(SudokuMapCreator.class
			.getClassLoader().getResource("/sudoku/Hard.map").getFile()
			.replaceAll("%20", " "));

	/**
	 * Read file and build List of levels
	 * 
	 * @param file
	 *            - file address
	 * @return List of levels
	 */
	private static List<String> read(String file) {
		List<String> mapList = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				mapList.add(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mapList;
	}

	/**
	 * Prepare map for game
	 * 
	 * @param level
	 *            - game level (Easy, Normal, Hard)
	 * @return game map in array
	 */
	public static int[][] prepare(int level) {
		char[] valueCharArray;
		if (level == 1) {
			valueCharArray = easy.get(random.nextInt(easy.size() - 1))
					.toCharArray();
		} else if (level == 2) {
			valueCharArray = normal.get(random.nextInt(easy.size() - 1))
					.toCharArray();
		} else if (level == 3) {
			valueCharArray = hard.get(random.nextInt(easy.size() - 1))
					.toCharArray();
		} else {
			return null;
		}

		int[][] valueIntArray = new int[9][9];
		int x = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				valueIntArray[i][j] = Integer.valueOf(String
						.valueOf(valueCharArray[x]));
				x++;
			}
		}
		return valueIntArray;
	}
}
