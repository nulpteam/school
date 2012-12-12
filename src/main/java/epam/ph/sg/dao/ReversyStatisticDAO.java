package epam.ph.sg.dao;

/**
 * @author Bogdan Gutey
 */
import java.util.List;

import epam.ph.sg.models.reversy.ReversyStatistic;

public interface ReversyStatisticDAO {
	
	void insert(int id);
	void win(int id);
	void lose(int id);
	ReversyStatistic getUserStatistics(int id);
	List<ReversyStatistic> getAllStatistics();
	void nichija(int id);
}