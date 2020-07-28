<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>
	<h1>전체 회원 리스트</h1>
	<c:if test="${not empty getList }">
		<c:forEach var="member" items="${getList }">
			<h3>${member.member_id }</h3>
			<h4>${member.member_nick }</h4>
			<h4>${member.base_addr }</h4>
			<h4>${member.member_intro }</h4>
			<hr>
		</c:forEach>
	</c:if>
</body>
</html>