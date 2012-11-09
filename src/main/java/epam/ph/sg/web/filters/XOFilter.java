package epam.ph.sg.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import epam.ph.sg.xo.XOPlayer;

public class XOFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		XOPlayer xo = (XOPlayer) session.getAttribute("xoGame");
		if (session.getAttribute("xoCurrentPos") == null) {
			session.setAttribute("xoCurrentPos", "Menu");
		}
		String curentPos = (String) session.getAttribute("xoCurrentPos");
		if (curentPos.equals("Game") && xo == null) {
			session.setAttribute("xoCurrentPos", "Menu");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
