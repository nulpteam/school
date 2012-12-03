package epam.ph.sg.games.xo;

/**
 * @author Talash Pavlo
 */
public class XOBox {
	public static final int EMPTY = 0;
	public static final int X = -1;
	public static final int O = -2;

	private int status = EMPTY;
	private int x;
	private int y;

	public XOBox(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Status getter
	 * 
	 * @return XOBox constant EMPTY, X or O
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Status setter
	 * 
	 * @param status
	 *            - XOBox constant EMPTY, X or O
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * X coordinate getter
	 * 
	 * @return X coordinate of this box
	 */
	public int getX() {
		return x;
	}

	/**
	 * Y coordinate getter
	 * 
	 * @return Y coordinate of this box
	 */
	public int getY() {
		return y;
	}
}
