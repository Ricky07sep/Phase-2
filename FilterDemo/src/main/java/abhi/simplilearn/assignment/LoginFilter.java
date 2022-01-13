package abhi.simplilearn.assignment;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	
	public LoginFilter() {}
	
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String userId = req.getParameter("userid");
		if(userId != null) {
			chain.doFilter(req, res);
		}

	}
	
	public void init(FilterConfig fConfig) throws ServletException{
		
	}

}
