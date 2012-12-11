package epam.ph.sg.utils;

/**
 * @author Talash Pavlo
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epam.ph.sg.dao.UserAddInfoDAO;
import epam.ph.sg.models.UserAddInfo;

public class UserAddInfoUtils {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"springconfig.xml");
	private static UserAddInfoDAO dao = (UserAddInfoDAO) ctx
			.getBean("personalPageDAOimpl");

	public static void insert(int id) {
		dao.insert(id);
	}

	public static UserAddInfo getUserAddIngo(int id) {
		return dao.getUserAddInfo(id);
	}

	public static boolean changeName(int id, String name) {
		if (UserCheck.isUserExist(name) == true) {
			return false;
		} else {
			dao.changeName(id, name);
			return true;
		}
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
		dao.changeAbout(id, textSplitter(about));
	}

	/**
	 * Split text to add it to the DB
	 * 
	 * @param text
	 *            - text to split
	 * @return prepared text
	 */
	private static String textSplitter(String text) {
		int wordlenght = 20;
		String preparedText = "";
		String[] words = text.split(" ");
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > wordlenght) {
				String newWord = words[i].substring(0, wordlenght);
				newWord = newWord.concat("...");
				preparedText += " " + newWord;
			} else {
				preparedText += " " + words[i];
			}
		}
		return preparedText.trim();
	}
}