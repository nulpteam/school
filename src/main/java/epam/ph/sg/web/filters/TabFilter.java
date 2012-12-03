package epam.ph.sg.web.filters;

/**
 * @author Talash Pavlo
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TabFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		String requestAdr = ((HttpServletRequest) request).getServletPath();
		session.setAttribute("tabCurrentPos", requestAdr.substring(1));
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
