package db;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.dao.PostDAO;
import bean.dto.PostDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/postcontent.do")
public class PostContentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			PostDAO pdao = new PostDAO();
			
			if (req.getParameter("post_no") != null) {
				long post_no = Long.parseLong(req.getParameter("post_no"));
				PostDTO pdto = pdao.getPost(post_no);
				List<PostDTO> post = new ArrayList<PostDTO>();
				post.add(pdto);
				req.setAttribute("post", post);

			} else {
				List<PostDTO> list = pdao.fullPost(1, 999);
				req.setAttribute("post", list);
			}


			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/postcontent.jsp");
			dispatcher.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}

}
