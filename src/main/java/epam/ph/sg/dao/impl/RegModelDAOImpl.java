package epam.ph.sg.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import epam.ph.sg.dao.RegModelDAO;
/**
 * @author roman makovyak
 *
 */

public  class RegModelDAOImpl implements RegModelDAO{

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
