package epam.ph.sg.models.xo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epam.ph.sg.dao.XOStatisticsDAO;

public class XOStatistics {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"springconfig.xml");
	private static XOStatisticsDAO dao = (XOStatisticsDAO) ctx
			.getBean("xoStatisticsDAOimpl");

	public static void win(int id) {
		dao.win(id);
	}

	public static void lose(int id) {
		dao.lose(id);
	}
	
	public static XOStatistics getUserStatistics(int id) {
		return dao.getUserStatistics(id);
	}
	
	public static void main(String[] args) {
		XOStatistics stat = getUserStatistics(2);
		System.out.println(stat.getLosses()+" "+stat.getWins());
	}
	
	public static List<XOStatistics> getAllStatistics() {
		return dao.getAllStatistics();
	}

	private String name;
	private int wins;
	private int losses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getTotal() {
		return wins - losses;
	}
}
