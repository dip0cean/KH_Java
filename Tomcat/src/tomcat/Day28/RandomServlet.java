package tomcat.Day28;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/random")
// 상속을 통한 자격 획득(extends HttpServlet)
public class RandomServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Random r = new Random();
		int dice = r.nextInt(6) + 1;

		resp.setCharacterEncoding("UTF-8");

		resp.getWriter().println("주사위 : " + dice);
	}
}
