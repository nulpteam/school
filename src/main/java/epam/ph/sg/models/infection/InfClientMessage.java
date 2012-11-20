/**
 * 
 */
package epam.ph.sg.models.infection;

/**
 * @author roman
 *
 */

public class InfClientMessage {

	private String type;
	private String userType;
	private String gameId;
	private String clientName;
	private String serverName;
	private String moveType;
	private int serverScore;
	private int xcoord;
	private int ycoord;
	private int clientScore;
	private boolean lock;
	
	public InfClientMessage() {
		type = "";
		userType = "";
		gameId = "";
		clientName = "";
		setServerScore(0);
		setClientScore(0);
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

	public int getServerScore() {
		return serverScore;
	}

	public void setServerScore(int serverScore) {
		this.serverScore = serverScore;
	}

	public int getClientScore() {
		return clientScore;
	}

	public void setClientScore(int clientScore) {
		this.clientScore = clientScore;
	}

	public int getXcoord() {
		return xcoord;
	}

	public void setXcoord(int xcoord) {
		this.xcoord = xcoord;
	}

	public int getYcoord() {
		return ycoord;
	}

	public void setYcoord(int ycoord) {
		this.ycoord = ycoord;
	}

	public String getMoveType() {
		return moveType;
	}

	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}


}

