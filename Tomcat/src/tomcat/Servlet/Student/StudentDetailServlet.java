package tomcat.Servlet.Student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tomcat.Beans.StudentDAO;
import tomcat.Beans.StudentDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/student/detail.do")
public class StudentDetailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int student_no = Integer.parseInt(req.getParameter("no"));
			StudentDAO sdao = new StudentDAO();
			StudentDTO sdto = sdao.get(student_no);

			resp.setContentType("text/plain; charset=UTF-8");
			if (sdto == null) {
				resp.getWriter().println("검색 결과가 없습니다.");
			} else {
				resp.getWriter().println("검색 결과");
				resp.getWriter().print(sdto.getStudent_no() + "\t");
				resp.getWriter().print(sdto.getStudent_name() + "\t");
				resp.getWriter().print(sdto.getStudent_score() + "\t");
				resp.getWriter().print(sdto.getStudent_create() + "\t");
			}
		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);

		}
	}
}
