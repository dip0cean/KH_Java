package Tomcat.Servlet.Student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tomcat.Beans.StudentDAO;
import Tomcat.Beans.StudentDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/student/list.do")
public class StudentListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 입력 : 검색어 유무에 따라 다른 처리를 수행
			// - score_name 이 있으면 /student/score.do 로 리다이렉트
			// - score_name 이 없으면 계속 진행
			String student_score = req.getParameter("score");
			if (student_score != null) {
				// 상대 경로 > 현재 위치를 기준으로 계산하는 경로
				resp.sendRedirect("score.do?score=" + student_score);
				// 절대 경로 > 절대적인 위치를 나타내는 경로
				// resp.sendRedirect("http://localhost:8080/Tomcat/student/search.do");

				return;
			}

			StudentDAO sdao = new StudentDAO();
			List<StudentDTO> list = sdao.getList();

			resp.setContentType("text/plain; charset=UTF-8");
			for (StudentDTO sdto : list) {
				resp.getWriter().print(sdto.getStudent_no() + "\t");
				resp.getWriter().print(sdto.getStudent_name() + "\t");
				resp.getWriter().print(sdto.getStudent_score() + "점" + "\t");
				resp.getWriter().print(sdto.getStudent_create() + "\t");
				resp.getWriter().println();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
