package epam.ph.sg.models.xo;

/**
 * @author Paul Michael T.
 */
import java.util.List;

public class XOPlayer {
	private int id;
	private int status;
	private XOGame game;

	public XOPlayer(String id, int status) {
		this.status = status;
		this.id = Integer.parseInt(id);
	}

	/**
	 * Change the status of box if it empty
	 * 
	 * @param x
	 *            - X coordinate of this box
	 * @param y
	 *            - Y coordinate of this box
	 * 
	 * @return XO.NOT_YOUR_TURN, XO.NOT_EMPTY, XO.WIN or status of changed box
	 */
	public int put(int x, int y) {
		if (id == game.getStatus()) {
			return XO.NOT_YOUR_TURN;
		} else if (game.getStatus() == XO.WITHOUT_CLIENT) {
			return XO.WITHOUT_CLIENT;
		} else {
			XOBox box = game.getXoFields().getBox(x, y);
			int result = box.setStatus(status);
			if (result == XO.NOT_EMPTY) {
				return XO.NOT_EMPTY;
			} else {
				result = game.getAi().checkout(box);
				if (result == XO.WIN) {
					game.setStatus(XO.WIN);
					game.setLastBox(box);
					return XO.WIN;
				} else {
					game.setStatus(id);
					game.setLastBox(box);
					return result;
				}
			}
		}
	}

	/**
	 * Status of the game checker
	 * 
	 * @return Game Status
	 */
	public int check() {
		if (id == game.getStatus()) {
			return XO.NO_CHANGES;
		} else
			return game.getStatus();
	}

	/**
	 * Fields getter
	 * 
	 * @return List<List<XOBox>>
	 */
	public List<List<XOBox>> getFields() {
		return game.getXoFields().getBoxList();
	}

	public int getId() {
		return id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public XOGame getGame() {
		return game;
	}

	public void setGame(XOGame game) {
		this.game = game;
	}
}
