<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String find_pw = (String) session.getAttribute("find_pw");
	session.invalidate();
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h3>찾으시는 패스워드는</h3>
	<h3><font color="red"><%=find_pw %></font></h3>
	<h3>입니다.</h3>
	
	<form>
		<a href="find_id.jsp"><input type="button" value="아이디 찾기"></a>
		<a href="login.jsp"><input type="button" value="로그인"></a>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>