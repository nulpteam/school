package epam.ph.sg.dao;

import epam.ph.sg.models.User;

public interface UserDAO {

	/**
	 * Get User from the DB
	 * 
	 * @param name
	 *            - User name
	 * 
	 * @return User instance
	 */
	User getUserByName(String name);
}
