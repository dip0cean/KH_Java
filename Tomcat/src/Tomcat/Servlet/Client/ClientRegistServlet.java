package Tomcat.Servlet.Client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tomcat.Beans.ClientDAO;
import Tomcat.Beans.ClientDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/client/regist.do")
public class ClientRegistServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ClientDTO cdto = new ClientDTO();
			ClientDAO cdao = new ClientDAO();

			cdto.setClient_id(req.getParameter("id"));
			cdto.setClient_pw(req.getParameter("pw"));

			cdao.regist(cdto);
			resp.setContentType("text/plain; charset=UTF-8");
			resp.getWriter().println("회원가입이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
