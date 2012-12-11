/**
 * @author Bogdan Gutey
 */
package epam.ph.sg.utils;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epam.ph.sg.dao.LoginModelDAO;
import epam.ph.sg.dao.UserDAO;
import epam.ph.sg.models.User;

public class UserCheck {
	private static Logger log = Logger.getLogger(UserCheck.class);
	public static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"springconfig.xml");

	/**
	 * Перевіряє чи є користувач з таким іменем і паролем в БД
	 * 
	 * @param name
	 *            - ім'я користувача
	 * @param pass
	 *            - пароль користувача
	 * @return Екземпляр User, або null якщо його нема в БД
	 */
	public static User check(String name, String pass) {
		/*
		 * При введені імені і.або паролю з слешами - SQL-запит вилітає. Тре
		 * доробити екранування від слешів
		 */
		log.debug("name =" + name + " -----+++++-----+++++ pass =" + pass);
		LoginModelDAO loginDAO = (LoginModelDAO) ctx
				.getBean("loginModelDAOImpl");
		User user = loginDAO.auth("select id, name, pass from users"
				+ " where name='" + name + "' and pass='" + pass + "'");

		return user;
	}

	private static UserDAO userDao = (UserDAO) ctx.getBean("userDaoImpl");

	public static boolean isUserExist(String name) {
		if (userDao.getUserByName(name) == null) {
			return false;
		} else
			return true;
	}
}
