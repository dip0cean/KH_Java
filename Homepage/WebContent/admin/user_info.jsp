<%@page import="homepage.beans.dao.PostDAO"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="homepage.beans.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<%
	String type = request.getParameter("type");
	String keyword = request.getParameter("keyword");
	String member_id = request.getParameter("member_id");

	MemberDAO mdao = new MemberDAO();
	
	MemberDTO mdto = mdao.get(member_id);
	
	long countPost = mdao.countPost(member_id);
%>

<div align="center">
	<h2>회원 상세 정보</h2>
	<br>
	<hr>
	<br>
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
					주소
				</th>
				<td height="80" colspan="5">
					[<%=mdto.getMember_post() %>]
					
					<%=mdto.getMember_base_addr() %>
					
					<%=mdto.getMember_extra_addr() %>
				</td>
			</tr>	
			<tr>
				<td colspan="6">
					<hr>
				</td>
			</tr>
			<tr>	
				<th>
					생년월일
				</th>
				<td height="80">
					<%=mdto.getMember_birthday() %>
				</td>
				<th>
					휴대전화
				</th>
				<td height="80">
					<%=mdto.getMember_phone() %>
				</td>
				<th>
					회원 등급
				</th>
				<td height="80">
					<%=mdto.getAccess_auth() %>
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
			<tr>
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
				<th>
					최종 로그인
				</th>
				<td height="80">
					<%=mdto.getAccess_login() %>
				</td>
		</tbody>
	</table>	
	<a href="manage_user.jsp"><input type="button" value="뒤로가기"></a>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>