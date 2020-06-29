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
@WebServlet(urlPatterns = "/post/create_reply.do")
public class ReplyCreateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ReplyDAO rdao = new ReplyDAO();
			ReplyDTO rdto = new ReplyDTO();

			long reply_no = rdao.getReply_no();

			long post_no = Long.parseLong(req.getParameter("post_no"));
			String member_id = req.getParameter("member_id");

			rdto.setReply_no(reply_no);
			rdto.setPost_no(post_no);
			rdto.setReply_id(member_id);
			rdto.setReply_content(req.getParameter("reply_content"));
			
			rdao.createReply(rdto);
			
			resp.sendRedirect(req.getContextPath() + "/post/post.jsp?post_no=" + post_no);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
