package epam.ph.sg.tab.flip;

/**
 * @author Paul Michael T.
 */
import java.util.List;

public class FlipGame {
	private int level;
	private List<List<FlipBox>> field;
	private FlipStatus status = new FlipStatus();

	public FlipGame(int level) {
		this.level = level;
		this.field = FlipMapCreator.prepare(level);
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
		for (List<FlipBox> line : field) {
			for (FlipBox flipBox : line) {
				if (flipBox.getValue() == 1) {
					return false;
				}
			}
		}
		return true;
	}

	public void nextLevel() {
		level++;
		if (level < 9) {
			field = FlipMapCreator.prepare(level);
			status.setNextLevel(false);
		} else {
			status.setGameOver(true);
		}
	}

	public void resetLevel() {
		field = FlipMapCreator.prepare(level);
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
	public List<List<FlipBox>> getField() {
		return field;
	}

	/**
	 * @return the status
	 */
	public FlipStatus getStatus() {
		return status;
	}
}
