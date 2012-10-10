package epam.ph.sg.models.xo;

/**
 * @author Paul Michael T.
 */
public class XOGame {
	private XOFields xoFields = new XOFields();
	private int status = XO.WITHOUT_CLIENT;
	private XOBox lastBox = null;
	private XOAI ai = new XOAI(xoFields);

	/**
	 * AI getter
	 * 
	 * @return AI of this game
	 */
	public XOAI getAi() {
		return ai;
	}

	public XOFields getXoFields() {
		return xoFields;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public XOBox getLastBox() {
		return lastBox;
	}

	public void setLastBox(XOBox lastBox) {
		this.lastBox = lastBox;
	}
}
