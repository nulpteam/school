package epam.ph.sg.models.xo;

/**
 * @author Talash Pavlo
 */
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import epam.ph.sg.models.User;

public class XOConnector {
	private static Logger log = Logger.getLogger(XOConnector.class);

	private static Map<Integer, XOPlayer> serverMap = new HashMap<Integer, XOPlayer>();

	/**
	 * Create game
	 * 
	 * @param server
	 *            - User instance
	 * 
	 * @return XOPlayer instance of creator
	 */
	public static XOPlayer create(User server) {
		XOPlayer serverPlayer = new XOPlayer(server.getId(), XOBox.X,
				new XOGame());
		serverPlayer.getGame().setServer(server);
		serverMap.put(server.getId(), serverPlayer);

		log.info(server.getName() + "(id=" + server.getId()
				+ ") created the game");
		return serverPlayer;
	}

	/**
	 * Connect to the game
	 * 
	 * @param serverId
	 *            - id of server
	 * @param client
	 *            - User instance
	 * 
	 * @return XOPlayer instance of client
	 */
	public static XOPlayer connect(int serverID, User client) {
		XOPlayer serverPlayer = serverMap.get(serverID);
		if (serverPlayer == null) {
			return null;
		}
		XOPlayer clientPlayer = new XOPlayer(client.getId(), XOBox.O,
				serverPlayer.getGame());
		clientPlayer.getGame().setClient(client);
		clientPlayer.getGame().getStatus().setLastPlayer(client.getId());
		clientPlayer.setOponentId(serverID);
		serverPlayer.setOponentId(client.getId());
		serverMap.remove(serverID);

		User server = clientPlayer.getGame().getServer();
		log.info(client.getName() + "(id=" + client.getId() + ") connected to "
				+ server.getName() + "(id=" + server.getId() + ")");
		return clientPlayer;
	}

	/**
	 * Server Map getter
	 * 
	 * @return Map of servers (key String, value XOPlayer)
	 */
	public static Map<Integer, XOPlayer> getServerMap() {
		return serverMap;
	}
}
