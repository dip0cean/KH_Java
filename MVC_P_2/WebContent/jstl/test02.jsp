<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<c:if test="${not empty param.a}">
		<h1>a : ${param.a }</h1>
	</c:if>
	
	<c:choose>
		<c:when test="${not empty param.a }">
			<h1>a : ${param.a }</h1>
		</c:when>
		<c:otherwise>
			<h1>a 는 없습니다.</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>