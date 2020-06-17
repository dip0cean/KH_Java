<%@page import="homepage.beans.dao.MemberDAO"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<%
	MemberDAO mdao = new MemberDAO();
	MemberDTO mdto = mdao.get(request.getParameter("member_id"));	
	long countPost = mdao.countPost(mdto.getMember_id());
	
	String go = request.getParameter("go");
	
%>

<div align="center">
	<h2>My Page</h2>
	<table style="width: 1038px;">
		<tbody>
			<tr>
				<th>
					아이디
				</th>
				<td height="80" colspan="2">
					<%=mdto.getMember_id() %>
				</td>
				<th>
					닉네임
				</th>
				<td height="80" colspan="2">
					<%=mdto.getMember_nick() %>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<hr>
				</td>
			</tr>
			<tr>
				<th>
					회원 등급
				</th>
				<td height="80">
					<%=mdto.getAccess_auth() %>
				</td>
				<th>
					총 작성글
				</th>
				<td height="80">
					<%=countPost %> 개
				</td>
				<th>
					가입일
				</th>
				<td height="80">
					<%=mdto.getAccess_join() %>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<hr>
				</td>
			</tr>
			<tr>
				<th>
					자기 소개
				</th>
				<td width="300" height="250" colspan="5">
					<%=mdto.getMember_intro() %>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<hr>
				</td>
			</tr>
		</tbody>
	</table>
	<br>
	<a href="<%=request.getContextPath()%>/post/search.jsp?post_id=<%=mdto.getMember_id()%>"><input type="button" value="작성글 조회"></a>
	<a href="javascript:history.back()"><input type="button" value="뒤로가기"></a>
</div>
<br>

<jsp:include page="/template/footer.jsp"></jsp:include>