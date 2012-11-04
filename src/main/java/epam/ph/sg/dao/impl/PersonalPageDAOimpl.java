package epam.ph.sg.dao.impl;

/**
 * @author Paul Michael T.
 */
import org.springframework.jdbc.core.JdbcTemplate;

import epam.ph.sg.dao.PersonalPageDAO;

public class PersonalPageDAOimpl implements PersonalPageDAO {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
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
}
