<%@page import="homepage.beans.dao.MemberDAO"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<%
	MemberDAO mdao = new MemberDAO();
	MemberDTO mdto = mdao.get(request.getParameter("member_id"));	
	long countPost = mdao.countPost(mdto.getMember_id());
%>

<div align="center">
	<h2>My Page</h2>
	<table>
		<tbody>
			<tr>
				<th>
					아이디
				</th>
				<td>
					<%=mdto.getMember_id() %>
				</td>
				<tr>
				<th>
					닉네임
				</th>
				<td>
					<%=mdto.getMember_nick() %>
				</td>
			</tr>
			<tr>
				<th>
					자기 소개
				</th>
				<td>
					<%=mdto.getMember_intro() %>
				</td>
			</tr>
			<tr>
				<th>
					회원 등급
				</th>
				<td>
					<%=mdto.getAccess_auth() %>
				</td>
			</tr>
			<tr>
				<th>
					총 작성글
				</th>
				<td>
					<%=countPost %> 개
				</td>
			</tr>
			<tr>
				<th>
					가입일
				</th>
				<td>
					<%=mdto.getAccess_join() %>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td	colspan="2" align="center">
					<br>
					<a href="<%=request.getContextPath()%>/post/search.jsp?post_id=<%=mdto.getMember_id()%>"><input type="button" value="작성글 조회"></a>
				</td>
			</tr>
		</tfoot>
	</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>