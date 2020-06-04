<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 이미지    : Inline 속성 태그-->
	<!-- 컴퓨터 드라이브에 있는 파일은 불러오지 못한다. 그러므로 웹사이트로 등록 후 불러온다. -->
	<!-- 프로토콜이 확실하지 않을 때 사용하지 않아도 된다. -->
	<img alt="테스트 이미지" src="http://localhost:8080/Tomcat/image/성헌이.jpg"
		width="150" height="200">
	<img alt="테스트 이미지" src="//localhost:8080/Tomcat/image/성헌이.jpg"
		width="150" height="200">

	<!-- 절대 경로 (Absolute Path)-->
	<img alt="테스트 이미지" src="/Tomcat/image/성헌이.jpg" width="150" height="200">
	<!-- 상대 경로 -->
	<img alt="테스트 이미지" src="../../image/성헌이.jpg" width="150" height="200">
</body>
</html>