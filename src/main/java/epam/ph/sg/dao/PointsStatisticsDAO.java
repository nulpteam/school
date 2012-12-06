package epam.ph.sg.dao;

import java.util.List;

import epam.ph.sg.models.points.PtsStatistics;

public interface PointsStatisticsDAO {

	/**
	 * Insert new PointsStatistics in the DB
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
	 * @return PointsStatistics
	 */
	PtsStatistics getUserStatistics(int id);

	/**
	 * Extract statistics from the DB
	 * 
	 * @return List of PointsStatistics
	 */
	List<PtsStatistics> getAllStatistics();

}
