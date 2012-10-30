package epam.ph.sg.models.xo;

/**
 * @author Paul Michael T.
 */
import java.util.List;

public class XOPlayer {

	private int id; // User ID
	private int status; // Player status (XO.X or XO.O)
	private XOGame game; // Game instance

	public XOPlayer(int id, int status, XOGame game) {
		this.status = status;
		this.id = id;
		this.game = game;
	}

	/**
	 * Try to put
	 * 
	 * @param x
	 *            - X coordinate of this box
	 * @param y
	 *            - Y coordinate of this box
	 * 
	 * @return XO.NOT_YOUR_TURN, XO.WITHOUT_CLIENT, XO.OUT, XO.NOT_EMPTY,
	 *         XO.GAME_OVER or status of changed box
	 */
	public int tryToPut(int x, int y) {
		if (game.getStatus() == id) {
			return XO.NOT_YOUR_TURN;
		} else if (game.getStatus() == XO.WITHOUT_CLIENT) {
			return XO.WITHOUT_CLIENT;
		} else if (game.getStatus() == XO.OUT) {
			return XO.OUT;
		} else {
			return put(x, y);
		}
	}

	private int put(int x, int y) {
		XOBox box = game.getXoFields().getBox(x, y);
		int result = box.setStatus(status);
		if (result == XO.NOT_EMPTY) {
			return XO.NOT_EMPTY;
		} else {
			return checkAI(box);
		}
	}

	private int checkAI(XOBox box) {
		int result = game.getAi().checkout(box);
		if (result == XO.GAME_OVER) {
			game.gameOver(id);
			game.setLastBox(box);
			return XO.GAME_OVER;
		} else {
			game.setStatus(id);
			game.setLastBox(box);
			return result;
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
	 * @return List of Lists of XOBox
	 */
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
}
