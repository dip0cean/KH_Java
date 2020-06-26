<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2>관리 페이지</h2>
	
	<a href="admin_check.jsp?go=manage_user.jsp"><input type="button" value="회원 검색"></a>
	<a href="admin_check.jsp?go=stats.jsp"><input type="button" value="통계 확인"></a>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>