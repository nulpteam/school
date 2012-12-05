package epam.ph.sg.models.points;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epam.ph.sg.dao.PointsStatisticsDAO;


public class PointsStatistics {
	
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"springconfig.xml");
	private static PointsStatisticsDAO dao = (PointsStatisticsDAO) ctx
			.getBean("pointsStatisticsDAOimpl");

	public static void insert(int id) {
		dao.insert(id);
	}

	public static void win(int id) {
		dao.win(id);
	}

	public static void lose(int id) {
		dao.lose(id);
	}

	public static PointsStatistics getUserStatistics(int id) {
		return dao.getUserStatistics(id);
	}

	/**
	 * Extract sort and return users Points statistics
	 * 
	 * @return List of pointsStatistics
	 */
	public static List<PointsStatistics> getAllStatistics() {
		List<PointsStatistics> list = dao.getAllStatistics();
		Collections.sort(list, new Comparator<PointsStatistics>() {
			@Override
			public int compare(PointsStatistics o1, PointsStatistics o2) {
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
