<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="homepage.beans.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String member_id = request.getParameter("member_id");
	MemberDAO mdao = new MemberDAO();

	MemberDTO mdto = mdao.get(member_id);
%>

<jsp:include page="/template/header.jsp"></jsp:include>
<div align="center">
	<h2>회원 정보 수정</h2>
	<br>
	<hr>
	<br>
	<form action="user_edit.do" method="post">
		<table>
			<tr>
				<th>
					아이디
				</th>
				<td>
					<input type="hidden" name="member_id" value="<%=mdto.getMember_id()%>">
					<%=mdto.getMember_id() %>
				</td>
			</tr>
			
			<tr>
				<th>
					패스워드
				</th>
				<td>
					<input type="text" name="member_pw" value="<%=mdto.getMember_pw() %>" placeholder="PW">
				</td>
			</tr>
			
			<tr>
				<th>
					닉네임
				</th>
				<td>
					<input type="text" name="member_nick" value="<%=mdto.getMember_nick() %>" placeholder="닉네임">
				</td>
			</tr>
			
			<tr>
				<th rowspan="3">
					주소
				</th>
				<td>
					<input type="text" name="member_post" value="<%=mdto.getMember_post() %>" placeholder="우편번호">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="text" name="member_base_addr" value="<%=mdto.getMember_base_addr() %>" placeholder="기본 주소">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="text" name="member_extra_addr" value="<%=mdto.getMember_extra_addr() %>" placeholder="상세 주소">
				</td>
			</tr>
			
			<tr>
				<th>
					생년월일
				</th>
				<td>
					<input type="hidden" name="member_birth" value="<%=mdto.getMember_birth() %>">
					<%=mdto.getMember_birthday() %>
				</td>
			</tr>
			
			<tr>
				<th>
					휴대전화
				</th>
				<td>
					<input type="text" name="member_phone" value="<%=mdto.getMember_phone() %>" placeholder="전화번호">
				</td>
			</tr>
			
			<tr>
				<th>
					자기 소개
				</th>
				<td>
					<textarea rows="10" cols="30" name="member_intro"><%=mdto.getMember_intro() %></textarea>
				</td>
			</tr>
			
			<tr>
				<th>
					회원 등급
				</th>
				<td>
					<select name="access_auth">
						<option disabled="disabled">선택</option>
						<option value="일반회원">일반회원</option>
						<option value="VIP">VIP</option>
						<option value="운영자">운영자</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<th>
					가입일
				</th>
				<td>
					<input type="hidden" name="access_join" value="<%=mdto.getAccess_join()%>">
					<%=mdto.getAccess_join() %>
				</td>
			</tr>
			
			<tr>
				<th>
					최근 로그인
				</th>
				<td>
					<input type="hidden" name="access_login" value="<%=mdto.getAccess_login()%>">
					<%=mdto.getAccess_login() %>
				</td>
			</tr>
			
			<tr>
			 	<td colspan="2" align="center">
			 		<input type="submit" value="수정">
			 	</td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="/template/footer.jsp"></jsp:include>