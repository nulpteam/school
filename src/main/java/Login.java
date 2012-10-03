//package com.bobik.mvn_jsp.controlers;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.log4j.Logger;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.bobik.mvn_jsp.models.LoginModelDAO;
//import com.bobik.mvn_jsp.models.TestTable;
//import com.bobik.mvn_jsp.models.impl.LoginModelDAOImpl;
//
///**
// * Servlet implementation class Login
// */
//@WebServlet("/Login")
//public class Login extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private static Logger log = Logger.getLogger(Login.class);
//	ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		//System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
//		LoginModelDAO l = (LoginModelDAO)ctx.getBean("ttt");
//		//LoginModelDAOImpl lm = new LoginModelDAOImpl();
//		request.setAttribute("title", l.getTitle());
//		List<TestTable> tt = l.getFromDB("SELECT * FROM test");
//		if(tt!=null){log.info("tt!=null");
//			/*for(TestTable r:tt)
//			{ 
//				log.info("mytest++++++++++++++++++++++++++"+r.getId()+" "+r.getName());
//			}*/
//		}
//		request.setAttribute("list",tt );
//		RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
//		
//		rd.forward(request, response);
//		log.error("forwarded");
//	}
//
//}
