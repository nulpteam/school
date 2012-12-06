package epam.ph.sg.models.points;

public class PtsClientMessage {

	private String type;
	private String userType;
	private int gameId;
	private String coords;
	private String clientName;
	private String serverName;
	private boolean lock;
	private boolean activeMainMenu;
	private boolean activePointsMenu;
	private boolean timer;
	private int moveTime;

	public PtsClientMessage() {
		type = "";
		userType = "";
		coords = "";
		clientName = "";
		serverName = "";
		lock = false;
		activeMainMenu = false;
		activePointsMenu = false;
		timer = false;
		moveTime = 60;
	}

	public boolean isTimer() {
		return timer;
	}

	public void setTimer(boolean timer) {
		this.timer = timer;
	}

	public boolean isActiveMainMenu() {
		return activeMainMenu;
	}

	public void setActiveMainMenu(boolean activeMainMenu) {
		this.activeMainMenu = activeMainMenu;
	}

	public int getMoveTime() {
		return moveTime;
	}

	public void setMoveTime(int moveTime) {
		this.moveTime = moveTime;
	}

	public boolean isActivePointsMenu() {
		return activePointsMenu;
	}

	public void setActivePointsMenu(boolean activePointsMenu) {
		this.activePointsMenu = activePointsMenu;
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

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
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
