package epam.ph.sg.pp;

/**
 * @author Paul Michael T.
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epam.ph.sg.dao.PersonalPageDAO;

public class PersonalPage {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"springconfig.xml");
	private static PersonalPageDAO dao = (PersonalPageDAO) ctx
			.getBean("personalPageDAOimpl");

	public static void changeName(int id, String name) {
		dao.changeName(id, name);
	}

	public static void changePass(int id, String pass) {
		dao.changePass(id, pass);
	}
}