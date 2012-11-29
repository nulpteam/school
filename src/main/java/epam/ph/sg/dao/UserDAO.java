package epam.ph.sg.dao;

/**
 * @author Talash Pavlo
 */
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
