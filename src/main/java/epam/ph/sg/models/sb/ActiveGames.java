package epam.ph.sg.models.sb;

import java.util.ArrayList;
import java.util.List;

public class ActiveGames {
private static List<Game> activeGames = new ArrayList<Game>();

public static Game getGame(int id) {
	return activeGames.get(id-1);
}

public static void addGame(Game game) {
	activeGames.add(game);
}
public static void removeGame(int id)
{
	activeGames.remove(id);
}

}
