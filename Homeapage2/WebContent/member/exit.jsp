<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2><font color="red">탈퇴하시겠습니까?</font></h2>
	<h3>아래 문장을 따라 입력해주세요.</h3>
	
	<%if(request.getParameter("error") != null) { %>
		<h3><i>다시 입력해주세요.</i></h3>
	<%} else if(request.getParameter("error2") != null) {%>
		<h3><i>운영자는 탈퇴할 수 없습니다. 관리자에게 문의바랍니다.</i></h3>
	<%} %>
	
	<form action="exit.do" method="post">
		<input type="text" name="exit" size="35" placeholder="모든 정보를 삭제하겠습니다.">
		<input type="submit" value="탈퇴">
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>