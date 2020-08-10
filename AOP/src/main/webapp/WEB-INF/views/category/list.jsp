<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 리스트</title>
</head>
<body>
	<h1>카테고리 리스트</h1>
	<table border="1">
		<thead>
			<tr>
				<th>카테고리 번호</th>
				<th>이름</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty categoryList }">
					<c:forEach var="list" items="${categoryList }">
						<tr>
							<td>${list.c_no }</td>
							<td>${list.c_name }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="2">카테고리 내용이 없습니당</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>	
</body>
</html>