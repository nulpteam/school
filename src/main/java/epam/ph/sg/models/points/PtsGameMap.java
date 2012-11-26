package epam.ph.sg.models.points;

import java.util.HashMap;
import java.util.Map;

public class PtsGameMap {

	private static Map<Integer, PtsGame> gamesMap = new HashMap<Integer, PtsGame>();
	private static Map<Integer, String> gameServers = new HashMap<Integer, String>();
	
	private PtsGameMap() {
		
	}
	
	public static void addGame(PtsGame game) {
		gamesMap.put(game.getId(), game);
		gameServers.put(game.getId(), game.getServer().getName());
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
