package homepage.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dao.MemberDAO;
import homepage.beans.dto.MemberDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/admin/user_edit.do")
public class AdminUserEditServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			req.setCharacterEncoding("UTF-8");
			
			MemberDAO mdao = new MemberDAO();
			MemberDTO mdto = new MemberDTO();

			mdto.setMember_id(req.getParameter("member_id"));
			mdto.setMember_pw(req.getParameter("member_pw"));
			mdto.setMember_nick(req.getParameter("member_nick"));
			mdto.setMember_post(req.getParameter("member_post"));
			mdto.setMember_base_addr(req.getParameter("member_base_addr"));
			mdto.setMember_extra_addr(req.getParameter("member_extra_addr"));
			mdto.setMember_birth(req.getParameter("member_birth"));
			mdto.setMember_phone(req.getParameter("member_phone"));
			mdto.setMember_intro(req.getParameter("member_intro"));
			mdto.setAccess_auth(req.getParameter("access_auth"));
			mdto.setAccess_join(req.getParameter("access_join"));
			mdto.setAccess_login(req.getParameter("access_login"));
			mdao.userEdit(mdto);
			resp.sendRedirect("manage_user.jsp?type=MEMBER_ID&keyword=" + req.getSession().getAttribute("keyword"));

		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);
		}

	}
}
