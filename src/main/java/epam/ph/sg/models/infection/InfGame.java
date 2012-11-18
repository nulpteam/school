package epam.ph.sg.models.infection;

import java.io.IOException;
import java.io.Serializable;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.WebSocket.Connection;

import epam.ph.sg.models.points.PtsJsonParser;


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


	public InfGame() {

		setId(new Integer(gameNumber++).toString());
		setServer(new InfPlayer());
		setClient(new InfPlayer());
		jsonParser = new InfJsonParser();

	}

	public void setPlayerInfo(String playerType, Connection conn) {

		if (playerType.equals("server")) {
			server.setConn(conn);
			InfClientMessage message = new InfClientMessage();
			message.setType("serverConnect");
			message.setServerName(server.getName());
			sendMessage("server", message);
			

		} else if (playerType.equals("client")) {

			client.setConn(conn);
			InfClientMessage message = new InfClientMessage();
			message.setType("clientConnect");
			message.setClientName(client.getName());
			message.setServerName(server.getName());
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


}

