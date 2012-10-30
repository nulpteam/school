package epam.ph.sg.models.sb;

/**
 * 
 * @author SergiyManko
 *
 */

public class BSPlayer {
	private String name;
	public BSPlayer() {
		setName("Unknown Player");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}