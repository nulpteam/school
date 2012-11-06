/**
 * @author Gutey Bogdan
 * 
 */
package epam.ph.sg.models.sb;

import java.io.IOException;

import org.apache.log4j.Logger;

public class Game {
	private static Logger log = Logger.getLogger(Game.class);
	private Server server;
	private Client client;
	private int id;

	public Game(int id) {
		this.id = id;
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

	public static String fireCheck(int gameID, String connectionType,
			String point) {
		Game game = ActiveGames.getGame(gameID);

		int x = Integer.parseInt(Character.toString(point.charAt(0)));
		int y = Integer.parseInt(Character.toString(point.charAt(1)));
		if (connectionType.equalsIgnoreCase("server")) {
			String[][] board = game.getClient().getGameBoard().BoardtoArray();
			String fp = board[x][y];

			try {
				game.getServer().getConn().sendMessage("fp= " + fp);
			} catch (IOException e) {
				e.printStackTrace();
			}

			return fp;
		}
		if (connectionType.equalsIgnoreCase("client")) {

			String[][] board = game.getServer().getGameBoard().BoardtoArray();
			String fp = board[x][y];

			try {
				game.getClient().getConn().sendMessage("fp= " + fp);
			} catch (IOException e) {
				e.printStackTrace();
			}

			return fp;
		}
		return "ERROR";
	}

	public String toString() {
		return "GameID = " + id + "\n" + server + "\n" + client;
	}
}
