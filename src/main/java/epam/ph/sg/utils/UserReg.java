package epam.ph.sg.utils;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epam.ph.sg.dao.RegModelDAO;
import epam.ph.sg.models.User;
import epam.ph.sg.models.infection.INFStatistics;
import epam.ph.sg.models.points.PtsStatistics;
import epam.ph.sg.models.sb.SBStatistics;
import epam.ph.sg.models.xo.XOStatistics;

/**
 * @author roman makovyak
 * 
 */

public class UserReg {
	private static Logger log = Logger.getLogger(UserReg.class);
	public static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"springconfig.xml");

	public static void register(String name, String pass) {
		RegModelDAO regDAO = (RegModelDAO) ctx.getBean("regModelDAOImpl");
		regDAO.insert("INSERT INTO users (name,pass) VALUES('" + name + "','"
				+ pass + "')");
		User user = UserCheck.check(name, pass);
		XOStatistics.insert(user.getId());
		SBStatistics.insert(user.getId());
		PtsStatistics.insert(user.getId());
		INFStatistics.insert(user.getId());
		UserAddInfoUtils.insert(user.getId());
	}
}
