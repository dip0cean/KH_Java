package homepage.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dao.MemberDAO;
import homepage.beans.dto.MemberDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/member/exit.do")
public class MemberExitServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			String exit_user = req.getParameter("exit");
			MemberDAO mdao = new MemberDAO();
			MemberDTO mdto = (MemberDTO) req.getSession().getAttribute("userinfo");

			boolean result = mdao.exit(mdto, exit_user);

			if (!result) {

				resp.sendRedirect("exit.jsp?error");

			} else {

				resp.sendRedirect("exit_result.jsp");
				req.getSession().invalidate();

			}

		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);
		}

	}
}
