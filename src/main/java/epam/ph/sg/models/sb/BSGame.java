package epam.ph.sg.models.sb;

public class BSGame {
	private int id;
	private BSPlayer player1;
	private BSPlayer player2;
	private BSBoard board1;
	private BSBoard board2;

	public BSGame(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
		setPlayer1(new BSPlayer());
		setPlayer2(new BSPlayer());
		setBoard1(new BSBoard());
		setBoard2(new BSBoard());
	}

	public BSPlayer getPlayer1() {
		return player1;
	}

	public void setPlayer1(BSPlayer player1) {
		this.player1 = player1;
	}

	public BSPlayer getPlayer2() {
		return player2;
	}

	public void setPlayer2(BSPlayer player2) {
		this.player2 = player2;
	}

	public BSBoard getBoard1() {
		return board1;
	}

	public void setBoard1(BSBoard board1) {
		this.board1 = board1;
	}

	public BSBoard getBoard2() {
		return board2;
	}

	public void setBoard2(BSBoard board2) {
		this.board2 = board2;
	}

	public int getId() {
		return id;
	}
	
}