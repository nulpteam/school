/**
 * 
 */
package epam.ph.sg.tab.twopenguins;

/**
 * @author roman
 *
 */
public class TwoPenguinsGame {
	
	public TwoPenguinsGame(int[][] array ){
		this.setGameField(array);
	}
	
	private int[][] gameField = new int [3][4];

	public int[][] getGameField() {
		return gameField;
	}

	public void setGameField(int[][] gameField) {
		this.gameField = gameField;
	}
	
}
