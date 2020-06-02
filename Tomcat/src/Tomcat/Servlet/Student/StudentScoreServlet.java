package Tomcat.Servlet.Student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tomcat.beans.StudentDAO;
import Tomcat.beans.StudentDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/student/score")
public class StudentScoreServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			StudentDAO sdao = new StudentDAO();
			StudentDTO sdto = new StudentDTO();

			sdto.setStudent_score(Integer.parseInt(req.getParameter("score")));

			List<StudentDTO> list = sdao.getScore(sdto);

			resp.setContentType("text/plain; charset=UTF-8");
			for (StudentDTO student : list) {
				resp.getWriter().print(student.getStudent_no() + "\t");
				resp.getWriter().print(student.getStudent_name() + "\t");
				resp.getWriter().print(student.getStudent_score() + "점" + "\t");
				resp.getWriter().print(student.getStudent_create() + "\t");
				resp.getWriter().println();
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
