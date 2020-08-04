<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    <%--
    	saveId 라는 쿠키가 있다면 아이디를 저장한 것으로 간주
    	- 저장된 value 를 불러와서 아이디 입력창에 설정
    	- 아이디 저장하기 체크박스에 체크 수행
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form>
		<c:choose>
			<c:when test="${not empty cookie.saveId }">
				<input type="text" name="id" value="${cookie.saveId.value }">
				<input type="checkbox" name="saveId" checked>
			</c:when>
			<c:otherwise>
				<input type="text" name="id" placeholder="아이디">
				<input type="checkbox" name="saveId">
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>