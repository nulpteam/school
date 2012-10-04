package epam.ph.sg.models.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import epam.ph.sg.models.LoginModelDAO;
import epam.ph.sg.models.User;

public class LoginModelDAOImpl implements LoginModelDAO {
	private static Logger log = Logger.getLogger(LoginModelDAOImpl.class);
	private static Locale locale = new Locale("uk", "UA");
	private static ResourceBundle rb = ResourceBundle.getBundle("lang", locale);

	private JdbcTemplate jdbcTemplate = null;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getTitle() {
		log.info("Title is called");
		return rb.getString("Who_are_you?");
	}

	/*
	 * public User auth(String sql) { List <User> userList =
	 * jdbcTemplate.query(sql, new RowMapper<User>(){
	 * 
	 * public User mapRow(ResultSet rs, int arg1) throws SQLException { User
	 * user = new User(); user.setId(rs.getString(1));
	 * user.setName(rs.getString(2)); user.setPass(rs.getString(3)); return
	 * user; } });
	 * 
	 * return userList; }
	 */
	public User auth(String sql) {
		User user = jdbcTemplate.query(sql, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				User user = null;
				if (rs.next()) {
					user = new User();
					user.setId(rs.getString(1));
					user.setName(rs.getString(2));
					user.setPass(rs.getString(3));
					
				}
				return user;

			}
		});
		if(user!=null)
		log.debug(user.getId() + " + " + user.getName() + " + "
				+ user.getPass());
		return user;
	}
}
