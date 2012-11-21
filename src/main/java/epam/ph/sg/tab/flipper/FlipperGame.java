package epam.ph.sg.tab.flipper;

/**
 * @author Paul Michael T.
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

	public void flip(int line, int colum) {
		field.get(line).get(colum).change();
		try {
			field.get(line + 1).get(colum).change();
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			field.get(line).get(colum + 1).change();
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			field.get(line).get(colum - 1).change();
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			field.get(line - 1).get(colum).change();
		} catch (IndexOutOfBoundsException e) {
		}
		if (isNextLevel() == true) {
			status.setNextLevel(true);
		}
	}

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

	public void nextLevel() {
		level++;
		if (level < 13) {
			field = FlipperMapCreator.prepare(level);
			status.setNextLevel(false);
		} else {
			status.setGameOver(true);
		}
	}

	public void resetLevel() {
		field = FlipperMapCreator.prepare(level);
	}
	
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @return the field
	 */
	public List<List<FlipperBox>> getField() {
		return field;
	}

	/**
	 * @return the status
	 */
	public FlipperStatus getStatus() {
		return status;
	}
}
