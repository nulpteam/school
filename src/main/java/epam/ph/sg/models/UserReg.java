package epam.ph.sg.models;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	}
}
