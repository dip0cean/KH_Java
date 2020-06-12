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
%>

<div align="center">
	<h2>회원 상세 정보</h2>
	<br>
	<hr>
	<br>
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
				<th rowspan="3">
					주소
				</th>
				<td>
					<%=mdto.getMember_post() %>
				</td>
			<tr>	
				<td>
					<%=mdto.getMember_base_addr() %>
				</td>
			</tr>
			<tr>	
				<td>
					<%=mdto.getMember_extra_addr() %>
				</td>
			</tr>
			<tr>
				<th>
					생년월일
				</th>
				<td>
					<%=mdto.getMember_birthday() %>
				</td>
			</tr>
			<tr>
				<th>
					휴대전화
				</th>
				<td>
					<%=mdto.getMember_phone() %>
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
					가입일
				</th>
				<td>
					<%=mdto.getAccess_join() %>
				</td>
			</tr>
			<tr>
				<th>
					최근 로그인
				</th>
				<td>
					<%=mdto.getAccess_login() %>
				</td>
			</tr>
		</tbody>
	</table>
	<a href="manage_user.jsp?type=MEMBER_ID&keyword=<%=session.getAttribute("keyword")%>"><input type="button" value="뒤로가기"></a>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>