package homepage.servler.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dao.MemberDAO;
import homepage.beans.dto.MemberDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/user/find_id.do")
public class MemberFindIdServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			MemberDAO mdao = new MemberDAO();
			MemberDTO mdto = new MemberDTO();
			resp.setCharacterEncoding("UTF-8");

			mdto.setMember_phone(req.getParameter("member_phone"));
			mdto.setMember_birth(req.getParameter("member_birth"));

			mdto = mdao.findId(mdto);

			if (mdto == null) {
				resp.sendRedirect("find_id.jsp?error");
			} else {
				String member_id = mdto.getMember_id();
				req.getSession().setAttribute("find_id", member_id);
				resp.sendRedirect("find_id_result.jsp");
			}
		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);

		}
	}
}
