package Tomcat.Study_28;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/score")
public class ScoreServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터로 점수 입력 받기
		int kor = Integer.parseInt(req.getParameter("kor"));
		int eng = Integer.parseInt(req.getParameter("eng"));
		int math = Integer.parseInt(req.getParameter("math"));
		double a = (kor + eng + math) / 3.0;

		// 파리미터로 받은 점수 평균 연산
		double result = Math.round(a * 100) * 0.01;

		// UTF-8 로 변경
		resp.setCharacterEncoding("UTF-8");

		// 출력
		resp.getWriter().println("평균 점수 : " + result + "점");
	}
}
