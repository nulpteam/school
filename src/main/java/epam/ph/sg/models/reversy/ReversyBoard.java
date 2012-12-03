package epam.ph.sg.models.reversy;

/**
 * 
 * @author SergiyManko
 *
 */

import java.util.ArrayList;
import java.util.List;

import epam.ph.sg.controllers.ReversyController;

public class ReversyBoard {
	private int boardSize = 64;
	private List<String> board = new ArrayList<String>(boardSize);
	private int movesX;
	private int movesO;
	private String next;

	public ReversyBoard() {
		for (int i = 0; i < boardSize; i++) {
			board.add(ReversyController.boundle.getString("game.figure.null"));
		}
		//put first 4 figures in new game
		setCell(3, 3, ReversyController.boundle.getString("game.figure.x"));
		setCell(4, 4, ReversyController.boundle.getString("game.figure.x"));
		setCell(4, 3, ReversyController.boundle.getString("game.figure.o"));
		setCell(3, 4, ReversyController.boundle.getString("game.figure.o"));
	}
	//game logic
	public void changeBoard(int x, int y, String figure) {
		int index = x * 8 + y;
		board.set(index, figure);
		if (figure.equals(ReversyController.boundle.getString("game.figure.x"))){
			if ((x > 0)&&(y > 0)&&getCell(x - 1, y - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
				int x0 = x - 1;
				int y0 = y - 1;
				while ((x0 > 0) && (y0 > 0) && getCell(x0 - 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
					x0--;
					y0--;
				}
				if ((x0 > 0) && (y0 > 0) && getCell(x0 - 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
					for (int i = x - 1, j = y - 1; i >= x0 && j >= y0; i--, j--) {
//						for (int j = y - 1; j >= y0; j--) {
							setCell(i, j, ReversyController.boundle.getString("game.figure.x"));
//						}
					}
				}
			}
			if ((y > 0)&&getCell(x, y - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
				int x0 = x;
				int y0 = y - 1;
				while ((y0 > 0) && getCell(x0, y0 - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
					y0--;
				}
				if ((y0 > 0) && getCell(x0, y0 - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
					for (int j = y - 1; j >= y0; j--) {
						setCell(x0, j, ReversyController.boundle.getString("game.figure.x"));
					}
				}
			}
			if ((x < 7)&&(y > 0)&&getCell(x + 1, y - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
				int x0 = x + 1;
				int y0 = y - 1;
				while ((x0 < 7) && (y0 > 0) && getCell(x0 + 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
					x0++;
					y0--;
				}
				if ((x0 < 7) && (y0 > 0) && getCell(x0 + 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
					for (int i = x + 1, j = y - 1; i <= x0 && j >= y0; i++, j--) {
//						for (int j = y - 1; j >= y0; j--) {
							setCell(i, j, ReversyController.boundle.getString("game.figure.x"));
//						}
					}
				}
			}
			
			if ((x > 0)&&getCell(x - 1, y).equals(ReversyController.boundle.getString("game.figure.o"))) {
				int x0 = x - 1;
				int y0 = y;
				while ((x0 > 0) && getCell(x0 - 1, y0).equals(ReversyController.boundle.getString("game.figure.o"))) {
					x0--;
				}
				if ((x0 > 0) && getCell(x0 - 1, y0).equals(ReversyController.boundle.getString("game.figure.x"))) {
					for (int i = x - 1; i >= x0; i--) {
							setCell(i, y0, ReversyController.boundle.getString("game.figure.x"));
					}
				}
			}
			if ((x < 7)&&getCell(x + 1, y).equals(ReversyController.boundle.getString("game.figure.o"))) {
				int x0 = x + 1;
				int y0 = y;
				while ((x0 < 7) && getCell(x0 + 1, y0).equals(ReversyController.boundle.getString("game.figure.o"))) {
					x0++;
				}
				if ((x0 < 7) && getCell(x0 + 1, y0).equals(ReversyController.boundle.getString("game.figure.x"))) {
					for (int i = x + 1; i <= x0; i++) {
							setCell(i, y0, ReversyController.boundle.getString("game.figure.x"));
					}
				}
			}
			if ((x > 0)&&(y < 7)&&getCell(x - 1, y + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
				int x0 = x - 1;
				int y0 = y + 1;
				while ((x0 > 0) && (y0 < 7) && getCell(x0 - 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
					x0--;
					y0++;
				}
				if ((x0 > 0) && (y0 < 7) && getCell(x0 - 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
					for (int i = x - 1, j = y + 1; i >= x0 && j <= y0; i--, j++) {
//						for (int j = y + 1; j <= y0; j++) {
							setCell(i, j, ReversyController.boundle.getString("game.figure.x"));
//						}
					}
				}
			}
			if ((y < 7)&&getCell(x, y + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
				int x0 = x;
				int y0 = y + 1;
				while ((y0 < 7) && getCell(x0, y0 + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
					y0++;
				}
				if ((y0 < 7) && getCell(x0, y0 + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
					for (int j = y + 1; j <= y0; j++) {
						setCell(x0, j, ReversyController.boundle.getString("game.figure.x"));
					}
				}
			}
			if ((x < 7)&&(y < 7)&&getCell(x + 1, y + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
				int x0 = x + 1;
				int y0 = y + 1;
				while ((x0 < 7) && (y0 < 7) && getCell(x0 + 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
					x0++;
					y0++;
				}
				if ((x0 < 7) && (y0 < 7) && getCell(x0 + 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
					for (int i = x + 1, j = y + 1; i <= x0 && j <= y0; i++, j++) {
//						for (int j = y + 1; j <= y0; j++) {
							setCell(i, j, ReversyController.boundle.getString("game.figure.x"));
//						}
					}
				}
			}
			setCanO();
			next = ReversyController.boundle.getString("game.figure.o");
			if (movesO == 0) {
				setCanX();
				if (movesX == 0) {
					next = ReversyController.boundle.getString("game.end");
				} else next = ReversyController.boundle.getString("game.figure.x");
			}
		} else if (figure.equals(ReversyController.boundle.getString("game.figure.o"))) {
			if ((x > 0)&&(y > 0)&&getCell(x - 1, y - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
				int x0 = x - 1;
				int y0 = y - 1;
				while ((x0 > 0) && (y0 > 0) && getCell(x0 - 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
					x0--;
					y0--;
				}
				if ((x0 > 0) && (y0 > 0) && getCell(x0 - 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
					for (int i = x - 1, j = y - 1; i >= x0 && j >= y0; i--, j--) {
//						for (int j = y - 1; j >= y0; j--) {
							setCell(i, j, ReversyController.boundle.getString("game.figure.o"));
//						}
					}
				}
			}
			if ((y > 0)&&getCell(x, y - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
				int x0 = x;
				int y0 = y - 1;
				while ((y0 > 0) && getCell(x0, y0 - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
					y0--;
				}
				if ((y0 > 0) && getCell(x0, y0 - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
					for (int j = y - 1; j >= y0; j--) {
						setCell(x0, j, ReversyController.boundle.getString("game.figure.o"));
					}
				}
			}
			if ((x < 7)&&(y > 0)&&getCell(x + 1, y - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
				int x0 = x + 1;
				int y0 = y - 1;
				while ((x0 < 7) && (y0 > 0) && getCell(x0 + 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
					x0++;
					y0--;
				}
				if ((x0 < 7) && (y0 > 0) && getCell(x0 + 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
					for (int i = x + 1, j = y - 1; i <= x0 && j >= y0; i++, j--) {
//						for (int j = y - 1; j >= y0; j--) {
							setCell(i, j, ReversyController.boundle.getString("game.figure.o"));
//						}
					}
				}
			}
			
			if ((x > 0)&&getCell(x - 1, y).equals(ReversyController.boundle.getString("game.figure.x"))) {
				int x0 = x - 1;
				int y0 = y;
				while ((x0 > 0) && getCell(x0 - 1, y0).equals(ReversyController.boundle.getString("game.figure.x"))) {
					x0--;
				}
				if ((x0 > 0) && getCell(x0 - 1, y0).equals(ReversyController.boundle.getString("game.figure.o"))) {
					for (int i = x - 1; i >= x0; i--) {
							setCell(i, y0, ReversyController.boundle.getString("game.figure.o"));
					}
				}
			}
			if ((x < 7)&&getCell(x + 1, y).equals(ReversyController.boundle.getString("game.figure.x"))) {
				int x0 = x + 1;
				int y0 = y;
				while ((x0 < 7) && getCell(x0 + 1, y0).equals(ReversyController.boundle.getString("game.figure.x"))) {
					x0++;
				}
				if ((x0 < 7) && getCell(x0 + 1, y0).equals(ReversyController.boundle.getString("game.figure.o"))) {
					for (int i = x + 1; i <= x0; i++) {
							setCell(i, y0, ReversyController.boundle.getString("game.figure.o"));
					}
				}
			}
			if ((x > 0)&&(y < 7)&&getCell(x - 1, y + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
				int x0 = x - 1;
				int y0 = y + 1;
				while ((x0 > 0) && (y0 < 7) && getCell(x0 - 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
					x0--;
					y0++;
				}
				if ((x0 > 0) && (y0 < 7) && getCell(x0 - 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
					for (int i = x - 1, j = y + 1; i >= x0 && j <= y0; i--, j++) {
//						for (int j = y + 1; j <= y0; j++) {
							setCell(i, j, ReversyController.boundle.getString("game.figure.o"));
//						}
					}
				}
			}
			if ((y < 7)&&getCell(x, y + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
				int x0 = x;
				int y0 = y + 1;
				while ((y0 < 7) && getCell(x0, y0 + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
					y0++;
				}
				if ((y0 < 7) && getCell(x0, y0 + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
					for (int j = y + 1; j <= y0; j++) {
						setCell(x0, j, ReversyController.boundle.getString("game.figure.o"));
					}
				}
			}
			if ((x < 7)&&(y < 7)&&getCell(x + 1, y + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
				int x0 = x + 1;
				int y0 = y + 1;
				while ((x0 < 7) && (y0 < 7) && getCell(x0 + 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
					x0++;
					y0++;
				}
				if ((x0 < 7) && (y0 < 7) && getCell(x0 + 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
					for (int i = x + 1, j = y + 1; i <= x0 && j <= y0; i++, j++) {
//						for (int j = y + 1; j <= y0; j++) {
							setCell(i, j, ReversyController.boundle.getString("game.figure.o"));
//						}
					}
				}
			}
			
			setCanO();
			next = ReversyController.boundle.getString("game.figure.o");
			if (movesO == 0) {
				setCanX();
				if (movesX == 0) {
					next = ReversyController.boundle.getString("game.end");
				} else next = ReversyController.boundle.getString("game.figure.x");
			}
			
			setCanX();
			next = ReversyController.boundle.getString("game.figure.x");
			if (movesX == 0) {
				setCanO();
				if (movesX == 0) {
					next = ReversyController.boundle.getString("game.end");
				} else next = ReversyController.boundle.getString("game.figure.o");
			}
		}
	}
	
	//game logic additional 1
	public void setCanX() {
		movesX = 0;
		for (int x = 0; x <= 7; x++) {
			for (int y = 0; y <= 7; y++) {
				if (!getCell(x, y).equals(ReversyController.boundle.getString("game.figure.x")) && !getCell(x, y).equals(ReversyController.boundle.getString("game.figure.o"))) {
					if ((x > 0)&&(y > 0)&&getCell(x - 1, y - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
						int x0 = x - 1;
						int y0 = y - 1;
						while ((x0 > 0) && (y0 > 0) && getCell(x0 - 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
							x0--;
							y0--;
						}
						if ((x0 > 0) && (y0 > 0) && getCell(x0 - 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canX"));
							movesX++;
							continue;
						}
					}
					if ((y > 0)&&getCell(x, y - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
						int x0 = x;
						int y0 = y - 1;
						while ((y0 > 0) && getCell(x0, y0 - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
							y0--;
						}
						if ((y0 > 0) && getCell(x0, y0 - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canX"));
							movesX++;
							continue;
						}
					}
					if ((x < 7)&&(y > 0)&&getCell(x + 1, y - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
						int x0 = x + 1;
						int y0 = y - 1;
						while ((x0 < 7) && (y0 > 0) && getCell(x0 + 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
							x0++;
							y0--;
						}
						if ((x0 < 7) && (y0 > 0) && getCell(x0 + 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canX"));
							movesX++;
							continue;
						}
					}
					
					if ((x > 0)&&getCell(x - 1, y).equals(ReversyController.boundle.getString("game.figure.o"))) {
						int x0 = x - 1;
						int y0 = y;
						while ((x0 > 0) && getCell(x0 - 1, y0).equals(ReversyController.boundle.getString("game.figure.o"))) {
							x0--;
						}
						if ((x0 > 0) && getCell(x0 - 1, y0).equals(ReversyController.boundle.getString("game.figure.x"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canX"));
							movesX++;
							continue;
						}
					}
					if ((x < 7)&&getCell(x + 1, y).equals(ReversyController.boundle.getString("game.figure.o"))) {
						int x0 = x + 1;
						int y0 = y;
						while ((x0 < 7) && getCell(x0 + 1, y0).equals(ReversyController.boundle.getString("game.figure.o"))) {
							x0++;
						}
						if ((x0 < 7) && getCell(x0 + 1, y0).equals(ReversyController.boundle.getString("game.figure.x"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canX"));
							movesX++;
							continue;
						}
					}
					if ((x > 0)&&(y < 7)&&getCell(x - 1, y + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
						int x0 = x - 1;
						int y0 = y + 1;
						while ((x0 > 0) && (y0 < 7) && getCell(x0 - 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
							x0--;
							y0++;
						}
						if ((x0 > 0) && (y0 < 7) && getCell(x0 - 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canX"));
							movesX++;
							continue;
						}
					}
					if ((y < 7)&&getCell(x, y + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
						int x0 = x;
						int y0 = y + 1;
						while ((y0 < 7) && getCell(x0, y0 + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
							y0++;
						}
						if ((y0 < 7) && getCell(x0, y0 + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canX"));
							movesX++;
							continue;
						}
					}
					if ((x < 7)&&(y < 7)&&getCell(x + 1, y + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
						int x0 = x + 1;
						int y0 = y + 1;
						while ((x0 < 7) && (y0 < 7) && getCell(x0 + 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
							x0++;
							y0++;
						}
						if ((x0 < 7) && (y0 < 7) && getCell(x0 + 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canX"));
							movesX++;
							continue;
						}
					}
					setCell(x, y, ReversyController.boundle.getString("game.figure.null"));
				}
			}
		}
	}

	//game logic additional 2
	public void setCanO() {
		movesO = 0;
		for (int x = 0; x <= 7; x++) {
			for (int y = 0; y <= 7; y++) {
				if (!getCell(x, y).equals(ReversyController.boundle.getString("game.figure.o")) && !getCell(x, y).equals(ReversyController.boundle.getString("game.figure.x"))) {
					if ((x > 0)&&(y > 0)&&getCell(x - 1, y - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
						int x0 = x - 1;
						int y0 = y - 1;
						while ((x0 > 0) && (y0 > 0) && getCell(x0 - 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
							x0--;
							y0--;
						}
						if ((x0 > 0) && (y0 > 0) && getCell(x0 - 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canO"));
							movesO++;
							continue;
						}
					}
					if ((y > 0)&&getCell(x, y - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
						int x0 = x;
						int y0 = y - 1;
						while ((y0 > 0) && getCell(x0, y0 - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
							y0--;
						}
						if ((y0 > 0) && getCell(x0, y0 - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canO"));
							movesO++;
							continue;
						}
					}
					if ((x < 7)&&(y > 0)&&getCell(x + 1, y - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
						int x0 = x + 1;
						int y0 = y - 1;
						while ((x0 < 7) && (y0 > 0) && getCell(x0 + 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
							x0++;
							y0--;
						}
						if ((x0 < 7) && (y0 > 0) && getCell(x0 + 1, y0 - 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canO"));
							movesO++;
							continue;
						}
					}
					
					if ((x > 0)&&getCell(x - 1, y).equals(ReversyController.boundle.getString("game.figure.x"))) {
						int x0 = x - 1;
						int y0 = y;
						while ((x0 > 0) && getCell(x0 - 1, y0).equals(ReversyController.boundle.getString("game.figure.x"))) {
							x0--;
						}
						if ((x0 > 0) && getCell(x0 - 1, y0).equals(ReversyController.boundle.getString("game.figure.o"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canO"));
							movesO++;
							continue;
						}
					}
					if ((x < 7)&&getCell(x + 1, y).equals(ReversyController.boundle.getString("game.figure.x"))) {
						int x0 = x + 1;
						int y0 = y;
						while ((x0 < 7) && getCell(x0 + 1, y0).equals(ReversyController.boundle.getString("game.figure.x"))) {
							x0++;
						}
						if ((x0 < 7) && getCell(x0 + 1, y0).equals(ReversyController.boundle.getString("game.figure.o"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canO"));
							movesO++;
							continue;
						}
					}
					if ((x > 0)&&(y < 7)&&getCell(x - 1, y + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
						int x0 = x - 1;
						int y0 = y + 1;
						while ((x0 > 0) && (y0 < 7) && getCell(x0 - 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
							x0--;
							y0++;
						}
						if ((x0 > 0) && (y0 < 7) && getCell(x0 - 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canO"));
							movesO++;
							continue;
						}
					}
					if ((y < 7)&&getCell(x, y + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
						int x0 = x;
						int y0 = y + 1;
						while ((y0 < 7) && getCell(x0, y0 + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
							y0++;
						}
						if ((y0 < 7) && getCell(x0, y0 + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canO"));
							movesO++;
							continue;
						}
					}
					if ((x < 7)&&(y < 7)&&getCell(x + 1, y + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
						int x0 = x + 1;
						int y0 = y + 1;
						while ((x0 < 7) && (y0 < 7) && getCell(x0 + 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.x"))) {
							x0++;
							y0++;
						}
						if ((x0 < 7) && (y0 < 7) && getCell(x0 + 1, y0 + 1).equals(ReversyController.boundle.getString("game.figure.o"))) {
							setCell(x, y, ReversyController.boundle.getString("game.figure.canO"));
							movesO++;
							continue;
						}
					}
					setCell(x, y, ReversyController.boundle.getString("game.figure.null"));
				}
			}
		}
	}
	
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public int getMovesX() {
		return movesX;
	}
	public int getMovesO() {
		return movesO;
	}
	public String getCell(int x, int y) {
		int index = x * 8 + y;
		return board.get(index);
	}
	
	public void setCell(int x, int y, String figure) {
		int index = x * 8 + y;
		board.set(index, figure);
	}
	
	public List<String> getBoard() {
		return board;
	}

	public void setBoard(List<String> board) {
		this.board = board;
	}
	
	public String getA1() {
		return board.get(0);
	}
	public String getA2() {
		return board.get(1);
	}
	public String getA3() {
		return board.get(2);
	}
	public String getA4() {
		return board.get(3);
	}
	public String getA5() {
		return board.get(4);
	}
	public String getA6() {
		return board.get(5);
	}
	public String getA7() {
		return board.get(6);
	}
	public String getA8() {
		return board.get(7);
	}
	
	public String getB1() {
		return board.get(8);
	}
	public String getB2() {
		return board.get(9);
	}
	public String getB3() {
		return board.get(10);
	}
	public String getB4() {
		return board.get(11);
	}
	public String getB5() {
		return board.get(12);
	}
	public String getB6() {
		return board.get(13);
	}
	public String getB7() {
		return board.get(14);
	}
	public String getB8() {
		return board.get(15);
	}
	
	public String getC1() {
		return board.get(16);
	}
	public String getC2() {
		return board.get(17);
	}
	public String getC3() {
		return board.get(18);
	}
	public String getC4() {
		return board.get(19);
	}
	public String getC5() {
		return board.get(20);
	}
	public String getC6() {
		return board.get(21);
	}
	public String getC7() {
		return board.get(22);
	}
	public String getC8() {
		return board.get(23);
	}
	
	public String getD1() {
		return board.get(24);
	}
	public String getD2() {
		return board.get(25);
	}
	public String getD3() {
		return board.get(26);
	}
	public String getD4() {
		return board.get(27);
	}
	public String getD5() {
		return board.get(28);
	}
	public String getD6() {
		return board.get(29);
	}
	public String getD7() {
		return board.get(30);
	}
	public String getD8() {
		return board.get(31);
	}
	
	public String getE1() {
		return board.get(32);
	}
	public String getE2() {
		return board.get(33);
	}
	public String getE3() {
		return board.get(34);
	}
	public String getE4() {
		return board.get(35);
	}
	public String getE5() {
		return board.get(36);
	}
	public String getE6() {
		return board.get(37);
	}
	public String getE7() {
		return board.get(38);
	}
	public String getE8() {
		return board.get(39);
	}
	
	public String getF1() {
		return board.get(40);
	}
	public String getF2() {
		return board.get(41);
	}
	public String getF3() {
		return board.get(42);
	}
	public String getF4() {
		return board.get(43);
	}
	public String getF5() {
		return board.get(44);
	}
	public String getF6() {
		return board.get(45);
	}
	public String getF7() {
		return board.get(46);
	}
	public String getF8() {
		return board.get(47);
	}
	
	public String getG1() {
		return board.get(48);
	}
	public String getG2() {
		return board.get(49);
	}
	public String getG3() {
		return board.get(50);
	}
	public String getG4() {
		return board.get(51);
	}
	public String getG5() {
		return board.get(52);
	}
	public String getG6() {
		return board.get(53);
	}
	public String getG7() {
		return board.get(54);
	}
	public String getG8() {
		return board.get(55);
	}
	
	public String getH1() {
		return board.get(56);
	}
	public String getH2() {
		return board.get(57);
	}
	public String getH3() {
		return board.get(58);
	}
	public String getH4() {
		return board.get(59);
	}
	public String getH5() {
		return board.get(60);
	}
	public String getH6() {
		return board.get(61);
	}
	public String getH7() {
		return board.get(62);
	}
	public String getH8() {
		return board.get(63);
	}
	public String toString() {
		String res = "";
		for (String cell : board) {
			res = res + cell + "&";
		}
		return res;
	}
}