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
	private int clientScore;
	private int xcoord;
	private int ycoord;
	private int fmXcoord;
	private int fmYcoord;
	private int nullcoord;
	private boolean lock;
	private int[][] board;
	private boolean clientLock;
	private boolean serverlock;
	
		
	public InfClientMessage() {
		type = "";
		userType = "";
		gameId = "";
		clientName = "";
		setServerScore(2);
		setClientScore(2);
		serverName = "";
		setLock(false);
		
	
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

	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public int getFmXcoord() {
		return fmXcoord;
	}

	public void setFmXcoord(int fmXcoord) {
		this.fmXcoord = fmXcoord;
	}

	public int getFmYcoord() {
		return fmYcoord;
	}

	public void setFmYcoord(int fmYcoord) {
		this.fmYcoord = fmYcoord;
	}

	public int getNullcoord() {
		return nullcoord;
	}

	public void setNullcoord(int nullcoord) {
		this.nullcoord = nullcoord;
	}

	public boolean isClientLock() {
		return clientLock;
	}

	public void setClientLock(boolean clientLock) {
		this.clientLock = clientLock;
	}

	public boolean isServerlock() {
		return serverlock;
	}

	public void setServerlock(boolean serverlock) {
		this.serverlock = serverlock;
	}


	


}

