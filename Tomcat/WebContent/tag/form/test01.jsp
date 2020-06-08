<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Tag</title>
</head>
<body>
	<!-- form > "데이터 전송"을 위한 태그 -->
	<!-- 반드시 전송할 데이터와 전송 버튼이 나와야 한다. -->
	<!-- <form action="http://localhost.8080/Tomcat/tag/form/test02.jsp -->
	<div align="center">
		<h1>학생 검색</h1>
		<form action="test02.jsp">
			<!-- 입력창 > input / select / textarea -->
			<!-- name > 전송될 데이터의 파라미터 이름 -->
			<input type="text" name="q">

			<!-- 전송(submit) > 검색 등 -->
			<!-- value > 표시될 글자 + 전송될 데이터 -->
			<input type="submit" value="검색">
		</form>
	</div>
</body>
</html>