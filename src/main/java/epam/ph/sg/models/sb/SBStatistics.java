package epam.ph.sg.models.sb;

/**
 * @author Bogdan Gutey
 */
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epam.ph.sg.dao.SBStatisticsDAO;

public class SBStatistics {
	//private static Logger log = Logger.getLogger(SBStatistics.class);
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"springconfig.xml");
	private static SBStatisticsDAO dao = (SBStatisticsDAO) ctx
			.getBean("sbStatisticsDAOimpl");
	private String name;
	private int wins;
	private int losses;
	
	public static void insert(int id) {
		dao.insert(id);
	}

	public static void win(int id) {
		dao.win(id);
	}

	public static void lose(int id) {
		dao.lose(id);
	}

	public static SBStatistics getUserStatistics(int id) {
		return dao.getUserStatistics(id);
	}

	public static List<SBStatistics> getAllStatistics() {
		List<SBStatistics> list = dao.getAllStatistics();
		Collections.sort(list, new Comparator<SBStatistics>() {
			@Override
			public int compare(SBStatistics o1, SBStatistics o2) {
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
