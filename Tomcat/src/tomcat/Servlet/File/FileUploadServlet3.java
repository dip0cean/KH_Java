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
@WebServlet(urlPatterns = "/filemanager/upload3.do")
public class FileUploadServlet3 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 파일 저장 경로
			File baseDir = new File("D:/dip0cean/upload");
			// 폴더가 없을 경우 생성
			baseDir.mkdirs();
			
			int limit = 10 * 1024 * 1024; // 10mb 용량 제한
			String charset = "UTF-8";
			
			// 공장 조건 제약
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setDefaultCharset(charset);
			factory.setRepository(baseDir);
			factory.setSizeThreshold(limit);
			
			ServletFileUpload utility = new ServletFileUpload(factory);
			
			Map<String, List<FileItem>> map = utility.parseParameterMap(req);
			
			List<FileItem> list = map.get("file");
			
			for(FileItem item : list) {
				File target = new File(baseDir, item.getName());
				item.write(target);
			}
			
			
		} catch (Exception e) {
			
		}
	}

}
