package epam.ph.sg.models.xo;

/**
 * @author Paul Michael T.
 */
import java.util.HashMap;
import java.util.Map;

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
	public static XOPlayer create(String id) {
		XOGame game = new XOGame();
		XOPlayer server = new XOPlayer(id, XO.X);
		server.setGame(game);
		// server.getGame().setStatus(Integer.parseInt(id));
		serverMap.put(id, server);
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
	public static XOPlayer connect(String serverId, String clientId) {
		XOPlayer server = serverMap.get(serverId);
		XOPlayer client = new XOPlayer(clientId, XO.O);
		client.setGame(server.getGame());
		client.getGame().setStatus(Integer.parseInt(clientId));
		serverMap.remove(serverId);
		return client;
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
