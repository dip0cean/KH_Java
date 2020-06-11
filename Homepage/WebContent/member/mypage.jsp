<%@page import="homepage.beans.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<%
	MemberDTO mdto = (MemberDTO) session.getAttribute("userinfo");
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
					최종 로그인
				</th>
				<td>
					<%=mdto.getAccess_login() %>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td	colspan="2" align="center">
					<br>
					<a href="check.jsp?go=edit_userinfo.jsp"><input type="button" value="정보 수정"></a>
					<a href="check.jsp?go=edit_pw.jsp"><input type="button" value="비밀번호 수정"></a>
					<%if(!mdto.getAccess_auth().equals("운영자")) { %>
					<a href="check.jsp?go=exit.jsp"><input type="button" value="회원 탈퇴"></a>
					<%} %>
				</td>
			</tr>
		</tfoot>
	</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>