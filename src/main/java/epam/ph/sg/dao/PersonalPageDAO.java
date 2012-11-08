package epam.ph.sg.dao;

import epam.ph.sg.personal.UserAddInfo;

/**
 * @author Paul Michael T.
 */
public interface PersonalPageDAO {
	/**
	 * Get User Add Info from the DB
	 * 
	 * @param id
	 *            - User ID
	 * 
	 * @return UserAddInfo instance
	 */
	UserAddInfo getUserAddInfo(int id);

	/**
	 * Change user name in the DB
	 * 
	 * @param id
	 *            - User ID
	 * @param name
	 *            - User name
	 */
	void changeName(int id, String name);

	/**
	 * Change user password in the DB
	 * 
	 * @param id
	 *            - User ID
	 * @param pass
	 *            - User password
	 */
	void changePass(int id, String pass);

	/**
	 * Change user email in the DB
	 * 
	 * @param id
	 *            - User ID
	 * @param email
	 *            - User email
	 */
	void changeEmail(int id, String email);

	/**
	 * Change user birthday in the DB
	 * 
	 * @param id
	 *            - User ID
	 * @param birthday
	 *            - User birthday
	 */
	void changeBirthday(int id, String birthday);

	/**
	 * Change user about in the DB
	 * 
	 * @param id
	 *            - User ID
	 * @param about
	 *            - User about
	 */
	void changeAbout(int id, String about);
}
