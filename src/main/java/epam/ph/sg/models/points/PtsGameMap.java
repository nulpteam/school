package epam.ph.sg.models.points;

import java.util.HashMap;
import java.util.Map;

public class PtsGameMap {

	private static Map<String, PtsGame> gamesMap = new HashMap<String, PtsGame>();
	
	private PtsGameMap() {
		
	}
	
	public static void addGame(PtsGame game) {
		gamesMap.put(game.getId(), game);
	}
	
	public static void deleteGame(PtsGame game) {
		gamesMap.remove(game.getId());
	}
	
	public static Map<String, PtsGame> getGames() {
		return gamesMap;
	}
	
	
}
