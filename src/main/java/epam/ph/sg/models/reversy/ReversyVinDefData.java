package epam.ph.sg.models.reversy;

public class ReversyVinDefData {
	private String player1;
	private String player2;
	private Integer count1;
	private Integer count2;
	public ReversyVinDefData(String player1, String player2, Integer count1, Integer count2) {
		setPlayer1(player1);
		setPlayer2(player2);
		setCount1(count1);
		setCount2(count2);
	}
	public String getPlayer1() {
		return player1;
	}
	public void setPlayer1(String player1) {
		this.player1 = player1;
	}
	public String getPlayer2() {
		return player2;
	}
	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
	public Integer getCount1() {
		return count1;
	}
	public void setCount1(Integer count1) {
		this.count1 = count1;
	}
	public Integer getCount2() {
		return count2;
	}
	public void setCount2(Integer count2) {
		this.count2 = count2;
	}
	public String toString()
	{
		return "player1 = "+getPlayer1()+" player2 = "+getPlayer2()+" count1 = "+getCount1()+"count2 = "+getCount2();
	}
}
