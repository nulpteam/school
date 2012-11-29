package epam.ph.sg.models.reversy;


/**
 * 
 * @author SergiyManko
 *
 */

public class ReversyGame {
	private Integer id;
	private ReversyPlayer player1;
	private ReversyPlayer player2;
	private ReversyBoard board;
	private String playerNameToMove;
	public ReversyGame(int gameId) {
		setId(gameId);
		board = new ReversyBoard();
		board.setCanX();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getPlayerNameToMove() {
		return playerNameToMove;
	}

	public void setPlayerNameToMove(String playerNameToMove) {
		this.playerNameToMove = playerNameToMove;
	}

	public String toString() {
		return ("gameID = " + id + " player1 = " + player1.getName() + " player2" + player2.getName() + "\nboard\n" + board);
	}

}