package epam.ph.sg.dao;

/**
 * @author Bogdan Gutey
 */
import java.util.List;

import epam.ph.sg.models.sb.SBStatistics;

public interface SBStatisticsDAO {
	
	void insert(int id);
	void win(int id);
	void lose(int id);
	SBStatistics getUserStatistics(int id);
	List<SBStatistics> getAllStatistics();
}