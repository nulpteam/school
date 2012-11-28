package epam.ph.sg.models.infection;

import java.io.IOException;
import java.io.Serializable;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket.Connection;


/*
 * @author roman
 */
public class InfGame implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6783001176056699868L;



	private static Logger logger = Logger.getLogger(InfGame.class);



	private InfPlayer server, client;
	private static int gameNumber = 0;
	private String id;
	private InfJsonParser jsonParser;
	private int serverScore=0;
	private int clientScore=0;
	private int[][] board=new int[7][7];
	private int fmXcoor;
	private int fmYcoor;
	private boolean clientLock;
	private boolean serverlock;
	

	public InfGame() {

		setId(new Integer(gameNumber++).toString());
		setServer(new InfPlayer());
		setClient(new InfPlayer());
		jsonParser = new InfJsonParser();
		
		setClientLock(true);
		setServerlock(false);
		
		board[0][0]=1;
		board[0][6]=2;
		board[6][0]=2;
		board[6][6]=1;
		

	}

	public void setPlayerInfo(String playerType, Connection conn) {

		if (playerType.equals("server")) {
			server.setConn(conn);
			InfClientMessage message = new InfClientMessage();
			message.setType("serverConnect");
			message.setServerName(server.getName());
			message.setBoard(this.board);
			sendMessage("server", message);


		} else if (playerType.equals("client")) {

			client.setConn(conn);
			InfClientMessage message = new InfClientMessage();
			message.setType("clientConnect");
			message.setClientName(client.getName());
			message.setServerName(server.getName());
			message.setBoard(this.board);
			sendMessage("client", message);
			sendMessage("server", message);

		}
	}

	private void sendMessage(String userType, InfClientMessage message) {

		try {

			if (userType.equals("server")) {

				server.getConn().sendMessage(jsonParser.convertClientMessageToJson(message));

			} else if (userType.equals("client")) {

				client.getConn().sendMessage(jsonParser.convertClientMessageToJson(message));

			}

		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	public void changeGame(InfClientMessage message,String id){
		
		if (message.getType().equals("firstmove")){

			if (message.getUserType().equals("server")){
				logger.debug("Server make first move");															
			    setFmXcoor(message.getXcoord());
			    setFmYcoor(message.getYcoord());
				sendMessage("server", InfGameBoard.validateFirstMove(board, message));
				
			}
			if (message.getUserType().equals("client")){
				logger.debug("Client make first move");
				setFmXcoor(message.getXcoord());
			    setFmYcoor(message.getYcoord());
				sendMessage("client", InfGameBoard.validateFirstMove(board, message));
				
			}
		} 
		
		if (message.getType().equals("secondmove")){
			if (message.getUserType().equals("server")){
				logger.debug("Server make second move");
				message = InfGameBoard.validateSecondMove(board, message,this.getFmXcoor(),this.getFmYcoor(),id );
				sendMessage("server", message);
				sendMessage("client", message);
				
			}
			if (message.getUserType().equals("client")){
				logger.debug("Client make second move");
				message = InfGameBoard.validateSecondMove(board, message,this.getFmXcoor(),this.getFmYcoor(),id );
				sendMessage("server", message);
				sendMessage("client", message);
				
			}
		}
		if (message.getType().equals("serverOut")){
			message.setType("clientWin");
			sendMessage("server", message);
			sendMessage("client", message);
		}
		if (message.getType().equals("clientOut")){
			message.setType("serverWin");
			sendMessage("server", message);
			sendMessage("client", message);
		}
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public InfPlayer getServer() {
		return server;
	}


	public void setServer(InfPlayer server) {
		this.server = server;
	}


	public InfPlayer getClient() {
		return client;
	}


	public void setClient(InfPlayer client) {
		this.client = client;
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

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public int getFmXcoor() {
		return fmXcoor;
	}

	public void setFmXcoor(int fmXcoor) {
		this.fmXcoor = fmXcoor;
	}

	public int getFmYcoor() {
		return fmYcoor;
	}

	public void setFmYcoor(int fmYcoor) {
		this.fmYcoor = fmYcoor;
	}

	public boolean isClientLock() {
		return clientLock;
	}

	public void setClientLock(boolean clientLock) {
		this.clientLock = clientLock;
	}

	public boolean isServerlock() {
		return serverlock;
	}

	public void setServerlock(boolean serverlock) {
		this.serverlock = serverlock;
	}


}

