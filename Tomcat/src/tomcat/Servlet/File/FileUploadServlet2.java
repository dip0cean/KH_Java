package tomcat.Servlet.File;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/filemanager/upload2.do")
public class FileUploadServlet2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
//		목표 > 원래 우리가 사용하던 것 처럼 "이름"으로 접근하여 데이터를 추출
			File baseDir = new File("D:/dip0cean/upload");
			baseDir.mkdirs();

			int limit = 10 * 1024 * 1024; // 용량 제한
			String charset = "UTF-8";

//		생성
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(baseDir);
			factory.setSizeThreshold(limit);
			factory.setDefaultCharset(charset);

			ServletFileUpload utility = new ServletFileUpload(factory);

			Map<String, List<FileItem>> map = utility.parseParameterMap(req);

//		파일은 multiple 옵션이 있을 대와 없을 때 전송 형태가 달라진다.
//		- 둘 다 여러개라고 생각하고 반복문으로 처리하는 것이 가장 좋다.

			System.out.println(map.toString());

//		파라미터는 일반적으로 한개만 넘어온다.		
			String uploader = map.get("uploader").get(0).getString();
			System.out.println("uploader = " + uploader);

			List<FileItem> list = map.get("f");

			if (!list.isEmpty()) {
				for (FileItem item : list) {
					// 파일 크기가 0이면 저장을 안한다.
					System.out.println(item.getName());
					if (item.getSize() > 0) {
						File target = new File(baseDir, item.getName());
						item.write(target);
					}
				}
			}
		} catch (Exception e) {

		}
	}
}
