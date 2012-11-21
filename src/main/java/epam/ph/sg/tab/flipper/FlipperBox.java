package epam.ph.sg.tab.flipper;

public class FlipperBox {
	private int value;

	public FlipperBox(int value) {
		this.value = value;
	}
	
	public void change() {
		if (value == 1) {
			value = 0;
		} else {
			value = 1;
		}
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
}
