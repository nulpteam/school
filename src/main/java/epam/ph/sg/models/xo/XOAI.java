package epam.ph.sg.models.xo;

/**
 * @author Paul Michael T.
 */
public class XOAI {
	private XOFields fields;

	public XOAI(XOFields fields) {
		this.fields = fields;
	}

	/**
	 * Game over checking
	 * 
	 * @param box
	 *            - last box
	 * @return XO.WIN - if game over, or box status
	 */
	public int checkout(XOBox box) {
		if (check1(box) >= XO.TO_WIN) {
			return XO.GAME_OVER;
		} else if (check2(box) >= XO.TO_WIN) {
			return XO.GAME_OVER;
		} else if (check3(box) >= XO.TO_WIN) {
			return XO.GAME_OVER;
		} else if (check4(box) >= XO.TO_WIN) {
			return XO.GAME_OVER;
		} else
			return box.getStatus();
	}

	// Vertical check
	private int check1(XOBox box) {
		int x = box.getX();
		int y = box.getY();
		int i = 1;
		int j = 1;
		try {
			while (box.getStatus() == fields.getBox(x + i, y).getStatus()) {
				i++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			while (box.getStatus() == fields.getBox(x - j, y).getStatus()) {
				j++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		return i + j - 1;
	}

	// Horizontal check
	private int check2(XOBox box) {
		int x = box.getX();
		int y = box.getY();
		int i = 1;
		int j = 1;
		try {
			while (box.getStatus() == fields.getBox(x, y + i).getStatus()) {
				i++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			while (box.getStatus() == fields.getBox(x, y - j).getStatus()) {
				j++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		return i + j - 1;
	}

	// Diagonal check \
	private int check3(XOBox box) {
		int x = box.getX();
		int y = box.getY();
		int i = 1;
		int j = 1;
		try {
			while (box.getStatus() == fields.getBox(x + i, y + i).getStatus()) {
				i++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			while (box.getStatus() == fields.getBox(x - j, y - j).getStatus()) {
				j++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		return i + j - 1;
	}

	// Diagonal check /
	private int check4(XOBox box) {
		int x = box.getX();
		int y = box.getY();
		int i = 1;
		int j = 1;
		try {
			while (box.getStatus() == fields.getBox(x + i, y - i).getStatus()) {
				i++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			while (box.getStatus() == fields.getBox(x - j, y + j).getStatus()) {
				j++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		return i + j - 1;
	}
}
