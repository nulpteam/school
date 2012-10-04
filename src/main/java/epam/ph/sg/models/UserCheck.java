package epam.ph.sg.models;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserCheck {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"springconfig.xml");

	public static User check(String name, String pass) {
		LoginModelDAO loginDAO = (LoginModelDAO) ctx.getBean("ttt");
		User user = loginDAO.auth("select id, name, pass from user" +
				" where name='"+name+"' and pass='"+pass+"'");

		return user;
	}
}
