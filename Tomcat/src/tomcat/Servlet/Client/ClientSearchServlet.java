package tomcat.Servlet.Client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tomcat.Beans.ClientDAO;
import tomcat.Beans.ClientDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/client/search.do")
public class ClientSearchServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ClientDAO cdao = new ClientDAO();

			String search = req.getParameter("search");

			List<ClientDTO> list = cdao.getSearch(search);

			resp.setContentType("text/plain; charset=UTF-8");

			if (!list.isEmpty()) {

				resp.getWriter().println("검색 결과 : " + list.size() + "개\n");

				for (ClientDTO searchList : list) {

					resp.getWriter().print(searchList.getClient_no() + "\t | \t");
					resp.getWriter().print(searchList.getClient_id() + "\t | \t");
					resp.getWriter().print(searchList.getClient_auth() + "\t | \t");
					resp.getWriter().print(searchList.getClient_point() + "\t | \t");
					resp.getWriter().println();

				}

			} else {

				resp.getWriter().println("검색 결과가 없습니다.");

			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
