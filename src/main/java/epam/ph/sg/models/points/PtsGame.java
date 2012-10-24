package epam.ph.sg.models.points;


public class PtsGame {
	private PtsPlayer server, client;
	private PtsBoard board;
	private static int gamesNumber = 0;
	private int id;
	
	public PtsGame() {
		board = new PtsBoard();
		id = gamesNumber++;
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
	
	public int getId() {
		return id;
	}
	
	public void reduceGamesNUmber() {
		gamesNumber--;
	}
}
