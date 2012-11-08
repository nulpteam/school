/**
 * @author Gutey Bogdan
 * 
 */
package epam.ph.sg.models.sb;

import java.io.IOException;
import java.util.Random;

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
		boolean clientNextMove = game.getClient().isNextMove();
		boolean serverNextMove = game.getServer().isNextMove();
		log.debug("clientNextMove= "+clientNextMove);
		log.debug("serverNextMove= "+serverNextMove);
		if(clientNextMove == true && serverNextMove==false)
		{
			game.getClient().setNextMove(false);
			game.getServer().setNextMove(true);
		}
		else
		{
			game.getClient().setNextMove(true);
			game.getServer().setNextMove(false);
		}
		
		int x = Integer.parseInt(Character.toString(point.charAt(0)));
		int y = Integer.parseInt(Character.toString(point.charAt(1)));
		if (connectionType.equalsIgnoreCase("server")) {
			String[][] board = game.getClient().getGameBoard().BoardtoArray();
			String fp = board[x][y];

			try {
				game.getClient().getConn().sendMessage("sheep|fail= " + fp+" point= "+point);
			} catch (IOException e) {
				e.printStackTrace();
			}

			return fp;
		}
		if (connectionType.equalsIgnoreCase("client")) {

			String[][] board = game.getServer().getGameBoard().BoardtoArray();
			String fp = board[x][y];

			try {
				game.getServer().getConn().sendMessage("sheep|fail= " + fp+" point= "+point);
			} catch (IOException e) {
				e.printStackTrace();
			}

			return fp;
		}
		return "ERROR";
	}
	public void setFirstTimeMoveRight()
	{
		Random r = new Random();
		boolean nm = r.nextBoolean();
		if(nm)
		{
			server.setNextMove(nm);
		}
		else
		{
			client.setNextMove(nm);
		}
	}

	public String toString() {
		return "GameID = " + id + "\n" + server + "\n" + client;
	}
}
