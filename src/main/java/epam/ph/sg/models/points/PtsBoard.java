package epam.ph.sg.models.points;

import org.apache.log4j.Logger;

public class PtsBoard {

	private static Logger logger = Logger.getLogger(PtsBoard.class);
	private int board[][];
	private final int X_LENGTH = 22;
	private final int Y_LENGTH = 26;

	public PtsBoard() {
		board = new int[Y_LENGTH][X_LENGTH];
		init();
	}

	public void putPoint(String userType, String xy) {
		int indexY = xy.indexOf('Y');
		int x = Integer.parseInt(xy.substring(1, indexY));
		int y = Integer.parseInt(xy.substring(indexY + 1));
		if (userType.equals("server"))
			board[y][x] = 1;
		else if (userType.equals("client"))
			board[y][x] = 2;
		else 
			logger.error("errro in user type! no such userType :" + userType);
	} 
	
	public  int[][] getBoard() {
		return board;
	}
	
//	public PtsLastChanges getLastChanges() {
//		return lastChanges;
//	}

	private void init() {
		for (int i = 0; i < Y_LENGTH; i++) {
			for (int j = 0; j < X_LENGTH; j++) {
				board[i][j] = 0;
			}
		}
	}
	
}
