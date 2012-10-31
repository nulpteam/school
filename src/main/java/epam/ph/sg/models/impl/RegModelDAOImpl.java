package epam.ph.sg.models.impl;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import epam.ph.sg.models.RegModelDAO;
/**
 * @author roman makovyak
 *
 */

public  class RegModelDAOImpl implements RegModelDAO{
	private static Logger log = Logger.getLogger(RegModelDAOImpl.class);

	private JdbcTemplate jdbcTemplate = null;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public void insert(String sql){
        jdbcTemplate.update(sql);
	}
}
