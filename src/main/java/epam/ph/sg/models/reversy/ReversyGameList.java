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
	public static void setGame(Integer id, ReversyGame game) {
		ReversyGameList.gameList.put(id, game);
	}
	public static ReversyGame getGame(Integer id) {
		return ReversyGameList.gameList.get(id);
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