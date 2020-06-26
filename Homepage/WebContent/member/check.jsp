<%@page import="homepage.beans.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	MemberDTO mdto = (MemberDTO) session.getAttribute("userinfo");
	String go = request.getParameter("go");
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2>Check Password</h2>
	
	<%if(request.getParameter("error") != null) { %>
		<h3><font color="red">패스워드를 다시 입력해주세요.</font></h3>
	<%} %>

	<form action="check.do" method="post">
		<table>
			<tr>
				<th>패스워드</th>
				<td><input type="hidden" name="go" value=<%=go %>></td>
				<td><input type="password" name="member_pw" placeholder="패스워드 입력"></td>
				<td colspan="3" align="center">
				<input type="submit" value="정보 수정"></td>
			</tr>
		</table>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>