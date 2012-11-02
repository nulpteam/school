package epam.ph.sg.dao;

/**
 * @author Paul Michael T.
 */
public interface PersonalPageDAO {
	/**
	 * Record new name in the DB
	 * 
	 * @param id
	 *            - User ID
	 * @param name
	 *            - New user name
	 */
	void changeName(int id, String name);
	
	/**
	 * Record new password in the DB
	 * 
	 * @param id
	 *            - User ID
	 * @param pass
	 *            - New user password
	 */
	void changePass(int id, String pass);
}
