package homepage.servlet.post;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import homepage.beans.dao.PostDAO;
import homepage.beans.dto.MemberDTO;
import homepage.beans.dto.PostDTO;

@SuppressWarnings("serial")
public class PostCreateUploadFileServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			// form 의 multipart/form-data 방식으로 전송되는 게시글 + 파일을 해석 및 저장

			// 1. 해석을 위한 도구를 생성 옵션 설정
			String charset = "UTF-8"; // 인코딩 방식
			int limit = 10 * 1024 * 1024; // 최대 허용 용량
			File baseDir = new File("D:/dip0cean/upload/post_file"); // 저장 위치 선언
			baseDir.mkdirs();

			// 2. 도구 생성을 위한 Factory 객체를 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setDefaultCharset(charset); // 파일 생성 옵션으로 charset 지정
			factory.setRepository(baseDir); // 파일 저장 위치 선언
			factory.setSizeThreshold(limit); // 최대 허용 용량 선언

			// 3. 실제 사용할 도구 생성
			ServletFileUpload utility = new ServletFileUpload(factory);

			// 4. 전송된 데이터들을 불러와서 저장
			Map<String, List<FileItem>> map = utility.parseParameterMap(req);

			// 5. 해석한 데이터에서 필요한 정보들을 추출
			PostDTO pdto = new PostDTO();
			PostDAO pdao = new PostDAO();
			MemberDTO mdto = (MemberDTO) req.getSession().getAttribute("userinfo");
			long post_no = pdao.getSequence();

			pdto.setPost_no(post_no);
			pdto.setPost_id(mdto.getMember_id());
			pdto.setPost_sub(map.get("post_sub").get(0).getString());
			pdto.setPost_title(map.get("post_title").get(0).getString());
			pdto.setPost_content(map.get("post_content").get(0).getString());

			if (map.containsKey("post_no")) {
				pdto.setSuper_no(Integer.parseInt(map.get("post_no").get(0).getString()));
			}

			// 6. 게시글 등록
			pdao.creatPost(pdto);

			// 7. 작성 게시글로 이동
			resp.sendRedirect("post.jsp?post_no=" + post_no);

		} catch (Exception e) {

			e.printStackTrace();
			resp.sendError(500);

		}
	}
}
