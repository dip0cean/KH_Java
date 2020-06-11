<%@page import="homepage.beans.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberDTO mdto = (MemberDTO) session.getAttribute("userinfo");
%>
<jsp:include page="/template/header.jsp"></jsp:include>
	<div align="center">
		<h2>My Page</h2>
		
		<%if(request.getParameter("succ") != null) {  %>
			<h3><font color="red">회원 정보 수정 완료</font></h3>
		<%} %>
	
		<form action="edit.do" method="post">
			<table>
				<tr>
					<th>아이디</th>
					<td><%=mdto.getMember_id()%></td>
				</tr>
				
				<tr>
					<th>닉네임</th>
					<td><input type="text" name="member_nick" value=<%=mdto.getMember_nick()%> required></td>
				</tr>
				
				<tr>
					<th rowspan="3">주소</th>
					<td><input type="text" name="member_post" value=<%=mdto.getMember_post()%> required></td>
				</tr>
				
				<tr>
					<td><input type="text" name="member_base_addr" value=<%=mdto.getMember_base_addr()%> required></td>
				</tr>
				<tr>
					<td><input type="text" name="member_extra_addr" value=<%=mdto.getMember_extra_addr()%> required></td>
				</tr>
				
				<tr>
					<th>생년월일</th>
					<td><input type="date" name="member_birth" value=<%=mdto.getMember_birth()%> required></td>
				</tr>
				
				<tr>
					<th>휴대전화</th>
					<td><input type="text" name="member_phone" value=<%=mdto.getMember_phone()%> required></td>
				</tr>
				
				<tr>
					<th>자기소개</th>
					<td><textarea rows="10" cols="30" name="member_intro"><%=mdto.getMember_intro()%></textarea></td>
				</tr>
				
				<tr>
					<th>회원 등급</th>
					<td><%=mdto.getAccess_auth()%></td>
				</tr>
				
				<tr>
					<th>가입 시간</th>
					<td><%=mdto.getAccess_join() %></td>
				<tr>
				
				<tr>
					<th>로그인 시간</th>
					<td><%=mdto.getAccess_login() %></td>
				<tr>
					<td colspan="2" align="center"><input
							type="submit" value="저장"></td>
				</tr>
			</table>
		</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>