package mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/hello.do")
public class HelloServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 프로그래밍 처리 > 비즈니스 로직
		 * - 화면을 표시하는데 있어 필요한 데이터가 있다면 처리 후 첨부
		 * - hello.jsp 와 연결 > 포워딩(forword)
		 */
		
		String hello = "Hello Programing Wolrd!";
		req.setAttribute("hello", hello);
		
		// 포워딩 작업
		RequestDispatcher dispatcher = req.getRequestDispatcher("/hello.jsp");
		dispatcher.forward(req,resp);
	}
}
