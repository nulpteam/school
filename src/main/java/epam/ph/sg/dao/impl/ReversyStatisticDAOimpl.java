package epam.ph.sg.dao.impl;

/**
 * @author Gutey Bogdan
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import epam.ph.sg.dao.ReversyStatisticDAO;
import epam.ph.sg.models.reversy.ReversyStatistic;

public class ReversyStatisticDAOimpl implements ReversyStatisticDAO {
	//private static Logger log = Logger.getLogger(SBStatisticsDAOimpl.class);
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(int id) {
		String sql = "insert into `sgdb`.`reversystatistics`(id) values(" + id + ")";
		jdbcTemplate.execute(sql);
	}

	@Override
	public void win(int id) {
		String sql = "update `sgdb` . `reversystatistics` set wins=wins+1 where id="
				+ id;
		jdbcTemplate.execute(sql);
	}

	@Override
	public void lose(int id) {
		String sql = "update `sgdb` . `reversystatistics` set losses=losses+1 where id="
				+ id;
		jdbcTemplate.execute(sql);
	}

	@Override
	public ReversyStatistic getUserStatistics(int id) {
		String sql = "select wins, losses from `sgdb`.`reversystatistics` where id="
				+ id;
		ReversyStatistic stat = jdbcTemplate.query(sql,
				new ResultSetExtractor<ReversyStatistic>() {

					@Override
					public ReversyStatistic extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						ReversyStatistic stat = null;
						if (rs.next()) {
							stat = new ReversyStatistic();
							stat.setWins(rs.getInt(1));
							stat.setLosses(rs.getInt(2));
						}
						return stat;
					}

				});
		return stat;
	}

	@Override
	public List<ReversyStatistic> getAllStatistics() {
		String sql = "select name, wins, losses from `sgdb`.`users` join "
				+ "`sgdb`.`sbstatistics` on users.id = sbstatistics.id;";

		List<ReversyStatistic> list = jdbcTemplate.query(sql,
				new RowMapper<ReversyStatistic>() {

					@Override
					public ReversyStatistic mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						ReversyStatistic stat = new ReversyStatistic();
						stat.setName(rs.getString(1));
						stat.setWins(rs.getInt(2));
						stat.setLosses(rs.getInt(3));
						return stat;
					}

				});
		return list;
	}
}
