<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
	계획 > pop 이라는 쿠키가 있는지 검사
	- 쿠키가 없을 경우에만 새창(광고)를 출력
 --%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>광고 테스트라네~</title>
</head>
<body>
	<h1>광고 테스트!</h1>
	<c:if test="${empty cookie.pop }">
		<script>
			window.open("http://www.naver.com", "naver", "width=100, height=100")
		</script>
	</c:if>
</body>
</html>