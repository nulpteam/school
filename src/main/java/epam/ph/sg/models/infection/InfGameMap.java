package epam.ph.sg.models.infection;

import java.util.HashMap;
import java.util.Map;

public class InfGameMap {

	private static Map<String, InfGame> gamesMap = new HashMap<String, InfGame>();

	private InfGameMap() {

	}

	public static void addGame(InfGame game) {
		gamesMap.put(game.getId(), game);
	}

	public static void deleteGame(String id) {
		gamesMap.remove(id);
	}

	public static Map<String, InfGame> getGames() {
		return gamesMap;
	}

}
