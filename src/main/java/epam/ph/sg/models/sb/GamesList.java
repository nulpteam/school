package epam.ph.sg.models.sb;

import java.util.HashMap;

public class GamesList {
	private static HashMap<Integer, Game> gameListBS = new HashMap<Integer, Game>();
	public static void setGameListBS(HashMap<Integer, Game> gameListBS) {
		GamesList.gameListBS = gameListBS;
	}
	private static Integer gameID = 0;
	
	public static HashMap<Integer, Game> getGameListBS() {
		return gameListBS;
	}

	public static Game/*Integer*/ addGameToListBS() {
		gameID++;
		/*BSGame bsGame =  new BSGame(gameID.intValue());
		gameListBS.put(gameID, bsGame);*/
		//BOBIK
		Game game =  new Game(gameID.intValue());
		gameListBS.put(gameID, game);
		//return gameID;
		return game;
	}
	public static void removeGameFromListBS(Integer id) {
		gameListBS.remove(id);
	}

}
