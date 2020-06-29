package homepage.servlet.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homepage.beans.dao.ReplyDAO;
import homepage.beans.dto.ReplyDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/post/delete_reply.do")
public class ReplyDeleteServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			ReplyDTO rdto = new ReplyDTO();
			ReplyDAO rdao = new ReplyDAO();

			long reply_no = Long.parseLong(req.getParameter("reply_no"));
			long post_no = Long.parseLong(req.getParameter("post_no"));

			rdto.setReply_no(reply_no);
			rdto.setPost_no(post_no);

			rdao.deleteReply(rdto);
			
			resp.sendRedirect("post.jsp?post_no=" + post_no);
			
		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);
			
		}

	}
}
