package epam.ph.sg.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import epam.ph.sg.dao.PointsStatisticsDAO;
import epam.ph.sg.models.points.PtsStatistics;

public class PointsStatisticsDAOImpl implements PointsStatisticsDAO {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(int id) {
		String sql = "insert into `sgdb`.`ptsstatistics`(id) values(" + id
				+ ")";
		jdbcTemplate.execute(sql);
	}

	@Override
	public void win(int id) {
		String sql = "update `sgdb` . `ptsstatistics` set wins=wins+1 where id="
				+ id;
		jdbcTemplate.execute(sql);
	}

	@Override
	public void lose(int id) {
		String sql = "update `sgdb` . `ptsstatistics` set losses=losses+1 where id="
				+ id;
		jdbcTemplate.execute(sql);
	}

	@Override
	public PtsStatistics getUserStatistics(int id) {
		String sql = "select wins, losses from `sgdb`.`ptsstatistics` where id="
				+ id;
		PtsStatistics stat = jdbcTemplate.query(sql,
				new ResultSetExtractor<PtsStatistics>() {

					@Override
					public PtsStatistics extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						PtsStatistics stat = null;
						if (rs.next()) {
							stat = new PtsStatistics();
							stat.setWins(rs.getInt(1));
							stat.setLosses(rs.getInt(2));
						}
						return stat;
					}

				});
		return stat;
	}

	@Override
	public List<PtsStatistics> getAllStatistics() {
		String sql = "select name, wins, losses from `sgdb`.`users` join "
				+ "`sgdb`.`ptsstatistics` on users.id = ptsstatistics.id;";

		List<PtsStatistics> list = jdbcTemplate.query(sql,
				new RowMapper<PtsStatistics>() {

					@Override
					public PtsStatistics mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						PtsStatistics stat = new PtsStatistics();
						stat.setName(rs.getString(1));
						stat.setWins(rs.getInt(2));
						stat.setLosses(rs.getInt(3));
						return stat;
					}

				});
		return list;
	}

}
