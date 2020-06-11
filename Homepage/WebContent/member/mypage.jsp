<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2>My Page</h2>
	<a href="check.jsp?go=edit_userinfo.jsp"><input type="button" value="정보 수정"></a>
	<a href="check.jsp?go=edit_pw.jsp"><input type="button" value="비밀번호 수정"></a>
	<a href="check.jsp?go=exit.do"><input type="button" value="회원 탈퇴"></a>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>