package epam.ph.sg.models.xo;

/**
 * @author Paul Michael T.
 */
public class XOBox {
	private int status = XO.EMPTY;
	private int x;
	private int y;

	public XOBox(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Status getter
	 * 
	 * @return XO.EMPTY, XO.X or XO.O
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Status setter
	 * 
	 * @param status
	 *            - XO.EMPTY, XO.X or XO.O
	 */
	public int setStatus(int status) {
		if (this.status == XO.EMPTY) {
			this.status = status;
			return XO.DONE;
		} else {
			return XO.NOT_EMPTY;
		}
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
