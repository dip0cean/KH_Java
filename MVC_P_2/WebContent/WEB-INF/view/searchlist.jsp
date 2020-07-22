<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
	<form action="${path }/membersearch.do" method="get">
		<select name="type">
			<option value="MEMBER_ID">아이디</option>
			<option value="MEMBER_NICK">닉네임</option>
			<option value="ACCESS_AUTH">권한</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit">
	</form>
	<c:if test="${not empty searchlist }">
		<c:forEach var="user" items="${searchlist }">
			<h2>아이디 : ${user.member_id }</h2>
		</c:forEach>
	</c:if> 
</body>
</html>