package homepage.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dao.MemberDAO;
import homepage.beans.dto.MemberDTO;

@SuppressWarnings("serial")
//@WebServlet(urlPatterns = "/user/login.do")
public class MemberLoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberDAO mdao = new MemberDAO();
			MemberDTO mdto = new MemberDTO();

			req.setCharacterEncoding("UTF-8");

			mdto.setMember_id(req.getParameter("member_id"));
			mdto.setMember_pw(req.getParameter("member_pw"));

			mdto = mdao.login(mdto);

			if (mdto != null) {
				mdao.updateLoginTime(mdto);

				// 사용자 정보를 "userinfo" 라는 이름으로 세션에 저장
				// - 서블릿에서는 session 이라는 이름의 객체가 없으므로 req에서 꺼내어 사용해야 한다.
				// - JSP 에서는 session 이라는 이름으로 바로 접근이 가능하도록 준비되어 있다.]

				req.getSession().setAttribute("userinfo", mdto);

				resp.sendRedirect(req.getContextPath());

			} else if (mdto == null) {

				resp.sendRedirect("login.jsp?error");
			}

		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);

		}

	}

}
