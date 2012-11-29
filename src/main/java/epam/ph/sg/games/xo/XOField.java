package epam.ph.sg.games.xo;

/**
 * @author Talash Pavlo
 */
import java.util.ArrayList;
import java.util.List;

public class XOField {
	public static final int X_SIZE = 20;
	public static final int Y_SIZE = 20;

	private List<List<XOBox>> boxes;

	public XOField() {
		boxes = new ArrayList<List<XOBox>>();
		for (int x = 0; x < X_SIZE; x++) {
			List<XOBox> line = new ArrayList<XOBox>();
			for (int y = 0; y < Y_SIZE; y++) {
				line.add(new XOBox(x, y));
			}
			boxes.add(line);
		}
	}

	/**
	 * Box getter
	 * 
	 * @param x
	 *            - X coordinate of this box
	 * @param y
	 *            - Y coordinate of this box
	 * 
	 * @return box by coordinates
	 */
	public XOBox getBox(int x, int y) {
		return boxes.get(x).get(y);
	}

	/**
	 * List of box getter
	 * 
	 * @return List of Lists of XOBox
	 */
	public List<List<XOBox>> getAllBox() {
		return boxes;
	}
}
