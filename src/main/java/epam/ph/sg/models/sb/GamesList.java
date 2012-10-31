package epam.ph.sg.models.sb;

import java.util.HashMap;

public class GamesList {
	private static HashMap<Integer, BSGame> gameListBS = new HashMap<Integer, BSGame>();
	public static void setGameListBS(HashMap<Integer, BSGame> gameListBS) {
		GamesList.gameListBS = gameListBS;
	}
	private static Integer gameID = 0;
	
	/*public GamesList() {
		gameID = 0;
		gameListBS = new HashMap<Integer, BSGame>();
	}*/
	public static HashMap<Integer, BSGame> getGameListBS() {
		return gameListBS;
	}

	public static Integer addGameToListBS() {
		gameID++;
		BSGame bsGame =  new BSGame(gameID.intValue());
		gameListBS.put(gameID, bsGame);
		return gameID;
	}
	public static void removeGameFromListBS(Integer id) {
		gameListBS.remove(id);
	}

}
