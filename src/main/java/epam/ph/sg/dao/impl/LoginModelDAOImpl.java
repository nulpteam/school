/**
 * @author Bogdan Gutey
 */
package epam.ph.sg.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import epam.ph.sg.dao.LoginModelDAO;
import epam.ph.sg.models.User;

public class LoginModelDAOImpl implements LoginModelDAO {
	private static Logger log = Logger.getLogger(LoginModelDAOImpl.class);

	private JdbcTemplate jdbcTemplate = null;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	/**
	 * ������ ����� � ����
	 * 
	 * @param sql - sql �����
	 * @return ��������� User, ��� null ���� ���� ���� � ��
	 */
	public User auth(String sql) {
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
		//Логування події
		if(user!=null)
		{
			log.debug(user.getId() + " + " + user.getName() + " + "+ user.getPass());
		}
		else
		{
			log.debug("No such user found in DB");
		}

		return user;
	}
}
