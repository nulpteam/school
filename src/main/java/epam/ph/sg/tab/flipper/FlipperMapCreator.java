package epam.ph.sg.tab.flipper;

/**
 * @author Talash Pavlo
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlipperMapCreator {

	/**
	 * Prepare level map for game
	 * 
	 * @param level
	 *            - game level
	 * @return List of List of FlipperBox
	 */
	public static List<List<FlipperBox>> prepare(int level) {
		List<String> lines = read(getFileAddress(level));
		List<List<FlipperBox>> map = new ArrayList<List<FlipperBox>>();
		for (int i = 0; i < lines.size(); i++) {
			List<FlipperBox> mapLine = new ArrayList<FlipperBox>();
			char[] valueCharArray = lines.get(i).toCharArray();
			for (int j = 0; j < valueCharArray.length; j++) {
				mapLine.add(new FlipperBox(Integer.valueOf(String
						.valueOf(valueCharArray[j]))));
			}
			map.add(mapLine);
		}
		return map;
	}

	/**
	 * Build file address (level source)
	 * 
	 * @param level
	 *            - game level
	 * @return file address
	 */
	private static String getFileAddress(int level) {
		String adr = FlipperMapCreator.class.getClassLoader()
				.getResource("/flipper/level_" + level + ".map").getFile()
				.replaceAll("%20", " ");
		return adr;
	}

	/**
	 * Read level source
	 * 
	 * @param file
	 *            - file address
	 * @return file data in Strings
	 */
	private static List<String> read(String file) {
		List<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
}
