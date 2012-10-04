package epam.ph.sg.models;

import java.util.List;

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
		LoginModelDAO loginDAO = (LoginModelDAO) ctx.getBean("JDBC");
		List<User> userList = loginDAO
				.getFromDB("select id, name, pass from users");
		for (User user : userList) {
			if (user.getName().equals(name)) {
				if (user.getPass().equals(pass)) {
					return user;
				}
			}
		}
		return null;
	}
}
