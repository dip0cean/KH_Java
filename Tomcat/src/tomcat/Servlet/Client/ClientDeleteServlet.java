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
@WebServlet(urlPatterns = "/client/delete.do")
public class ClientDeleteServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ClientDTO cdto = new ClientDTO();
			ClientDAO cdao = new ClientDAO();

			cdto.setClient_id(req.getParameter("id"));
			cdto.setClient_pw(req.getParameter("pw"));

			resp.setContentType("text/plain; charset=UTF-8");
			if (cdao.login(cdto) != null) {
				cdao.delete(cdao.login(cdto));
				resp.getWriter().println("탈퇴에 성공했습니다.");
			} else {
				resp.getWriter().println("정보를 확인할 수 없습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
