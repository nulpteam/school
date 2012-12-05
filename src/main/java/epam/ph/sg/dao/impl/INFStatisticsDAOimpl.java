/**
 * 
 */
package epam.ph.sg.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import epam.ph.sg.dao.INFStatisticsDAO;
import epam.ph.sg.models.infection.INFStatistics;

/**
 * @author roman
 *
 */
public class INFStatisticsDAOimpl implements INFStatisticsDAO {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(int id) {
		String sql = "insert into `sgdb`.`infstatistics`(id) values(" + id + ")";
		jdbcTemplate.execute(sql);
	}

	@Override
	public void win(int id) {
		String sql = "update `sgdb` . `infstatistics` set wins=wins+1 where id="
				+ id;
		jdbcTemplate.execute(sql);
	}

	@Override
	public void lose(int id) {
		String sql = "update `sgdb` . `infstatistics` set losses=losses+1 where id="
				+ id;
		jdbcTemplate.execute(sql);
	}

	@Override
	public INFStatistics getUserStatistics(int id) {
		String sql = "select wins, losses from `sgdb`.`infstatistics` where id="
				+ id;
		INFStatistics stat = jdbcTemplate.query(sql,
				new ResultSetExtractor<INFStatistics>() {

					@Override
					public INFStatistics extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						INFStatistics stat = null;
						if (rs.next()) {
							stat = new INFStatistics();
							stat.setWins(rs.getInt(1));
							stat.setLosses(rs.getInt(2));
						}
						return stat;
					}

				});
		return stat;
	}

	@Override
	public List<INFStatistics> getAllStatistics() {
		String sql = "select name, wins, losses from `sgdb`.`users` join "
				+ "`sgdb`.`infstatistics` on users.id = infstatistics.id;";

		List<INFStatistics> list = jdbcTemplate.query(sql,
				new RowMapper<INFStatistics>() {

					@Override
					public INFStatistics mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						INFStatistics stat = new INFStatistics();
						stat.setName(rs.getString(1));
						stat.setWins(rs.getInt(2));
						stat.setLosses(rs.getInt(3));
						return stat;
					}

				});
		return list;
	}

}
