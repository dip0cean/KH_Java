package tomcat.Day29;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/content")
public class ContentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		// 컨텐츠 유형 설정
		resp.setContentType("test/plain"); // 기본 텍스트
		resp.setContentType("image/gif"); // 이미지
		resp.setContentType("audio/midi"); // 오디오

		// 컨텐츠 유형 + 인코딩
		resp.setContentType("text/plain; charset=UTF-8");
	}
}
