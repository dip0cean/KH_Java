<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="homepage.beans.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberDAO mdao = new MemberDAO();
	String member_id = request.getParameter("member_id");
	MemberDTO mdto = mdao.get(member_id);
%>    
    
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2>해당 회원 정보를 삭제하시겠습니까?</h2>
	<br>
	<table border="1">
		<tr>
			<th>
				아이디
			</th>
			<th>
				닉네임
			</th>
			<th>
				회원 등급
			</th>
		</tr>
		<tr>
			<td>
				<%=mdto.getMember_id() %>
			</td>
			<td>
				<%=mdto.getMember_nick() %>
			</td>
			<td>
				<%=mdto.getAccess_auth() %>
			</td>
		</tr>
	</table>
	<br>
	<a href="admin_check.jsp?go=user_exit.do&member_id=<%=mdto.getMember_id()%>&access_auth=<%=mdto.getAccess_auth()%>"><input type="button" value="삭제"></a>
	<a href="manage_user.jsp?type=MEMBER_ID&keyword=<%=session.getAttribute("keyword")%>"><input type="button" value="되돌아가기"></a>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>