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
	<c:if test="${not empty list }">
		<c:forEach var="user" items="${list }">
			<h1>${user.member_id }</h1>
		</c:forEach>
	</c:if>
</body>
</html>