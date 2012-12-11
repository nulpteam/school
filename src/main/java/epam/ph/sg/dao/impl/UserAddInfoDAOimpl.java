package epam.ph.sg.dao.impl;

/**
 * @author Talash Pavlo
 */
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import epam.ph.sg.dao.UserAddInfoDAO;
import epam.ph.sg.models.UserAddInfo;

public class UserAddInfoDAOimpl implements UserAddInfoDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(int id) {
		String sql = "insert into `sgdb`.`useraddinfo`(id) values(" + id + ")";
		jdbcTemplate.execute(sql);
	}

	@Override
	public UserAddInfo getUserAddInfo(int id) {
		String sql = "select id, email, birthday, about from `sgdb`.`useraddinfo` where id="
				+ id;
		UserAddInfo userAddInfo = jdbcTemplate.query(sql,
				new ResultSetExtractor<UserAddInfo>() {

					public UserAddInfo extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						UserAddInfo userAddInfo = null;
						if (rs.next()) {
							userAddInfo = new UserAddInfo();
							userAddInfo.setId(rs.getInt(1));
							userAddInfo.setEmail(rs.getString(2));
							userAddInfo.setBirthday(rs.getString(3));
							userAddInfo.setAbout(rs.getString(4));
						}
						return userAddInfo;
					}
				});
		return userAddInfo;
	}

	@Override
	public void changeName(int id, String name) {
		String sql = "update `sgdb` . `users` set name='" + name
				+ "' where id=" + id;
		jdbcTemplate.execute(sql);
	}

	@Override
	public void changePass(int id, String pass) {
		String sql = "update `sgdb` . `users` set pass='" + pass
				+ "' where id=" + id;
		jdbcTemplate.execute(sql);
	}

	@Override
	public void changeEmail(int id, String email) {
		String sql = "update `sgdb` . `useraddinfo` set email='" + email
				+ "' where id=" + id;
		jdbcTemplate.execute(sql);
	}

	@Override
	public void changeBirthday(int id, String birthday) {
		String sql = "update `sgdb` . `useraddinfo` set birthday='" + birthday
				+ "' where id=" + id;
		jdbcTemplate.execute(sql);
	}

	@Override
	public void changeAbout(int id, String about) {
		String sql = "update `sgdb` . `useraddinfo` set about='" + about
				+ "' where id=" + id;
		jdbcTemplate.execute(sql);
	}
}
