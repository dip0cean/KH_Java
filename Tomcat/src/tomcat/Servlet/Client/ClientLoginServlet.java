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
@WebServlet(urlPatterns = "/client/login.do")
public class ClientLoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ClientDAO cdao = new ClientDAO();
			ClientDTO cdto = new ClientDTO();
			String client_id = req.getParameter("id");
			String client_pw = req.getParameter("pw");

			cdto.setClient_id(client_id);
			cdto.setClient_pw(client_pw);

			cdto = cdao.login(cdto);
			resp.setContentType("text/plain; charset=UTF-8");

			if (cdto != null) {

				resp.getWriter().println("로그인 성공");
				resp.getWriter().println("ID = " + cdto.getClient_id());
				resp.getWriter().println("등급 = " + cdto.getClient_auth());
				resp.getWriter().println("포인트 = " + cdto.getClient_point());

			} else {

				resp.getWriter().println("로그인 실패");

			}

		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);

		}
	}
}
