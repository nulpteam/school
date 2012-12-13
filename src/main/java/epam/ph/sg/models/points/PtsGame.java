package epam.ph.sg.models.points;

/**
 * @author Kostya Skromnuy
 * 
 */

public class PtsGame {

	private PtsPlayer server, client;
	private PtsBoard board, logicBoard;
	private static int gameNumber = 0;
	private int id;
	private boolean surrenderMainMenuActive;
	private boolean surrenderPointsMenuActive;
	private String userTypeActiveMenu;
	private boolean setTimer;
	private String timerState;
	private PtsTimer timer;
	private boolean activeTimer;

	public PtsGame() {
		board = new PtsBoard();
		logicBoard = new PtsBoard();
		id = gameNumber++;
		server = new PtsPlayer();
		client = new PtsPlayer();
		surrenderMainMenuActive = false;
		surrenderPointsMenuActive = false;
		setTimer = true;
		timer = new PtsTimer();
		timerState = "60";
		activeTimer = false;
	}

	public void startTimer() {
		activeTimer = true;
		timer.startTimer(this);
	}

	public void stopTimer() {
		activeTimer = false;
		this.timerState = "60";
		timer.stopTimer();
	}

	public void stopRefreshTimer() {
		activeTimer = false;
		timer.stopTimer();
	}

	public boolean setServer(PtsPlayer server) {
		if (server == null)
			return false;
		this.server = server;
		server.setLock(false);
		return true;
	}

	public PtsPlayer getServer() {
		return server;
	}

	public boolean setClient(PtsPlayer client) {
		if (client == null)
			return false;
		this.client = client;
		client.setLock(true);
		return true;
	}

	public PtsPlayer getClient() {
		return client;
	}

	public boolean isActiveTimer(String userType) {
		if (activeTimer) {
			if (userType.equals(PtsResources.getProperty("user.type.server")))
				return !server.isLock();
			else {
				return !client.isLock();
			}
		} else
			return false;
	}

	public String getTimerState() {
		return timerState;
	}

	public void setTimerState(String timerState) {
		this.timerState = timerState;
		if (timerState.equals("0"))
			this.stopTimer();
		timerState = "60";
	}

	public int getId() {
		return id;
	}

	public int[][] getGameTable() {
		return board.getBoard();
	}

	public PtsBoard getBoard() {
		return board;
	}

	public void setBoard(PtsBoard board) {
		this.board = board;
	}

	public PtsBoard getLogicBoard() {
		return logicBoard;
	}

	public void setLogicBoard(PtsBoard logicBoard) {
		this.logicBoard = logicBoard;
	}

	public static int getGameNumber() {
		return gameNumber;
	}

	public static void setGameNumber(int gameNumber) {
		PtsGame.gameNumber = gameNumber;
	}

	public boolean isSetTimer() {
		return setTimer;
	}

	public void setSetTimer(boolean setTimer) {
		this.setTimer = setTimer;
	}

	public boolean isSurrenderMainMenuActive() {
		return surrenderMainMenuActive;
	}

	public void setSurrenderMainMenuActive(boolean surrenderMainMenuActive) {
		this.surrenderMainMenuActive = surrenderMainMenuActive;
	}

	public boolean isSurrenderPointsMenuActive() {
		return surrenderPointsMenuActive;
	}

	public void setSurrenderPointsMenuActive(boolean surrenderPointsMenuActive) {
		this.surrenderPointsMenuActive = surrenderPointsMenuActive;
	}

	public String getUserTypeActiveMenu() {
		return userTypeActiveMenu;
	}

	public void setUserTypeActiveMenu(String userTypeActiveMenu) {
		this.userTypeActiveMenu = userTypeActiveMenu;
	}

	public void setId(int id) {
		this.id = id;
	}

}
