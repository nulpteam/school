package epam.ph.sg.models.points;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class PtsGameMap {

	private static Map<Integer, PtsGame> gamesMap = new HashMap<Integer, PtsGame>();
	private static Map<Integer, String> gameServers = new HashMap<Integer, String>();

	private static Logger logger = Logger.getLogger(PtsGameMap.class);

	private PtsGameMap() {

	}

	public static void addGame(PtsGame game) {

		if (game != null) {
			gamesMap.put(game.getId(), game);
			gameServers.put(game.getId(), game.getServer().getName());
		} else
			logger.error("can't add game!!!");
	}

	public static void deleteGame(int id) {
		gamesMap.remove(id);
	}

	public static void deleteGameServer(int id) {
		gameServers.remove(id);
	}

	public static Map<Integer, PtsGame> getGames() {
		return gamesMap;
	}

	public static Map<Integer, String> getGameServers() {
		return gameServers;
	}

}
