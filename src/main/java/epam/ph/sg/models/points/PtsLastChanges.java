package epam.ph.sg.models.points;

public class PtsLastChanges {

	private String type;
	private String userType;
	private String gameId;
	private String coords;

	public PtsLastChanges() {
		type = "lastChanges";
		userType = "none";
		gameId = "none";
		coords = "none";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getCoords() {
		return coords;
	}

	public void setCoords(String coords) {
		this.coords = coords;
	}

}
