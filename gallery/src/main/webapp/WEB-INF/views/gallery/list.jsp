<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진 리스트</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty list }">
			<c:forEach var="list" items="${list }">
				<a href="${pageContext.request.contextPath}/gallery/down/${list.no }"><img alt="${list.fname }" src="${pageContext.request.contextPath}/gallery/down/${list.no }"></a>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>등록된 사진이 없습니다.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>