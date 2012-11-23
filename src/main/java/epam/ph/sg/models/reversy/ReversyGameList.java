package epam.ph.sg.models.reversy;

import java.util.HashMap;

/**
 * 
 * @author SergiyManko
 *
 */

public class ReversyGameList {
	private static HashMap<Integer, ReversyGame> gameList = new HashMap<Integer, ReversyGame>();
	public static void setGameList(HashMap<Integer, ReversyGame> gameList) {
		ReversyGameList.gameList = gameList;
	}
	private static Integer gameID = 0;
	
	public static HashMap<Integer, ReversyGame> getGameList() {
		return gameList;
	}
	public static ReversyGame addGameToList() {
		gameID++;
		ReversyGame game =  new ReversyGame(gameID.intValue());
		gameList.put(gameID, game);
		return game;
	}
	public static void removeGameFromList(Integer id) {
		gameList.remove(id);
	}
}