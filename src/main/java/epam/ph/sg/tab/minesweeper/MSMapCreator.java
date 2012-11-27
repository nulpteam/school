package epam.ph.sg.tab.minesweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MSMapCreator {

	public static MSGame newGame(int lines, int colums, int mines) {
		List<List<MSBox>> field = createField(lines, colums,
				generateMines(lines, colums, mines));
		generateNumbers(field);
		return new MSGame(field);
	}

	private static int[] generateMines(int lines, int colums, int mines) {
		Random random = new Random();
		int[] fieldInLine = new int[lines * colums];
		for (int i = 0; i < mines; i++) {
			boolean done = false;
			do {
				int randomInt = random.nextInt(fieldInLine.length);
				if (fieldInLine[randomInt] == 0) {
					fieldInLine[randomInt] = 1;
					done = true;
				}
			} while (!done);
		}
		return fieldInLine;
	}

	private static List<List<MSBox>> createField(int lines, int colums,
			int[] fieldInLine) {
		List<List<MSBox>> field = new ArrayList<List<MSBox>>();
		int x = 0;
		for (int i = 0; i < lines; i++) {
			ArrayList<MSBox> line = new ArrayList<MSBox>();
			for (int j = 0; j < colums; j++) {
				if (fieldInLine[x] == 1) {
					line.add(new MSBox(true));
				} else {
					line.add(new MSBox(false));
				}
				x++;
			}
			field.add(line);
		}
		return field;
	}

	private static void generateNumbers(List<List<MSBox>> field) {
		for (int i = 0; i < field.size(); i++) {
			for (int j = 0; j < field.get(i).size(); j++) {
				if (field.get(i).get(j).isMine()) {
					try {
						field.get(i).get(j + 1).incMinesAround();
					} catch (IndexOutOfBoundsException e) {
					}
					try {
						field.get(i).get(j - 1).incMinesAround();
					} catch (IndexOutOfBoundsException e) {
					}
					try {
						field.get(i + 1).get(j).incMinesAround();
					} catch (IndexOutOfBoundsException e) {
					}
					try {
						field.get(i - 1).get(j).incMinesAround();
					} catch (IndexOutOfBoundsException e) {
					}
					try {
						field.get(i + 1).get(j + 1).incMinesAround();
					} catch (IndexOutOfBoundsException e) {
					}
					try {
						field.get(i - 1).get(j + 1).incMinesAround();
					} catch (IndexOutOfBoundsException e) {
					}
					try {
						field.get(i + 1).get(j - 1).incMinesAround();
					} catch (IndexOutOfBoundsException e) {
					}
					try {
						field.get(i - 1).get(j - 1).incMinesAround();
					} catch (IndexOutOfBoundsException e) {
					}
				}
			}
		}
	}
}
