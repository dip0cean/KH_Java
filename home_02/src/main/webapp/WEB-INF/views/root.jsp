<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello !</h1>
		<c:choose>
			<c:when test="${not empty memberLogin }">
			<h2>${memberLogin.member_id } 님, 환영환영!</h2>
			
			<form action="member/logout" method="post" style="display: inline-block;">
				<input type="submit" value="logout">
			</form>
			<a href="board/union"><button>게시판</button></a>
			</c:when>
			<c:otherwise>
				<div style="display: inline-block;">
					<form action="member/login" method="get">
						<input type="submit" value="로그인">
					</form>
				</div>
				<div style="display: inline-block;">
				<form action="member/regist" method="get">
					<input type="submit" value="회원가입">
				</form>
				</div>
			</c:otherwise>
		</c:choose>
</body>
</html>
