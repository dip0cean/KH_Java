package tomcat.Servlet.File;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/filemanager/upload.do")
public class FileUploadServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		파일 업로드를 위해서 먼저 정해두어야 할 사항
//		1. 파일이 저장될 위치 (baseDir)
//		2. 파일의 최대 허용 용량(limit)
		try {
			File baseDir = new File("D:/dip0cean/upload"); // 파일이 저장될 폴더 객체
			baseDir.mkdirs(); // 폴더가 없다면 생성
			
			int limit = 10 * 1024 * 1024; // 10MB
			
			// 생성을 도와주는 도구 생성 (factory)
			DiskFileItemFactory factory = new DiskFileItemFactory(limit, baseDir);
			
			ServletFileUpload utility = new ServletFileUpload(factory);
			
			// utility 를 이용하여 multipart/form-data 요청을 해석
			// FileItem == 분석된 요청 데이터 1개를 의미
			List<FileItem> list = utility.parseRequest(req);
			for(FileItem item : list) {
				System.out.println(item.getFieldName());
				System.out.println(item.isFormField());
				if(item.isFormField()) {
					System.out.println("파일이 아닙니다");
					System.out.println(item.getString());
				} else {
					System.out.println("파일입니다.");
					System.out.println(item.getName());
					System.out.println(item.getSize());
					System.out.println(item.getContentType());
					
					// 저장 코드 > item.write(대상파일객체)
					File target = new File(baseDir, item.getName());
					item.write(target);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
