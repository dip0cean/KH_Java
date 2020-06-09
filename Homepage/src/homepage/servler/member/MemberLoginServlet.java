package homepage.servler.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dao.MemberDAO;
import homepage.beans.dto.MemberDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/member/login.do")
public class MemberLoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberDAO mdao = new MemberDAO();
			MemberDTO mdto = new MemberDTO();

			mdto.setMember_id(req.getParameter("member_id"));
			mdto.setMember_pw(req.getParameter("member_pw"));

			boolean result = mdao.login(mdto);

			if (result) {
				resp.sendRedirect("login_access.jsp");
			} else if (!result) {
				resp.sendRedirect("login_fail.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

}
