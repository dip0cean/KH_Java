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
@WebServlet(urlPatterns = "/client/edit.do")
public class ClientEditServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ClientDTO cdto = new ClientDTO();
			ClientDAO cdao = new ClientDAO();

			String client_id = req.getParameter("id");
			String client_pw = req.getParameter("pw");
			String edit_pw = req.getParameter("edit_pw");

			cdto.setClient_id(client_id);
			cdto.setClient_pw(client_pw);

			boolean login = cdao.login(cdto) != null;
			boolean result = cdao.modify(cdto, edit_pw);

			resp.setContentType("text/plain; charset=UTF-8");

			if (login) {
				resp.getWriter().println("로그인 성공");
				if (result) {
					resp.getWriter().println("정보 수정 완료");
				}
			} else {
				resp.getWriter().println("로그인 실패");
				resp.getWriter().println("아이디 / 비밀번호를 다시 확인해주세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
