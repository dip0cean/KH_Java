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

<article class="w-100">
	<div class="row-empty"></div>
	<div class="row-empty"></div>
	<div class="row-empty"></div>		
	
	<div class="mypage row center">
		<table class="form-input">
			<thead>
				<tr>
					<th colspan="6">
						<h2 class="title"><%=mdto.getMember_nick() %></h2>
					</th>
				</tr>
			</thead>
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
			<thead>
				<tr>
					<td colspan="6">
						<a href="<%=request.getContextPath()%>/post/board.jsp?post_sub=member_nick&post_title=<%=mdto.getMember_nick() %>"><input type="button" class="btm" value="작성글 조회"></a>
						<a href="javascript:history.back()"><input type="button" class="btm" value="뒤로가기"></a>
					</td>
				</tr>
			</thead>
		</table>
	</div>
	
	<div class="row-empty"></div>
	<div class="row-empty"></div>
	<div class="row-empty"></div>		
</article>
<jsp:include page="/template/footer.jsp"></jsp:include>