package epam.ph.sg.models.xo;

/**
 * @author Paul Michael T.
 */
import java.util.HashMap;
import java.util.Map;

import epam.ph.sg.models.User;

public class XOConnector {
	private static Map<String, XOPlayer> serverMap = new HashMap<String, XOPlayer>();

	/**
	 * Create game
	 * 
	 * @param id
	 *            - id of creator
	 * 
	 * @return XOPlayer instance of creator
	 */
	public static XOPlayer create(User user) {
		XOGame game = new XOGame();
		XOPlayer server = new XOPlayer(user.getId(), XO.X);
		server.setGame(game);
		server.getGame().setServer(user);
		serverMap.put(user.getId(), server);
		return server;
	}

	/**
	 * Connect to the game
	 * 
	 * @param serverId
	 *            - id of server
	 * @param clientId
	 *            - id of client
	 * 
	 * @return XOPlayer instance of client
	 */
	public static XOPlayer connect(String serverID, User client) {
		XOPlayer serverP = serverMap.get(serverID);
		XOPlayer clientP = new XOPlayer(client.getId(), XO.O);
		clientP.setGame(serverP.getGame());
		clientP.getGame().setClient(client);
		clientP.getGame().setStatus(Integer.parseInt(client.getId()));
		serverMap.remove(serverID);
		return clientP;
	}

	/**
	 * Server Map getter
	 * 
	 * @return Map of servers (key String, value XOPlayer)
	 */
	public static Map<String, XOPlayer> getServerMap() {
		return serverMap;
	}
}
