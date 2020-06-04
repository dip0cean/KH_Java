<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>절대 / 상대 경로 Test</title>
</head>
<body>
	<!-- 클라이언트 리스트   -->
	<!-- 절대 경로-->
	<a href="/Tomcat/client/list.do">클라이언트 리스트 > 절대 경로</a>
	<br>
	<!-- 상대 경로 -->
	<a href="../../client/list.do">클라이언트 리스트 > 상대 경로</a>
	<br>

	<!-- 학생 리스트 -->
	<!-- 절대 경로 -->
	<a href="/Tomcat/student/list.do">학생 리스트 > 절대 경로</a>
	<br>
	<!-- 상대 경로 -->
	<a href="../../student/list.do">학생 리스트 > 상대 경로</a>
</body>
</html>