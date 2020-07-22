package db;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.dao.MemberDAO;
import bean.dto.MemberDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/memberlist.do")
public class MemberListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			MemberDAO mdao = new MemberDAO();
			List<MemberDTO> list = mdao.search();

			req.setAttribute("list", list);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/memberlist.jsp");
			dispatcher.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
