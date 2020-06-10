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
@WebServlet(urlPatterns = "/member/find_pw.do")
public class MemberFindPwServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			MemberDAO mdao = new MemberDAO();
			MemberDTO mdto = new MemberDTO();
			resp.setCharacterEncoding("UTF-8");

			mdto.setMember_id(req.getParameter("member_id"));
			mdto.setMember_phone(req.getParameter("member_phone"));
			mdto.setMember_birth(req.getParameter("member_birth"));

			mdto = mdao.findPw(mdto);
			
			if (mdto == null) {

				resp.sendRedirect("find_pw.jsp?error");

			} else {

				String member_pw = mdto.getMember_pw();
				req.getSession().setAttribute("find_pw", member_pw);
				resp.sendRedirect("find_pw_result.jsp");

			}

		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);

		}
	}
}
