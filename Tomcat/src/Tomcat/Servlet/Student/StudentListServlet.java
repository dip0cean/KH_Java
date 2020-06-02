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
