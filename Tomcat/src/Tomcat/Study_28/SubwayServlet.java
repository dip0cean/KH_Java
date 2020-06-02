package Tomcat.Study_28;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/subway.it")
public class SubwayServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 현재 년도
		Calendar now = Calendar.getInstance();
		int thisYear = now.get(Calendar.YEAR);

		// 이용자 출생년도
		int user = Integer.parseInt(req.getParameter("birth"));
		user = user / 10000;
		// 나이 계산

		int result = thisYear - user + 1;

		// 거르기
		String message;
		if (result < 8 || result >= 64) {
			message = "무료";
		} else if (result < 14) {
			message = "450원";
		} else if (result < 20) {
			message = "720원";
		} else {
			message = "1250원";
		}
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("고객님의 지하철 요금은 " + message + "입니다.");

	}
}
