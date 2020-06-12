package homepage.servler.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dao.MemberDAO;
import homepage.beans.dto.MemberDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/admin/check.do")
public class AdminCheckServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			MemberDTO userinfo = (MemberDTO) req.getSession().getAttribute("userinfo");
			MemberDAO mdao = new MemberDAO();
			MemberDTO mdto = new MemberDTO();
			String go = req.getParameter("go");

			mdto.setMember_id(userinfo.getMember_id());
			mdto.setMember_pw(req.getParameter("member_pw"));

			mdto = mdao.login(mdto);

			if (mdto != null) {
				resp.sendRedirect(go);
			} else {
				resp.sendRedirect("admin_check.jsp?error&go=" + go);
			}

		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);

		}
	}
}
