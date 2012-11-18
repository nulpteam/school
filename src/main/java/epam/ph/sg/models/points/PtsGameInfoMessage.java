package epam.ph.sg.models.points;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PtsGameInfoMessage {

	private String type;
	private String clientName;
	private String serverName;
	private boolean serverLock;
	private boolean clientLock;
	private String userType;
	
	private List<List<Integer>> lastContours;




	public List<List<Integer>> matrix;

	PtsGameInfoMessage() {

		lastContours = new ArrayList<List<Integer>>();
		matrix = new ArrayList<List<Integer>>();
		for (int i = 0; i < Pts.Y_LENGTH; i++) {
			matrix.add(new ArrayList<Integer>(Pts.X_LENGTH));
		}
		

		type = PtsResources.getProperty("user.message.type.initialize");
		clientName = "none";
		serverName = "none";
		serverLock = true;
		clientLock = true;
	}

	public void initializeBoard(int[][] board) {
		for (int i = 0; i < Pts.Y_LENGTH; i++) {
			for (int j = 0; j < Pts.X_LENGTH; j++) {
				matrix.get(i).add(board[i][j]);
			}
		}
	}
	

	public void initLastContours(List<List<PtsCoord>> lastCounturs) {
		
		List<Integer> coords;
		for (int i = 0; i < lastCounturs.size(); i++) {
			coords = new ArrayList<Integer>();
			for (int j = 0; j < lastCounturs.get(i).size(); j++) {
				PtsCoord coord = lastCounturs.get(i).get(j);
				coords.add(coord.getY());
				coords.add(coord.getX());
			}
			this.lastContours.add(coords);
		}
	}

	public List<List<Integer>> getLastCounturs() {
		return lastContours;
	}

	public void setLastCounturs(List<List<Integer>> lastCounturs) {
		this.lastContours = lastCounturs;
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