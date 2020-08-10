package com.d0.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import lombok.extern.slf4j.Slf4j;

// 특정 대상의 소요시간을 측정하기 위한 간섭 객체 (Aspect bean)
@Aspect
@Slf4j
public class TimerAspect {

	/*
	 * 간섭 메소드 (Advice) - 특수한 경우가 아니라면 메소드의 형태는 정해져 있다. - 누구를 어떤 시점에서 간접할 지 어노테이션으로
	 * 설정한다. -@Before >
	 */

	@Before("target(com.d0.spring.repository.CategoryDAO)") // Weaving
	public void before() {
		log.info("@before 실행");
	}

	@After("target(com.d0.spring.repository.CategoryDAO)")
	public void complete() {
		log.info("@after 실행");
	}

	// 전반적인 간섭을 수행하는 간섭 메소드 > Adivce
	// - 메소드 형태가 지정되어 있다.
	@Around("target(com.d0.spring.repository.CategoryDAO)")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		long start = System.currentTimeMillis(); // @Before 시점
		// 시작 지점
		Object result = joinPoint.proceed();
		
		long finish = System.currentTimeMillis(); // @AfterReturning 시점 > 예외 발생 시 Throwable 로 예외 처리
		
		long time = finish - start;
		log.info("대상 = {}, 소요 시간 = {}ms", joinPoint.getSignature().toLongString(),time);
		
		// 종료 지점
		return result;
	}
	
	// @Around > within
	@Around("within(com.d0.spring.repository.*)")
	public Object around2(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		// 시작 지점
		Object result = joinPoint.proceed();
		
		long finish = System.currentTimeMillis();
		
		long time = finish - start;
		
		log.info("소요 시간 = {}ms", time);
		
		return result;
	}
	
	// @Around > execution
	@Around("execution(public * com.d0.spring.repository.*.*(..))")
	public Object around3(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Object result = joinPoint.proceed();
		log.info("Around execution 의 대상 = {}",joinPoint.getSignature().toLongString());
		return result;
	}
}
