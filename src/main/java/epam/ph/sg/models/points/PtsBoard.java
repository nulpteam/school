package epam.ph.sg.models.points;

public class PtsBoard {

	private int board[][];
	private final int X_LENGTH = 22;
	private final int Y_LENGTH = 26;
	private PtsLastChanges lastChanges;

	public PtsBoard() {
		lastChanges = new PtsLastChanges();
		board = new int[Y_LENGTH][X_LENGTH];
		init();
	}

	public void putPoint(String xy, String user) {
		int indexY = xy.indexOf('Y');
		int x = Integer.parseInt(xy.substring(1, indexY));
		int y = Integer.parseInt(xy.substring(indexY + 1));
		board[y][x] = 1;
		lastChanges.setCoordsOfChanges(xy);
		lastChanges.setUserThatChanged(user);
	} 
	
	public PtsLastChanges getLastChanges() {
		return lastChanges;
	}

	private void init() {
		for (int i = 0; i < Y_LENGTH; i++) {
			for (int j = 0; j < X_LENGTH; j++) {
				board[i][j] = 0;
			}
		}
	}
	
}
