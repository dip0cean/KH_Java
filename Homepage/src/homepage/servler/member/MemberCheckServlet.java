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
@WebServlet(urlPatterns = "/member/check.do")
public class MemberCheckServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			MemberDTO userinfo = (MemberDTO) req.getSession().getAttribute("userinfo");
			MemberDAO mdao = new MemberDAO();
			MemberDTO mdto = new MemberDTO();

			mdto.setMember_id(userinfo.getMember_id());
			mdto.setMember_pw(req.getParameter("member_pw"));

			mdto = mdao.login(mdto);
			
			if (mdto != null) {
				resp.sendRedirect("mypage_edit.jsp");
			} else {
				resp.sendRedirect("check.jsp?error");
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
			resp.sendError(500);
			
		}

	}
}
