package epam.ph.sg.models.points;

public class PtsBoard {

	private int board[][];
	private final int LENGTH = 20;

	public PtsBoard() {
		board = new int[LENGTH][LENGTH];
		init();
	}

	public void putPoint(String xy) {
		int x = parseX(xy);
		int y = parseY(xy);
		board[y][x] = 1;
	} 

	private void init() {
		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < LENGTH; j++) {
				board[i][j] = 0;
			}
		}
	}

	private int parseX(String xy) {
		String x = Character.toString(xy.charAt(2));
		return Integer.parseInt(x);
	}

	private int parseY(String xy) {
		String y = Character.toString(xy.charAt(4));
		return Integer.parseInt(y);
	}
	
}
