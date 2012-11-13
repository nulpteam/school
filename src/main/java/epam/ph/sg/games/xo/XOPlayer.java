package epam.ph.sg.games.xo;

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
	public boolean tryToPut(int x, int y) {
		if (game.getStatus().getLastPlayer() == id) {
			return false;
		} else if (game.getXoFields().getBox(x, y).getStatus() != XOBox.EMPTY) {
			return false;
		} else if (game.getStatus().isGameOver()) {
			return false;
		} else if (game.getStatus().isPlayerOut()) {
			return false;
		} else {
			put(x, y);
			return true;
		}
	}

	private void put(int x, int y) {
		XOBox box = game.getXoFields().getBox(x, y);
		box.setStatus(status);
		game.getStatus().setLastBox(box);
		if (game.getAi().isGameOver(box) == true) {
			game.gameOver(id);
		}
		game.getStatus().setLastPlayer(id);
		game.timerStart(id);
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
