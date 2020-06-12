package hompage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 필터의 목적은 모든 요청을 UTF-8 로 복원하는 것이다.
// 감시해야 할 주소 > 모든 주소

@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 사용자가 보낸 데이터를 UTF-8 로 복원
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// chain 은 사용자의 요청과 관련된 모든 도구들의 연결 정보
		// - doFilter 명령은 통과해주겠다는 의미이다.
		// - request : 원래의 요청 정보
		// - response : 원래의 응답 정보
		chain.doFilter(request, response);
	}
}
