package epam.ph.sg.dao.impl;

/**
 * @author Paul Michael T.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author Paul Michael T.
 */
import epam.ph.sg.dao.XOStatisticsDAO;
import epam.ph.sg.models.xo.XOStatistics;

public class XOStatisticsDAOimpl implements XOStatisticsDAO {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(int id) {
		String sql = "insert into `sgdb`.`xostatistics`(id) values(" + id + ")";
		jdbcTemplate.execute(sql);
	}

	@Override
	public void win(int id) {
		String sql = "update `sgdb` . `XOstatistics` set wins=wins+1 where id="
				+ id;
		jdbcTemplate.execute(sql);
	}

	@Override
	public void lose(int id) {
		String sql = "update `sgdb` . `XOstatistics` set losses=losses+1 where id="
				+ id;
		jdbcTemplate.execute(sql);
	}

	@Override
	public XOStatistics getUserStatistics(int id) {
		String sql = "select wins, losses from `sgdb`.`xostatistics` where id="
				+ id;
		XOStatistics stat = jdbcTemplate.query(sql,
				new ResultSetExtractor<XOStatistics>() {

					@Override
					public XOStatistics extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						XOStatistics stat = null;
						if (rs.next()) {
							stat = new XOStatistics();
							stat.setWins(rs.getInt(1));
							stat.setLosses(rs.getInt(2));
						}
						return stat;
					}

				});
		return stat;
	}

	@Override
	public List<XOStatistics> getAllStatistics() {
		String sql = "select name, wins, losses from `sgdb`.`users` join "
				+ "`sgdb`.`xostatistics` on users.id = xostatistics.id;";

		List<XOStatistics> list = jdbcTemplate.query(sql,
				new RowMapper<XOStatistics>() {

					@Override
					public XOStatistics mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						XOStatistics stat = new XOStatistics();
						stat.setName(rs.getString(1));
						stat.setWins(rs.getInt(2));
						stat.setLosses(rs.getInt(3));
						return stat;
					}

				});
		return list;
	}
}
