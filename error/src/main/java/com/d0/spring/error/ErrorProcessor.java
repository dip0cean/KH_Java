package com.d0.spring.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 오류 통합 처리 도구 > 500 error 처리!
/*@ControllerAdvice(basePackages = {"com.d0.spring.controller"})*/
@ControllerAdvice(annotations = Controller.class)
public class ErrorProcessor {

	/*
	 * # AOP(관계 지향 프로그래밍) 의 특징 :
	 * ControllerAdvice 어노테이션을 통해 
	 * Controller 어노테이션이 적용된 클래스 파일들이 
	 * 해당 클래스 파일에서 간섭을 받는다. > 종단 간섭
	 */
	
	/* @ExceptionHandler(ArithmeticException.class) */
	public String handler1() {

		return "error/handler1";
	}

	/* @ExceptionHandler(NumberFormatException.class) */
	public String handler2() {
		
		return "error/handler2";
	}
	
	// 통합 처리 > Exception
	// - Handler 에서는 예외 정보를 확인할 수 있다.
	// - 그 외에도 컨트롤러의 정보를 확인할 수 있다.
	@ExceptionHandler(Exception.class)
	public String handler3(Exception ex) {
		ex.printStackTrace();
		return "error/handler3";
	}
}
