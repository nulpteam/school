package epam.ph.sg.models.points;

import org.apache.log4j.Logger;

public class PtsBoard {

	private Logger logger;
	private int board[][];
	private int lastX;
	private int lastY;

	public PtsBoard() {
		logger = Logger.getLogger(PtsBoard.class);
		board = new int[Pts.Y_LENGTH][Pts.X_LENGTH];
		init();
	}

	public void putPoint(String userType, String xy) {
		int indexY = xy.indexOf('Y');
		int x = Integer.parseInt(xy.substring(1, indexY));
		int y = Integer.parseInt(xy.substring(indexY + 1));
		lastX = x;
		lastY = y;
		if (userType.equals(PtsResources.getProperty("user.type.server")))
			board[y][x] = 1;
		else if (userType.equals(PtsResources.getProperty("user.type.client")))
			board[y][x] = 2;
		else 
			logger.error(PtsResources.getProperty("error.user_type.don't_exist") + userType);
	} 
	
	public  int[][] getBoard() {
		return board;
	}
	
	public int getLastX() {
		return lastX;
	}
	
	public int getLastY() {
		return lastY;
	}

	private void init() {
		for (int i = 0; i < Pts.Y_LENGTH; i++) {
			for (int j = 0; j < Pts.X_LENGTH; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	//TODO delete this method
	public void printBoard() {
		
		for (int i = 0 ; i< Pts.Y_LENGTH; i++) {
			for (int j = 0 ; j< Pts.X_LENGTH; j++) {
				System.out.printf("%3s", board[i][j]);
			}
			System.out.println();
		}
	}
	
	
}
