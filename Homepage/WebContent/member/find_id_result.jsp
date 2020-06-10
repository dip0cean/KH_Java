<%@page import="homepage.beans.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberDTO mdto = (MemberDTO) session.getAttribute("find_id");
	session.invalidate();
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h3>찾으시는 아이디는</h3>
	<h3><font color="red"><%=mdto.getMember_id() %></font></h3>
	<h3>입니다. </h3>
	
	<form>
		<a href="find_pw.jsp"><input type="button" value="패스워드 찾기"></a>
		<a href="login.jsp"><input type="button" value="로그인"></a>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>