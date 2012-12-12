/**
 * 
 */
package epam.ph.sg.tab.twopenguins;

import java.util.Random;

/**
 * @author roman
 * 
 */
public class TwoPenguinsFieldCreator {
	public static int[][] generateField() {

		int[][] field = new int[3][4];

		field[0][0] = 0;
		field[0][1] = 0;
		field[0][2] = 0;
		field[1][0] = 0;
		field[1][1] = 0;
		field[1][2] = 0;
		field[2][0] = 0;
		field[2][1] = 0;
		field[2][2] = 0;
		field[0][3] = 0;
		field[1][3] = 0;
		field[2][3] = 0;

		Random generator = new Random();

		int a = 0;
		int b = 0;
		// 2

		for (int i = 2; i < 8; i++) {
			for (int j = 0; j < 2; j++) {
				while (field[a][b] != 0) {
					a = generator.nextInt(3);
					b = generator.nextInt(4);
				}
				field[a][b] = i;
			}
		}

		return field;
	}
}
