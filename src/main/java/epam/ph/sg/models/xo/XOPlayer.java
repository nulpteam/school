package epam.ph.sg.models.xo;

/**
 * @author Talash Pavlo
 */
import java.util.List;

public class XOPlayer {
	private int id; // User ID
	private int oponentId;
	private int status; // Player status (XO.X or XO.O)
	private XOGame game; // Game instance

	public XOPlayer(int id, int status, XOGame game) {
		this.status = status;
		this.id = id;
		this.game = game;
	}

	/**
	 * Try to put figure on the field
	 * 
	 * @param x
	 *            - X coordinate of box
	 * @param y
	 *            - Y coordinate of box
	 * 
	 * @return true or false
	 */
	public boolean tryToPut(int x, int y) {
		if (game.getStatus().getLastPlayer() == id) {
			return false;
		} else if (game.getXoFields().getBox(x, y).getStatus() != XOBox.EMPTY) {
			return false;
		} else if (game.getStatus().isGameOver()) {
			return false;
		} else {
			put(x, y);
			return true;
		}
	}

	/**
	 * Put figure on the field
	 * 
	 * @param x
	 *            - X coordinate of box
	 * @param y
	 *            - Y coordinate of box
	 */
	private void put(int x, int y) {
		XOBox box = game.getXoFields().getBox(x, y);
		box.setStatus(status);
		game.getStatus().setLastBox(box);
		if (game.getAi().isGameOver(box) == true) {
			game.gameOver(id);
		}
		game.getStatus().setLastPlayer(id);
		game.gameTimeOut(id);
	}

	public List<List<XOBox>> getFields() {
		return game.getXoFields().getAllBox();
	}

	public int getId() {
		return id;
	}

	public int getStatus() {
		return status;
	}

	public XOGame getGame() {
		return game;
	}

	public int getOponentId() {
		return oponentId;
	}

	public void setOponentId(int oponentId) {
		this.oponentId = oponentId;
	}
}
