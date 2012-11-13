package epam.ph.sg.games.xo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epam.ph.sg.dao.XOStatisticsDAO;

public class XOStatistics {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"springconfig.xml");
	private static XOStatisticsDAO dao = (XOStatisticsDAO) ctx
			.getBean("xoStatisticsDAOimpl");

	public static void insert(int id) {
		dao.insert(id);
	}

	public static void win(int id) {
		dao.win(id);
	}

	public static void lose(int id) {
		dao.lose(id);
	}

	public static XOStatistics getUserStatistics(int id) {
		return dao.getUserStatistics(id);
	}

	public static List<XOStatistics> getAllStatistics() {
		List<XOStatistics> list = dao.getAllStatistics();
		Collections.sort(list, new Comparator<XOStatistics>() {
			@Override
			public int compare(XOStatistics o1, XOStatistics o2) {
				if (o1.getTotal() > o2.getTotal())
					return -1;
				else if (o1.getTotal() < o2.getTotal())
					return 1;
				else {
					if (o1.getWins() > o2.getWins())
						return -1;
					else if (o1.getWins() < o2.getWins())
						return 1;
					else
						return 0;
				}
			}
		});
		return list;
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
