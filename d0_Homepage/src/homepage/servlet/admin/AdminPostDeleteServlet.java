package homepage.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dao.PostDAO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/admin/post_delete.do")
public class AdminPostDeleteServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String[] parameter = req.getParameterValues("post_no");
			PostDAO pdao = new PostDAO();

			for (int i = 0; i < parameter.length; i++) {
				System.out.println(parameter[i]);
				long post_no = Long.parseLong(parameter[i]);

				pdao.deletePost(post_no);

			}
			
			resp.sendRedirect(req.getParameter("goto"));

		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);
			
		}
	}
}
