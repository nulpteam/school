package epam.ph.sg.models;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserCheck {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"springconfig.xml");

	/**
	 * Перевіряє чи є користувач з таким іменем і паролем в БД
	 * 
	 * @param name - ім'я користувача
	 * @param pass - пароль користувача
	 * @return Екземпляр User, або null якщо його нема в БД
	 */
	public static User check(String name, String pass) {
		LoginModelDAO loginDAO = (LoginModelDAO) ctx.getBean("loginModelDAOImpl");
		User user = loginDAO.auth("select id, name, pass from users" +
				" where name='"+name+"' and pass='"+pass+"'");

		return user;
	}
}
