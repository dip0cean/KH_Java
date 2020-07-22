package mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/plus.do")
public class PlusServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// a 와 b 는 파라미터의 값을 더해서 JSP에 c 라는 이름으로 전달
		int a = Integer.parseInt(req.getParameter("a"));
		int b = Integer.parseInt(req.getParameter("b"));
		int c = a + b;
		req.setAttribute("plus", c);
		
		// 포워드 코드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/plus.jsp");
		dispatcher.forward(req, resp);
	}
}
