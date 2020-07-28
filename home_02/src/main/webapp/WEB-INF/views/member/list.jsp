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
	<c:forEach var="member" items="${memberList }">
		<div>
			아이디 > ${member.member_id }
		</div>
		<div>
			닉네임 > ${member.member_nick }
		</div>
		<div>
			휴대전화 > ${member.member_phone }
		</div>
	</c:forEach>
</body>
</html>