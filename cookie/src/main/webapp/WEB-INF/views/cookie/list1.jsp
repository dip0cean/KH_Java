<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- 
    	EL 을 이용한 쿠키 접근
    	
    	${cookie.쿠키명 }
    --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP > 쿠키몬스터 확인하기</title>
</head>
<body>
	<h1>나는야 쿠키몬스터</h1>
	<div>
		당신의 맛있는 쿠키 == ${cookie.test }
		${not empty cookie.test }
	</div>
	<div>
		얼마나 있지요 ?
		${cookie.test.value }
	</div>
	<c:if test="${not empty cookie.test }">
		<div>
			냠냠굿~
		</div>
	</c:if>
</body>
</html>