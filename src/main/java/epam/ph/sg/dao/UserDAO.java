package epam.ph.sg.dao;

import epam.ph.sg.models.User;

public interface UserDAO {

	/**
	 * Insert User to DB
	 * 
	 * @param name
	 *            - User name
	 * @param pass
	 *            - User password
	 */
	void insertUser(String name, String pass);

	/**
	 * Get User from the DB
	 * 
	 * @param name
	 *            - User name
	 * 
	 * @return User instance
	 */
	User getUserByName(String name);

	/**
	 * Get User from the DB
	 * 
	 * @param name
	 *            - User name
	 * @param pass
	 *            - User password
	 * 
	 * @return User instance
	 */
	User getUser(String name, String pass);
}
