<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello !
	<c:if test="${not empty memberLogin }">
		${memberLogin.member_id } 님, 환영환영!
	</c:if>
</h1>

</body>
</html>
