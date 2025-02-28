package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/StudentProfile.jsp")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request2 = (HttpServletRequest)request;
		HttpSession session =request2.getSession(); 
		if(session.getAttribute("loggedInId") != null) {
			chain.doFilter(request, response);
		}
		else {
			((HttpServletResponse)response).sendRedirect("Login.jsp");
		}
			 
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
