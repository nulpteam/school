package epam.ph.sg.models.points;

public class PtsPlayer {

	private String name;
	
	public PtsPlayer(String userName) {
		name = userName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
