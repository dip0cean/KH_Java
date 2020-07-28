<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴리스트</title>
</head>
<body>
	<h1>메뉴 리스트입니다</h1>
	
	데이터 갯수 : ${list.size() }
	<c:forEach var="menu" items="${list }">
		<h1>${menu.name }</h1>
		<div>${menu.price }원</div>
		<div>${menu.sort }</div>
		<br>
	</c:forEach>
</body>
</html>