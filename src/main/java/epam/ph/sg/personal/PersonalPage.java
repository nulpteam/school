package epam.ph.sg.personal;

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

	public static void insert(int id) {
		dao.insert(id);
	}

	public static UserAddInfo getUserAddIngo(int id) {
		return dao.getUserAddInfo(id);
	}

	public static void changeName(int id, String name) {
		dao.changeName(id, name);
	}

	public static void changePass(int id, String pass) {
		dao.changePass(id, pass);
	}

	public static void changeEmail(int id, String email) {
		dao.changeEmail(id, email);
	}

	public static void changeBirthday(int id, String birthday) {
		dao.changeBirthday(id, birthday);
	}

	public static void changeAbout(int id, String about) {
		dao.changeAbout(id, about);
	}
}