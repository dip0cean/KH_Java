<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		JSTL(JSP Standard Tag Library)
		- JSP 표준 태그 모음
		- JSP 에서 꼭 필요한 프로그래밍 코드를 태그화 시켜둔 것 > if , for 등
		- 종류
			- core : 필수 프로그래밍 코드
			- format : 형식 변환 코드
			- sql : 데이터 베이스 코드
			- xml : 문서 관련 코드
			- function : 문자열 처리 코드
	 --%>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	 
	 <c:set var="a" value="10"></c:set>
	 <h1>a : ${a }</h1>
	 <c:set var="a" value="${a + 10}"></c:set>
	 <h1>a + 10 : ${a }</h1>
</body>
</html>