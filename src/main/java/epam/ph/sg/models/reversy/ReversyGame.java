package epam.ph.sg.models.reversy;

/**
 * 
 * @author SergiyManko
 *
 */

public class ReversyGame {
	private ReversyPlayer player1;
	private ReversyPlayer player2;
	private ReversyBoard board;

	public ReversyPlayer getPlayer1() {
		return player1;
	}

	public void setPlayer1(ReversyPlayer player1) {
		this.player1 = player1;
	}

	public ReversyPlayer getPlayer2() {
		return player2;
	}

	public void setPlayer2(ReversyPlayer player2) {
		this.player2 = player2;
	}

	public ReversyBoard getBoard() {
		return board;
	}

	public void setBoard(ReversyBoard board) {
		this.board = board;
	}

}