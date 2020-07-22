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
	EL(Expression Language) | 표현 언어
	- 표현식이 너무 길고 지저분하기에 이를 개선하기 위해 나온 언어
	- 표현식의 불편함 점들이 대폭 개선되었다.
		- null 처리 방식 개선
		- 코드가 길기 때문에 > 약식 표현이 가능하도록 참조형 저장소 생성
		- 가독성 향상
 --%>
 
 	<h1>기존의 표현식 a = <%=request.getParameter("a") %></h1> <!-- 기존의 표현식 -->
 	<h1>EL a = ${param.a }</h1> <!-- EL -->
 	<form action="test01.jsp">
		<input type="text" name="a" value="${param.a }">
		<input type="submit" value="전송"> 	
 	</form>
</body>
</html>