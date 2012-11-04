package epam.ph.sg.dao;

/**
 * @author Paul Michael T.
 */
import java.util.List;

import epam.ph.sg.models.xo.XOStatistics;

public interface XOStatisticsDAO {
	/**
	 * Record winning in the DB
	 * 
	 * @param id
	 *            - User ID
	 */
	void win(int id);

	/**
	 * Record losing in the DB
	 * 
	 * @param id
	 *            - User ID
	 */
	void lose(int id);

	/**
	 * Extract User statistics from the DB
	 * 
	 * @param id
	 *            - User ID
	 * @return XOStatistics
	 */
	XOStatistics getUserStatistics(int id);

	/**
	 * Extract statistics from the DB
	 * 
	 * @return List of XOStatistics
	 */
	List<XOStatistics> getAllStatistics();
}