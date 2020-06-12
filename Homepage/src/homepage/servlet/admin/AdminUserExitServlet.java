package homepage.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dao.MemberDAO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/admin/user_exit.do")
public class AdminUserExitServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			req.setCharacterEncoding("UTF-8");
			
			String member_id = req.getParameter("member_id");
			String access_auth = req.getParameter("access_auth");

			MemberDAO mdao = new MemberDAO();
			mdao.userExit(member_id, access_auth);
			
			resp.sendRedirect("manage_user.jsp?type=MEMBER_ID&keyword=" + req.getSession().getAttribute("keyword") + "&succ");

		} catch (Exception e) {
			
			e.printStackTrace();
			resp.sendError(500);
		}

	}
}
