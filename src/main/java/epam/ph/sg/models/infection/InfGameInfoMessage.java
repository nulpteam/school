package epam.ph.sg.models.infection;

import java.util.ArrayList;
import java.util.List;

import epam.ph.sg.models.points.PtsResources;

public class InfGameInfoMessage {

	private String type;
	private String clientName;
	private String serverName;
	private boolean serverLock;
	private boolean clientLock;
	private String userType;

	private List<Integer> b0 = new ArrayList<Integer>(7);
	private List<Integer> b1 = new ArrayList<Integer>(7);
	private List<Integer> b2 = new ArrayList<Integer>(7);
	private List<Integer> b3 = new ArrayList<Integer>(7);
	private List<Integer> b4 = new ArrayList<Integer>(7);
	private List<Integer> b5 = new ArrayList<Integer>(7);
	private List<Integer> b6 = new ArrayList<Integer>(7);

	public List<List<Integer>> matrix;

	InfGameInfoMessage() {

		matrix = new ArrayList<List<Integer>>();
		matrix.add(b0);
		matrix.add(b1);
		matrix.add(b2);
		matrix.add(b3);
		matrix.add(b4);
		matrix.add(b5);
		matrix.add(b6);

		type = "initialize";
		clientName = "none";
		serverName = "none";
		serverLock = true;
		clientLock = true;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
