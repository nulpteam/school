/**
 * @author Gutey Bogdan
 * 
 */
package epam.ph.sg.models.sb;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class Game {
	private static Logger log = Logger.getLogger(Game.class);
	private Server server;
	private Client client;
	private int id;
	private String nextMove;
	
	
	public String getNextMove() {
		return nextMove;
	}

	public void setNextMove(String nextMove) {
		this.nextMove = nextMove;
	}

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

	public boolean isBothStarted()
	{
		return server.isStarted() && client.isStarted();
	}
	
	
	public FireResponse fireCheck(int gameID, String connectionType,
			String point) {
		Game game = ActiveGames.getGame(gameID);
		FireResponse fireResponse = new FireResponse();
		SocketFireResponse socetFireResponse = new SocketFireResponse();
		//міняє чергу пострілу
		
		
		int x = Integer.parseInt(Character.toString(point.charAt(0)));
		int y = Integer.parseInt(Character.toString(point.charAt(1)));
		
		if (connectionType.equalsIgnoreCase("server")) {
			BSBoard bsBoard = game.getClient().getGameBoard();
			String[][] board = bsBoard.BoardtoArray();
			String fp = board[x][y];
			if(!fp.equals("00"))
			{
				char[] arr = fp.toCharArray();
				arr[1] = '0';
				StringBuilder sb = new StringBuilder();
				sb.append(arr);
				String str = sb.toString();
				//Вказуємо шо корабель підбитий
				board[x][y] = str;
				//заносимо зміни в гру
				bsBoard.makeChanges(x, y, arr[1]);
				fireResponse.setMiss(board[x][y]);
				fireResponse.setLock("");
			}else
			{
				changeMove();
				fireResponse.setMiss("00");
				fireResponse.setLock("client");
			}
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonVal="";
			socetFireResponse.setSheep(board[x][y]);
			socetFireResponse.setPoint(point);
			try {
				jsonVal= mapper.writeValueAsString(socetFireResponse);
				log.debug("jsonVal="+jsonVal);
			} catch (JsonGenerationException e1) {
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
			
			
			//до опонента летить інфа через сокет
			try {
				game.getClient().getConn().sendMessage(jsonVal/*"sheep|fail= " + board[x][y]+" point= "+point*/);
			} catch (IOException e) {
				e.printStackTrace();
			}

			//return fireResponse;
		} else {
			BSBoard bsBoard = game.getServer().getGameBoard();
			String[][] board = bsBoard.BoardtoArray();
			String fp = board[x][y];
			if(!fp.equals("00"))
			{
				char[] arr = fp.toCharArray();	
				arr[1] = '0';
				StringBuilder sb = new StringBuilder();
				sb.append(arr);
				String str = sb.toString();
				//Вказуємо шо корабель підбитий
				board[x][y] = str;
				//заносимо зміни в гру
				bsBoard.makeChanges(x, y, arr[1]);
				fireResponse.setMiss(board[x][y]);
				fireResponse.setLock("");
			}
			else
			{
				changeMove();
				fireResponse.setMiss("00");
				fireResponse.setLock("server");
			}
			ObjectMapper mapper = new ObjectMapper();
			String jsonVal="";
			socetFireResponse.setSheep(board[x][y]);
			socetFireResponse.setPoint(point);
			try {
				jsonVal= mapper.writeValueAsString(socetFireResponse);
				log.debug("jsonVal="+jsonVal);
			} catch (JsonGenerationException e1) {
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//до опонента летить інфа через сокет
			try {
				game.getServer().getConn().sendMessage(jsonVal);
			} catch (IOException e) {
				e.printStackTrace();
			}

			//return fireResponse;
		}
		return fireResponse;
	}
	public String setFirstTimeMoveRight()
	{
		Random r = new Random();
		boolean nm = r.nextBoolean();
		if(nm)
		{
			setNextMove("server");
			log.debug("server otrymav pravo pershoho xodu");
			return "server";
		}
		else
		{
			setNextMove("client");
			log.debug("client otrymav pravo pershoho xodu");
			return "client";
		}
	}
	
	private void changeMove()
	{
		if(nextMove.equalsIgnoreCase("server"))	{
			setNextMove("client");
		} else if(nextMove.equalsIgnoreCase("client")) {
			setNextMove("server");
		}
	}

	public String toString() {
		return "GameID = " + id + "\n" + server + "\n" + client+"\n"+nextMove;
	}
}
