package epam.ph.sg.models.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import epam.ph.sg.models.LoginModelDAO;
import epam.ph.sg.models.User;


public class LoginModelDAOImpl implements LoginModelDAO{
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

	

	public List<User> getFromDB(String sql) {
		List <User> userList = jdbcTemplate.query(sql, new  RowMapper<User>(){

			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPass(rs.getString(3));
				return user;
			}
			});
		
		return userList;
	}
}
