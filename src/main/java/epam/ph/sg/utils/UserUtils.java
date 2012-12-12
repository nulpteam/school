package epam.ph.sg.utils;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epam.ph.sg.dao.UserDAO;
import epam.ph.sg.models.User;
import epam.ph.sg.models.infection.INFStatistics;
import epam.ph.sg.models.points.PtsStatistics;
import epam.ph.sg.models.reversy.ReversyStatistic;
import epam.ph.sg.models.sb.SBStatistics;
import epam.ph.sg.models.xo.XOStatistics;

public class UserUtils {
	private static Logger log = Logger.getLogger(UserUtils.class);
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"springconfig.xml");
	private static UserDAO userDao = (UserDAO) ctx.getBean("userDaoImpl");

	public static User insert(String name, String pass) {
		userDao.insertUser(name, pass);
		User user = UserUtils.getUser(name, pass);
		if (user != null) {
			XOStatistics.insert(user.getId());
			SBStatistics.insert(user.getId());
			ReversyStatistic.insert(user.getId());
			PtsStatistics.insert(user.getId());
			INFStatistics.insert(user.getId());
			UserAddInfoUtils.insert(user.getId());
		}
		return user;
	}

	public static User getUser(String name, String pass) {
		log.debug("name =" + name + " -----+++++-----+++++ pass =" + pass);
		User user = userDao.getUser(name, pass);
		return user;
	}

	public static boolean isUserExist(String name) {
		if (userDao.getUserByName(name) == null) {
			return false;
		} else
			return true;
	}
}
