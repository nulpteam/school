package epam.ph.sg.web.filters;

/**
 * @author Paul Michael T.
 */
import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epam.ph.sg.controllers.HomeController;
import epam.ph.sg.models.LangModel;
import epam.ph.sg.models.lang.LangSelector;

public class LanguageFilter implements Filter {
	private static Logger log = Logger.getLogger(HomeController.class);
	private ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"springconfig.xml");
	private LangModel langBean = (LangModel) ctx.getBean("defaultLang");

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		if (session.getAttribute("lang") == null) {
			session.setAttribute("lang", langBean.lang());
			log.debug("lang arttribute added to session with value="
					+ langBean.lang());
		}
		if (session.getAttribute("langPack") == null){
			Map<String, String> langPack = new LangSelector().getRb((String) session.getAttribute("lang"));
			session.setAttribute("langPack", langPack);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
