package epam.ph.sg.tab.flipper;

/**
 * @author Talash Pavlo
 */
import java.util.List;

public class FlipperGame {
	private int level;
	private List<List<FlipperBox>> field;
	private FlipperStatus status = new FlipperStatus();

	public FlipperGame(int level) {
		this.level = level;
		this.field = FlipperMapCreator.prepare(level);
	}

	/**
	 * Flip boxes
	 * 
	 * @param line
	 *            - box line
	 * @param column
	 *            - box column
	 */
	public void flip(int line, int column) {
		field.get(line).get(column).change();
		try {
			field.get(line + 1).get(column).change();
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			field.get(line).get(column + 1).change();
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			field.get(line).get(column - 1).change();
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			field.get(line - 1).get(column).change();
		} catch (IndexOutOfBoundsException e) {
		}
		if (isNextLevel() == true) {
			status.setNextLevel(true);
		}
	}

	/**
	 * Check is this level finished
	 * 
	 * @return true or false
	 */
	private boolean isNextLevel() {
		for (List<FlipperBox> line : field) {
			for (FlipperBox flipBox : line) {
				if (flipBox.getValue() == 1) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Switch game to the next level
	 */
	public void nextLevel() {
		level++;
		if (level < 13) {
			field = FlipperMapCreator.prepare(level);
			status.setNextLevel(false);
		} else {
			status.setGameOver(true);
		}
	}

	/**
	 * Reset this level to start
	 */
	public void resetLevel() {
		field = FlipperMapCreator.prepare(level);
	}

	public int getLevel() {
		return level;
	}

	public List<List<FlipperBox>> getField() {
		return field;
	}

	public FlipperStatus getStatus() {
		return status;
	}
}
