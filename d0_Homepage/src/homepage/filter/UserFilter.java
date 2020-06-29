package homepage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dto.MemberDTO;

//@WebFilter(urlPatterns = "/user/*")
public class UserFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		MemberDTO mdto = (MemberDTO) req.getSession().getAttribute("userinfo");
		
		boolean isMember = mdto != null;
		
		if(isMember) {
			resp.sendRedirect(req.getContextPath()); 
		} else {
			chain.doFilter(request, response);
		}
	}
}
