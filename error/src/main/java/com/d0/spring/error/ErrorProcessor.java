package com.d0.spring.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

// 오류 통합 처리 도구
/*@ControllerAdvice(basePackages = {"com.d0.spring.controller"})*/
@ControllerAdvice(annotations = Controller.class)
public class ErrorProcessor {

}
