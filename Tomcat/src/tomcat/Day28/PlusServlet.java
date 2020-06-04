package tomcat.Day28;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/plus")
public class PlusServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 숫자 2개를 출력 받아서 합계를 출력
		// int a = 사용자가 보낸 a 의 값;
		// int b = 사용자가 보낸 b 의 값;

		// int a = 요청 정보에 포함된 a 의 값(파라미터);
		// int b = 요청 정보에 포함된 b 의 값(Parameter);

		// 요청 정보에서 파라미터를 읽어올 수 있다.
		// (주의) 파라미터는 읽어오면 무조건 String 형태이다.

		// 주소에서 ? 뒷부분에 있는 a=xxx 부분을 읽어와서 숫자로 바꿔 저장!
		int a = Integer.parseInt(req.getParameter("a"));

		// 주소에서 ? 뒷부분에 있는 b=xxx 부분을 읽어와서 숫자로 바꿔 저장!
		int b = Integer.parseInt(req.getParameter("b"));

		// URL > http://localhost.8080/Tomcat/plus?a=10&b=20
		// & AND 연산자를 통해 값을 입력해야 함.
		int c = a + b;

		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("합계 = " + c);
	}
}
