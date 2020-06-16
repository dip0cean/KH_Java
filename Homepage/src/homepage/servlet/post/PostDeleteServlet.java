package homepage.servlet.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dao.PostDAO;
import homepage.beans.dto.PostDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/post/delete.do")
public class PostDeleteServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			PostDAO pdao = new PostDAO();
			PostDTO pdto = new PostDTO();

			pdto.setPost_no(Long.parseLong(req.getParameter("post_no")));

			pdao.deletePost(pdto.getPost_no());
			
			resp.sendRedirect("board.jsp");
			
		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);
			
		}
	}
}
