package Tomcat.Servlet.Client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tomcat.Beans.ClientDAO;
import Tomcat.Beans.ClientDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/client/list.do")
public class ClientListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String client_id = req.getParameter("search");
			String client_no = req.getParameter("no");

			if (client_id != null) {

				resp.sendRedirect("/Tomcat/client/search.do?search=" + client_id);

				return;

			} else if (client_no != null) {
				resp.sendRedirect("/Tomcat/client/detail.do?no=" + client_no);

			}

			ClientDAO cdao = new ClientDAO();

			List<ClientDTO> list = cdao.getList();

			resp.setContentType("text/plain; charset=UTF-8");

			for (ClientDTO cdto : list) {

				resp.getWriter().print(cdto.getClient_no() + "\t | \t");
				resp.getWriter().print(cdto.getClient_id() + "\t | \t");
				resp.getWriter().print(cdto.getClient_auth() + "\t | \t");
				resp.getWriter().print(cdto.getClient_point() + "\t | \t");
				resp.getWriter().println();

			}

		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);

		}

	}
}
