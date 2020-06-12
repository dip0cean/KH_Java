package tomcat.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 필터는 특정 대상에게 차단 또는 허용을 결정하여 실행할 수 있도록 설정하는 도구(거름망)
// -	필터를 설치하는 손간 대상에 대한 모든 요청은 차단된다.
// -	urlPatterns 에 감시할 대상의 주소를 적는다.
// -	/* 는 모든 주소를 의미한다.
// -	대상이 여러개면 배열처럼 중괄호를 이용한다.
// - 	필터에서 중요한 것은 어떠한 경우에 통괴/차단을 실행할지 결정하는 것.
// - 	차단 명령은 없지만, redirect를 이용해 다른페이지로 튕겨내는 것이 가능하다.
// -	통과 명령은 chain.doFilter(request, response);
@WebFilter(urlPatterns = "/*")
public class TestFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("필터 실행");
		chain.doFilter(request, response);
	}
}
