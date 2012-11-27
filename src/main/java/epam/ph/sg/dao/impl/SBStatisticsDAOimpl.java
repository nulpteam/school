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

import epam.ph.sg.dao.SBStatisticsDAO;
import epam.ph.sg.models.sb.SBStatistics;

public class SBStatisticsDAOimpl implements SBStatisticsDAO {
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
		String sql = "insert into `sgdb`.`sbstatistics`(id) values(" + id + ")";
		jdbcTemplate.execute(sql);
	}

	@Override
	public void win(int id) {
		String sql = "update `sgdb` . `sbstatistics` set wins=wins+1 where id="
				+ id;
		jdbcTemplate.execute(sql);
	}

	@Override
	public void lose(int id) {
		String sql = "update `sgdb` . `sbstatistics` set losses=losses+1 where id="
				+ id;
		jdbcTemplate.execute(sql);
	}

	@Override
	public SBStatistics getUserStatistics(int id) {
		String sql = "select wins, losses from `sgdb`.`sbstatistics` where id="
				+ id;
		SBStatistics stat = jdbcTemplate.query(sql,
				new ResultSetExtractor<SBStatistics>() {

					@Override
					public SBStatistics extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						SBStatistics stat = null;
						if (rs.next()) {
							stat = new SBStatistics();
							stat.setWins(rs.getInt(1));
							stat.setLosses(rs.getInt(2));
						}
						return stat;
					}

				});
		return stat;
	}

	@Override
	public List<SBStatistics> getAllStatistics() {
		String sql = "select name, wins, losses from `sgdb`.`users` join "
				+ "`sgdb`.`sbstatistics` on users.id = sbstatistics.id;";

		List<SBStatistics> list = jdbcTemplate.query(sql,
				new RowMapper<SBStatistics>() {

					@Override
					public SBStatistics mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						SBStatistics stat = new SBStatistics();
						stat.setName(rs.getString(1));
						stat.setWins(rs.getInt(2));
						stat.setLosses(rs.getInt(3));
						return stat;
					}

				});
		return list;
	}
}
