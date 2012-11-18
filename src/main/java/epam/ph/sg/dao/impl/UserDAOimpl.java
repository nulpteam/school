package epam.ph.sg.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import epam.ph.sg.dao.UserDAO;
import epam.ph.sg.models.User;

public class UserDAOimpl implements UserDAO {
	
	private JdbcTemplate jdbcTemplate = null;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User getUserByName(String name) {
		String sql = "select id, name, pass from users where name='" + name + "'";
		User user = jdbcTemplate.query(sql, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException,
			DataAccessException {
				User user = null;
				if (rs.next()) {
					user = new User();
					user.setId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setPass(rs.getString(3));
				}
				return user;

			}
		});
		return user;
	}
}
