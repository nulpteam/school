package epam.ph.sg.models.points;

public class PtsLastChanges {

	private String userThatChanged;
	private String coordsOfChanges;


	public PtsLastChanges() {
		coordsOfChanges = "none";
		userThatChanged = "none";
	}

	public String getUserThatChanged() {
		return userThatChanged;
	}

	public void setUserThatChanged(String userThatChanged) {
		this.userThatChanged = userThatChanged;
	}

	public String getCoordsOfChanges() {
		return coordsOfChanges;
	}

	public void setCoordsOfChanges(String coordsOfChnages) {
		this.coordsOfChanges = coordsOfChnages;
	}




}
