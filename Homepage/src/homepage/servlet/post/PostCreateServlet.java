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
@WebServlet(urlPatterns = "/post/create.do")
public class PostCreateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			PostDTO pdto = new PostDTO();
			PostDAO pdao = new PostDAO();

			pdto.setPost_id(req.getParameter("post_id"));
			pdto.setPost_sub(req.getParameter("post_sub"));
			pdto.setPost_title(req.getParameter("post_title"));
			pdto.setPost_content(req.getParameter("post_content"));

			pdao.creatPost(pdto);
			
			resp.sendRedirect("create_result.jsp");
			
		} catch (Exception e) {
		
			e.printStackTrace();
			resp.sendError(500);
			
		}
	}
}
