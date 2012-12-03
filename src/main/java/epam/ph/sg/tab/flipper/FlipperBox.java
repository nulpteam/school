package epam.ph.sg.tab.flipper;

/**
 * @author Talash Pavlo
 */
public class FlipperBox {
	public static final int BLACK = 1;
	public static final int WHITE = 0;
	
	private int value;

	public FlipperBox(int value) {
		this.value = value;
	}
	
	/**
	 * Flip box to black or white
	 */
	public void change() {
		if (value == 1) {
			value = 0;
		} else {
			value = 1;
		}
	}
	
	public int getValue() {
		return value;
	}
}
