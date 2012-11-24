package epam.ph.sg.models.points;

import java.util.HashMap;
import java.util.Map;

public class PtsGameMap {

	private static Map<String, PtsGame> gamesMap = new HashMap<String, PtsGame>();
	private static Map<String, String> gameServers = new HashMap<String, String>();
	
	private PtsGameMap() {
		
	}
	
	public static void addGame(PtsGame game) {
		gamesMap.put(game.getId(), game);
		gameServers.put(game.getId(), game.getServer().getName());
	}
	
	public static void deleteGame(PtsGame game) {
		gamesMap.remove(game.getId());
	}
	
	public static void deleteGameServer(String id) {
		gameServers.remove(id);
	}
	
	public static Map<String, PtsGame> getGames() {
		return gamesMap;
	}
	
	public static Map<String, String> getGameServers() {
		return gameServers;
	}
	
	
}
