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
@WebServlet(urlPatterns = "/member/edit_pw.do")
public class MemberPwEditServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberDAO mdao = new MemberDAO();
			MemberDTO mdto = new MemberDTO();
			MemberDTO userinfo = (MemberDTO) req.getSession().getAttribute("userinfo");
			
			String member_id = userinfo.getMember_id();
			String member_pw = req.getParameter("member_pw");
			
			mdto.setMember_id(member_id);
			mdto.setMember_pw(member_pw);
			
			mdao.editPw(mdto);
			
			resp.sendRedirect("edit_pw_result.jsp");
		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);

		}
	}
}
