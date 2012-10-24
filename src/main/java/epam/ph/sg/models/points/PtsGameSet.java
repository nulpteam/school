package epam.ph.sg.models.points;

import java.util.HashSet;
import java.util.Set;

public class PtsGameSet {

	private static Set<PtsGame> gamesSet = new HashSet<PtsGame>();
	
	private PtsGameSet() {
		
	}
	
	public static void addGame(PtsGame game) {
		gamesSet.add(game);
	}
	
	public static void deleteGame(PtsGame game) {
		gamesSet.remove(game);
	}
	
	public static Set<PtsGame> getGames() {
		return gamesSet;
	}
	
	
}
