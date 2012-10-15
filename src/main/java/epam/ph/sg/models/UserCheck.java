package epam.ph.sg.models;

import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epam.ph.sg.models.impl.LoginModelDAOImpl;

public class UserCheck {
	private static Logger log = Logger.getLogger(UserCheck.class);
	public static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"springconfig.xml");
	

	/**
	 * Перевіряє чи є користувач з таким іменем і паролем в БД
	 * 
	 * @param name - ім'я користувача
	 * @param pass - пароль користувача
	 * @return Екземпляр User, або null якщо його нема в БД
	 */
	public static User check(String name, String pass) {
		//name = name.replaceAll("\\\\", "");
		//String n = name.replaceAll("\\", "");
		//pass = pass.replaceAll("\\\\", "");
		//String p = pass.replaceAll("\\", "");
		log.debug("name ="+name+" ||| pass ="+pass);
		LoginModelDAO loginDAO = (LoginModelDAO) ctx.getBean("loginModelDAOImpl");
		User user = loginDAO.auth("select id, name, pass from users" +
				" where name='"+name+"' and pass='"+pass+"'");

		return user;
	}
}
