/**
 * 
 */
package epam.ph.sg.dao;

import java.util.List;

import epam.ph.sg.models.infection.INFStatistics;

/**
 * @author roman
 *
 */
public interface INFStatisticsDAO {
	/**
	 * Insert new XOStatistics in the DB
	 * 
	 * @param id
	 *            - User ID
	 */
	void insert(int id);

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
	INFStatistics getUserStatistics(int id);

	/**
	 * Extract statistics from the DB
	 * 
	 * @return List of XOStatistics
	 */
	List<INFStatistics> getAllStatistics();

}
