package epam.ph.sg.models.xo;

/**
 * @author Paul Michael T.
 */
import java.util.ArrayList;
import java.util.List;

public class XOFields {
	private XOBox[][] boxes;

	public XOFields() {
		boxes = new XOBox[XO.X_SIZE][XO.X_SIZE];
		for (int x = 0; x < XO.X_SIZE; x++) {
			for (int y = 0; y < XO.Y_SIZE; y++) {
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
		for (int y = 0; y < XO.Y_SIZE; y++) {
			line = new ArrayList<XOBox>();
			for (int x = 0; x < XO.X_SIZE; x++) {
				line.add(getBox(x, y));
			}
			fields.add(line);
		}
		return fields;
	}
}
