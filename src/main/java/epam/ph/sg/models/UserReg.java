package epam.ph.sg.models;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epam.ph.sg.xo.XOStatistics;

/**
 * @author roman makovyak
 *
 */

public class UserReg {
	private static Logger log = Logger.getLogger(UserReg.class);
	public static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"springconfig.xml");
	
	public static void register(String name,String pass){
		RegModelDAO regDAO = (RegModelDAO) ctx.getBean("regModelDAOImpl");
		regDAO.insert("INSERT INTO users (name,pass) VALUES('"+name+"','"+pass+"')");
		User user = UserCheck.check(name, pass);
		XOStatistics.insert(user.getId());
	}
}
