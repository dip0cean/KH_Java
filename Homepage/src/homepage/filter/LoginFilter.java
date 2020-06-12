package homepage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//	규칙
//	1. 주소는 / 로 시작
//	2. 필요하다면 *를 사용할 수 있다.
//		- /* 이라고 하면 프로젝트 전체
//		- /tag/table/* 해당폴더 전체
//	3. 특정 확장자만 감시할 수 있다.
//		-*.jsp > 모든 jsp 파일
//		-*.do > 모든 do 파일
//		- / 사용 금지
//	* 2 / 3번 같이 사용 금지
@WebFilter(urlPatterns = "/member/*")
public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		
		if(req.getSession().getAttribute("userinfo") != null) {
			chain.doFilter(request, response);			
		} else {
			resp.sendRedirect(req.getContextPath() + "/user/login.jsp");
		}
	}
}
