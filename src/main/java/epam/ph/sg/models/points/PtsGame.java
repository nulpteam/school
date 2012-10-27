package epam.ph.sg.models.points;


public class PtsGame {
	private PtsPlayer server, client;
	private PtsBoard board;
	private static int gamesNumber = 0;
	private String id;
	private String nextUserToMove;
	
	public PtsGame() {
		board = new PtsBoard();
		id = new Integer(gamesNumber++).toString();
		nextUserToMove = "server";
	}
	
	public boolean setServer(PtsPlayer server) {
		if(server == null)
			return false;
		this.server = server;
		return true;
	}
	
	public PtsPlayer getServer() {
		return server;
	}
	
	public boolean setClient(PtsPlayer client) {
		if(client == null)
			return false;
		this.client = client;
		return true;
	}
	
	public PtsPlayer getClient() {
		return client;
	}
	
	public String getId() {
		return id;
	}
	
	public void reduceGamesNUmber() {
		gamesNumber--;
	}
	
	public void putPoint(String xy, String user) {
		board.putPoint(xy, user);
		if (user.equals("server")) {
			nextUserToMove = "client";
		} else {
			nextUserToMove = "server";
		}
	}
	
	public PtsLastChanges getLasthangesInBoard(String user) {
		if (nextUserToMove.equals(user)) {
			return board.getLastChanges();
		} else {
			return new PtsLastChanges();
		}
	}
	
	
	public boolean isUserMove(String userType) {
		if (userType.equals(nextUserToMove)) {
			return true;
		}
		return false;
	}
	
}
