package epam.ph.sg.tab.flip;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Paul Michael T.
 */
public class FlipMapCreator {

	public static List<List<FlipBox>> prepare(int level) {
		List<String> lines = read(getFileAddress(level));
		List<List<FlipBox>> map = new ArrayList<List<FlipBox>>();
		for (int i = 0; i < lines.size(); i++) {
			List<FlipBox> mapLine = new ArrayList<FlipBox>();
			char[] valueCharArray = lines.get(i).toCharArray();
			for (int j = 0; j < valueCharArray.length; j++) {
				mapLine.add(new FlipBox(Integer.valueOf(String
						.valueOf(valueCharArray[j]))));
			}
			map.add(mapLine);
		}
		return map;
	}

	private static String getFileAddress(int level) {
		String adr = FlipMapCreator.class.getClassLoader()
				.getResource("/flip/level_" + level + ".map").getFile()
				.replaceAll("%20", " ");
		return adr;
	}

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
