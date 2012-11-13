package epam.ph.sg.games.xo;

/**
 * @author Paul Michael T.
 */
import java.util.ArrayList;
import java.util.List;

public class XOFields {
	public static final int X_SIZE = 20;
	public static final int Y_SIZE = 20;

	private XOBox[][] boxes;

	public XOFields() {
		boxes = new XOBox[X_SIZE][Y_SIZE];
		for (int x = 0; x < X_SIZE; x++) {
			for (int y = 0; y < Y_SIZE; y++) {
				boxes[x][y] = new XOBox(x, y);
			}
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
		return boxes[x][y];
	}

	/**
	 * List of box getter
	 * 
	 * @return List of Lists of XOBox
	 */
	public List<List<XOBox>> getAllBox() {
		List<List<XOBox>> fields = new ArrayList<List<XOBox>>();
		ArrayList<XOBox> line;
		for (int y = 0; y < Y_SIZE; y++) {
			line = new ArrayList<XOBox>();
			for (int x = 0; x < X_SIZE; x++) {
				line.add(getBox(x, y));
			}
			fields.add(line);
		}
		return fields;
	}
}
