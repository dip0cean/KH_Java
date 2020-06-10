<%@page import="homepage.beans.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberDTO mdto = (MemberDTO) session.getAttribute("userinfo");
%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2>My Page</h2>
	<%if(request.getParameter("succ") != null) { %>
		<h3>회원 정보 수정 완료</h3>
	<%} %>
	<table>
		<tr>
			<th>아이디</th>
			<td><%=mdto.getMember_id()%></td>
		</tr>
		<tr>
			<th>패스워드</th>
			<td><%=mdto.getMember_pw()%></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><%=mdto.getMember_nick()%></td>
		</tr>
		<tr>
			<th rowspan="3">주소</th>
			<td><%=mdto.getMember_post()%></td>
		</tr>
		<tr>
			<td><%=mdto.getMember_base_addr()%></td>
		</tr>
		<tr>
			<td><%=mdto.getMember_extra_addr()%></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><%=mdto.getMember_birth()%></td>
		</tr>
		<tr>
			<th>휴대전화</th>
			<td><%=mdto.getMember_phone()%></td>
		</tr>
		<tr>
			<th>자기소개</th>
			<td><%=mdto.getMember_intro()%></td>
		</tr>
		<tr>
			<th>회원 등급</th>
			<td><%=mdto.getAccess_auth()%></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a href="mypage_edit.jsp"><input
					type="button" value="정보 수정"></a></td>
		</tr>
	</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>