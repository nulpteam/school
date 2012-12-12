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
		
		field[0][0] = 2;
		field[0][1] = 6;
		field[0][2] = 5;
		field[1][0] = 5;
		field[1][1] = 6;
		field[1][2] = 4;
		field[2][0] = 4;
		field[2][1] = 2;
		field[2][2] = 7;
		field[0][3] = 3;
		field[1][3] = 7;
		field[2][3] = 3;
		
		return field;
	}	
}
