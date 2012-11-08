package epam.ph.sg.web.filters;

/**
 * @author Paul Michael T.
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		if (session.getAttribute("user") == null) {
			String requestAdr = ((HttpServletRequest) request).getServletPath();
			if (requestAdr.equals("/Login.html")
					|| requestAdr.equals("/Reg.html")
					|| requestAdr.equals("/chLang.html")) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendRedirect("Login.html");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}

}
