package Tomcat.Servlet.Student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tomcat.beans.StudentDAO;
import Tomcat.beans.StudentDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/student/regist.do")
public class StudentRegistServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
//		입력과 처리
			StudentDAO sdao = new StudentDAO();
			StudentDTO sdto = new StudentDTO();
			sdto.setStudent_name(req.getParameter("student_name"));
			sdto.setStudent_score(Integer.parseInt(req.getParameter("student_score")));
			sdao.regist(sdto);

//		출력
			resp.setContentType("text/plain; charset=UTF-8");
			resp.getWriter().println("학생 등록이 완료되었습니다.");
		} catch (Exception e) {
			// 오류가 발생할 경우 > 사용자에게 오류가 났음을 알려주고 서버에 기록을 남긴다.
			resp.sendError(500);
			e.printStackTrace(); // 서버에 오류 데이터 기록
		}
	}
}
