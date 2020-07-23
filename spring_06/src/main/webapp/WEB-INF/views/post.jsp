<%@page import="com.d0.spring_06.entity.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		BoardDTO bdto = (BoardDTO) request.getAttribute("post");
	%>
	<div>
		제목 : <%=bdto.getTitle() %>
	</div>
	<div>
		내용 : <%=bdto.getContent() %>
	</div>
</body>
</html>