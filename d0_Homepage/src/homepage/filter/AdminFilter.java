package homepage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dao.MemberDAO;
import homepage.beans.dto.MemberDTO;

//@WebFilter(urlPatterns = "/admin/*")
public class AdminFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		try {

		MemberDTO mdto = (MemberDTO) req.getSession().getAttribute("userinfo");
		MemberDAO mdao = new MemberDAO();
		
			mdto = mdao.get(mdto.getMember_id());
		
		if (mdto == null) {

			resp.sendRedirect(req.getContextPath() + "/user/login.jsp");

		} else if (!mdto.getAccess_auth().equals("운영자")) {

			resp.sendError(403);

		} else {

			chain.doFilter(request, response);

		}

		} catch (Exception e) {
			
			e.printStackTrace();
			resp.sendError(500);
			
		}
	}
}
