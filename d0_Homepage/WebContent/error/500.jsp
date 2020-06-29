<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">

	<h2><font color="red"><i><b>일시적인 오류가 발생했습니다.</b></i></font></h2>
	<img alt="500" src="<%=request.getContextPath()%>/image/500.gif">

</div>

<jsp:include page="/template/footer.jsp"></jsp:include>