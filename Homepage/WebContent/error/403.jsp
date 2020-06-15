<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">

	<h2><font color="red"><i><b>해당 기능을 이용할 권한이 없습니다.</b></i></font></h2>
	<img alt="403" src="<%=request.getContextPath()%>/image/403.gif">
		
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>