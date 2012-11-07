package epam.ph.sg.models.points;

public class PtsClientMessage {

	private String type;
	private String userType;
	private String gameId;
	private String coords;
	private String clientName;
	private String serverName;
	private boolean lock;

	public PtsClientMessage() {
		type = "";
		userType = "";
		gameId = "";
		coords = "";
		clientName = "";
		serverName = "";
		lock = false;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
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
	
	public boolean getLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}
}
