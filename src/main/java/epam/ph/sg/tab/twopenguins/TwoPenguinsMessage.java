/**
 * 
 */
package epam.ph.sg.tab.twopenguins;

/**
 * @author roman
 *
 */
public class TwoPenguinsMessage {
    private int[][] field;
    public String type;

	public int[][] getField() {
		return field;
	}

//	public void setField(int[][] field) {
//		
//	}

	public void setField(int[][] generateField) {
		this.field = generateField;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
