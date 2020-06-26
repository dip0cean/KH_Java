<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2>패스워드 변경이 완료되었습니다.</h2>
	
	<a href="<%=request.getContextPath() %>/member/mypage.jsp"><input type="button" value="돌아가기"></a>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>