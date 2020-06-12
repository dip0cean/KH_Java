package homepage.servler.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/member/logout.do")
public class MemberLogoutServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getSession().getAttribute("userinfo") != null) {
			req.getSession().removeAttribute("userinfo");;
			resp.sendRedirect(req.getContextPath());
		}

	}
}
