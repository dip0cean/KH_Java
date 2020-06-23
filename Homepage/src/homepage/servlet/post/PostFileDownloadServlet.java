package homepage.servlet.post;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import homepage.beans.dao.PostFileDAO;
import homepage.beans.dto.PostFileDTO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/post/download.do")
public class PostFileDownloadServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// 목표 > 사용자가 원하는 파일을 다운로드 할 수 있도록 전송
			// 1. 사용자 요청 정보에서 post_file_no 를 불러온다.
			long post_file_no = Long.parseLong(req.getParameter("post_file_no"));

			// 2. DB 조회
			PostFileDAO pfdao = new PostFileDAO();
			PostFileDTO pfdto = pfdao.get(post_file_no);

			// 3. 만약 대상 파일이 없으면 사용자에게 오류를 송출
			if (pfdto == null) {
				resp.sendError(404);
				return; // 중지
			}

			// 4. 다운로드를 위해 사용자에게 필요한 정보들을 알려주도록 설정(header 설정)
			// - Content-Type : 사용자(브라우저) 에게 알려주는 데이터의 형식
			// - Content-Disposition : 사용자 화면에 표시되는 다운로드 파일 이름
			// - Content-Length : 데이터의 크기 > 사용자 화면에 다운로드 진행 상황 표시가 가능
			resp.setHeader("Content-Type", "application/octet-stream; charset=UTF-8");
			resp.setHeader("Content-Disposition", "attachment; filename=" + pfdto.getPost_file_name());
			resp.setHeader("Content-Length", String.valueOf(pfdto.getPost_file_size()));
			
			// 5. 실제 데이터 사용자에게 전송
			File target = new File("D:/dip0cean/upload/post_file", String.valueOf(pfdto.getPost_file_no()));
			byte[] data = FileUtils.readFileToByteArray(target);
			
			resp.getOutputStream().write(data); // 사용자에게 전송
			
		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);

		}
	}
}
