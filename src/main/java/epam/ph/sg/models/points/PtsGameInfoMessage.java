package epam.ph.sg.models.points;

import java.util.ArrayList;
import java.util.List;

public class PtsGameInfoMessage {

	private String type;
	private String clientName;
	private String serverName;
	private boolean serverLock;
	private boolean clientLock;
	private String userType;
	private int serverScore;
	private int clientScore;
	private boolean activeMainMenu;
	private boolean activePointsMenu;
	private String userTypeActiveMenu;

	
	public String getUserTypeActiveMenu() {
		return userTypeActiveMenu;
	}

	public void setUserTypeActiveMenu(String userTypeActiveMenu) {
		this.userTypeActiveMenu = userTypeActiveMenu;
	}

	private List<List<Integer>> lastContours;
	private List<List<Integer>> matrix;
	private List<List<Integer>> contoursServer;
	private List<List<Integer>> contoursClient;

	PtsGameInfoMessage() {

		lastContours = new ArrayList<List<Integer>>();
		contoursClient = new ArrayList<List<Integer>>();
		contoursServer = new ArrayList<List<Integer>>();
		
		initMatrix();

		type = PtsResources.getProperty("user.message.type.initialize");
		clientName = "none";
		serverName = "none";
		serverLock = true;
		clientLock = true;
		serverScore = 0;
		clientScore = 0;
		activeMainMenu = false;
		activePointsMenu = false;
	}

	public boolean isActiveMainMenu() {
		return activeMainMenu;
	}

	public void setActiveMainMenu(boolean activeMainMenu) {
		this.activeMainMenu = activeMainMenu;
	}

	public boolean isActivePointsMenu() {
		return activePointsMenu;
	}

	public void setActivePointsMenu(boolean activePointsMenu) {
		this.activePointsMenu = activePointsMenu;
	}

	public void initializeBoard(int[][] board) {
		
		serverScore = 0;
		clientScore = 0;
		initMatrix();
		for (int i = 0; i < Pts.Y_LENGTH; i++) {
			for (int j = 0; j < Pts.X_LENGTH; j++) {
				matrix.get(i).add(board[i][j]);
				if (board[i][j] == 20) {
					serverScore++;
				} else if (board[i][j] == 10)
					clientScore++;
			}
		}
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

	public void initMatrix() {
		matrix = new ArrayList<List<Integer>>();
		for (int i = 0; i < Pts.Y_LENGTH; i++) {
			matrix.add(new ArrayList<Integer>(Pts.X_LENGTH));
		}
	}

	public void initLastContours(List<List<PtsCoord>> lastContours) {
		
		List<Integer> coords;
		for (int i = 0; i < lastContours.size(); i++) {
			coords = new ArrayList<Integer>();
			for (int j = 0; j < lastContours.get(i).size(); j++) {
				PtsCoord coord = lastContours.get(i).get(j);
				coords.add(coord.getY());
				coords.add(coord.getX());
			}
			this.lastContours.add(coords);
		}
	}
	
	public void initServerContours(List<List<PtsCoord>> contours) {
		
		initContours(contours, contoursServer);
	}
	
	public List<List<Integer>> getContoursServer() {
		return contoursServer;
	}

	public void setContoursServer(List<List<Integer>> contoursServer) {
		this.contoursServer = contoursServer;
	}

	public List<List<Integer>> getContoursClient() {
		return contoursClient;
	}

	public void setContoursClient(List<List<Integer>> contoursClient) {
		this.contoursClient = contoursClient;
	}

	public void initClientContours(List<List<PtsCoord>> contours) {
		
		initContours(contours, contoursClient);
	}
	
	private void initContours(List<List<PtsCoord>> contours, List<List<Integer>> userContours) {
		
		List<Integer> coords;
		for (int i = 0; i < contours.size(); i++) {
			coords = new ArrayList<Integer>();
			for (int j = 0; j < contours.get(i).size(); j++) {
				PtsCoord coord = contours.get(i).get(j);
				coords.add(coord.getY());
				coords.add(coord.getX());
			}
			userContours.add(coords);
		}
	}

	public List<List<Integer>> getLastContours() {
		return lastContours;
	}

	public void setLastContours(List<List<Integer>> lastContours) {
		this.lastContours = lastContours;
	}

	public List<List<Integer>> getMatrix() {
		return matrix;
	}

	public void setMatrix(List<List<Integer>> matrix) {
		this.matrix = matrix;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public boolean isServerLock() {
		return serverLock;
	}

	public void setServerLock(boolean serverLock) {
		this.serverLock = serverLock;
	}

	public boolean isClientLock() {
		return clientLock;
	}

	public void setClientLock(boolean clientLock) {
		this.clientLock = clientLock;
	}
	
}