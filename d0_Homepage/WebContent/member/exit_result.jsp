<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2>지금까지 이용해주셔서 감사합니다.</h2>
	<img alt="잘가" src="../image/안녕히계세요.jpg"> <br><br>
	<a href="<%=request.getContextPath()%>"><input type="button" value="홈으로"></a>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>