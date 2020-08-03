package com.d0.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor_01 extends HandlerInterceptorAdapter {

	// 인터셉터 간섭 시점 1 : 처리 전 > PreHandle
	// - 필터와 매우 유사하게 사용됨
	// - 404 에러 상황에서는 실행되지 않음. > context-servlet.xml 안까지 들어와야 interceptor 가 실행
	// - request : 사용자는 무엇을 요청했는가 ?
	// - response : 사용자에게 첨부할 정보가 있는가 ?
	// - handler : 이 요청은 누가 처리하기로 했는가 ?
	// - return true > 통과 / return false > 차단
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("Interceptor Test!");
		return true;
	}

	// 인터셉터 간섭 시점 2 : 처리 후 > PostHandle
	// - 컨트롤러의 처리 직후 시점을 간섭하는 메소드
	// - request : 사용자는 무엇을 요청했는가 ?
	// - response : 사용자에게 첨부할 정보가 있는가 ?
	// - handler : 이 요청은 누가 처리하기로 했는가 ?
	// - ModelAndView : 모델 + 뷰 정보를 확인
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("PostHandel");
		System.out.println(handler);
		System.out.println(modelAndView);
	}

	// 인터셉터 간섭 시점 3 : 사용자에게 출력되기 직전 > afterCompletion : 오류 확인에 특화
	// - request : 사용자는 무엇을 요청했는가 ?
	// - response : 사용자에게 첨부할 정보가 있는가 ?
	// - handler : 이 요청은 누가 처리하기로 했는가 ?
	// - exception : 만들 때 발생한 예외가 있니?
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterComplection");
		System.out.println(ex);
	}

}
