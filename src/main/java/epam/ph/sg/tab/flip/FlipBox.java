package epam.ph.sg.tab.flip;

public class FlipBox {
	private int value;

	public FlipBox(int value) {
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
