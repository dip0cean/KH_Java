<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Scriplet 을 이용해 Java 와 html 의 연동 -->
	<!-- < % Java 코드 % > 를 이용해서 Java 사용 가능 -->
	<%
		for (int i = 0; i < 10; i++) {
	%>
	<h1>Hello World!</h1>

	<%
		}
	%>



	<!-- 표현식(Expression) / 디렉티브(Directive) -->
	<%for (int i = 0; i < 10; i++) {%>
	<h2>반갑소~ <%=i%></h2>
	<%}%>
</body>
</html>