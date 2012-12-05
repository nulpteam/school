package epam.ph.sg.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import epam.ph.sg.dao.PointsStatisticsDAO;
import epam.ph.sg.models.points.PointsStatistics;

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
	public PointsStatistics getUserStatistics(int id) {
		String sql = "select wins, losses from `sgdb`.`ptsstatistics` where id="
				+ id;
		PointsStatistics stat = jdbcTemplate.query(sql,
				new ResultSetExtractor<PointsStatistics>() {

					@Override
					public PointsStatistics extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						PointsStatistics stat = null;
						if (rs.next()) {
							stat = new PointsStatistics();
							stat.setWins(rs.getInt(1));
							stat.setLosses(rs.getInt(2));
						}
						return stat;
					}

				});
		return stat;
	}

	@Override
	public List<PointsStatistics> getAllStatistics() {
		String sql = "select name, wins, losses from `sgdb`.`users` join "
				+ "`sgdb`.`ptsstatistics` on users.id = ptsstatistics.id;";

		List<PointsStatistics> list = jdbcTemplate.query(sql,
				new RowMapper<PointsStatistics>() {

					@Override
					public PointsStatistics mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						PointsStatistics stat = new PointsStatistics();
						stat.setName(rs.getString(1));
						stat.setWins(rs.getInt(2));
						stat.setLosses(rs.getInt(3));
						return stat;
					}

				});
		return list;
	}

}
