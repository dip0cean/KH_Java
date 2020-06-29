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
@WebServlet(urlPatterns = "/post/edit_reply.do")
public class ReplyEditServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			ReplyDAO rdao = new ReplyDAO();
			ReplyDTO rdto = new ReplyDTO();

			rdto.setPost_no(Long.parseLong(req.getParameter("post_no")));
			rdto.setReply_no(Long.parseLong(req.getParameter("reply_no")));
			rdto.setReply_content(req.getParameter("reply_content"));

			rdao.editReply(rdto);
			
			resp.sendRedirect("post.jsp?post_no=" + rdto.getPost_no());
			
		} catch (Exception e) {
			
		}

	}
}
