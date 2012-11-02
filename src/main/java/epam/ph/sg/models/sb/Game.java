package epam.ph.sg.models.sb;

public class Game {

	private Server server;
	private Client client;
	private int id;

	public Game(int id) {
		this.id=id;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getId() {
		return id;
	}
	public String toString()
	{
		return server+"\n"+client;
	}
}
