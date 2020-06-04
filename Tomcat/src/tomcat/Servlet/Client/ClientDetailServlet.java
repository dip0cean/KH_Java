package tomcat.Servlet.Client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tomcat.Beans.ClientDAO;
import tomcat.Beans.ClientDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/client/detail.do")
public class ClientDetailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int client_no = Integer.parseInt(req.getParameter("no"));
			ClientDAO cdao = new ClientDAO();
			ClientDTO cdto = cdao.get(client_no);

			resp.setContentType("text/plain; charset=UTF-8");
			if (cdto != null) {
				resp.getWriter().println("검색 결과 > " + "\n");
				resp.getWriter().print(cdto.getClient_no() + "\t");
				resp.getWriter().print(cdto.getClient_id() + "\t");
				resp.getWriter().print(cdto.getClient_auth() + "\t");
				resp.getWriter().print(cdto.getClient_point() + "\t");
				resp.getWriter().print(cdto.getClient_join() + "\n");

			} else {
				resp.getWriter().println("검색 결과가 없습니다.");
			}

		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);
		}

	}
}
