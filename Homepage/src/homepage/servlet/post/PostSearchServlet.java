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
@WebServlet(urlPatterns = "/post/search.do")
public class PostSearchServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PostDAO pdao = new PostDAO();
		PostDTO pdto = new PostDTO();
	}
}
