<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
<div align="center">
	<h2>Change Password</h2>

	<form action="edit_pw.do" method="post">
		<table>
			<tr>
				<th>새로운 패스워드</th>
				<td><input type="password" name="member_pw" placeholder="영문 + 숫자 + 특수문자 8 ~ 16자"
					size="30" required></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="비밀번호 변경">
				</td>
			</tr>
		</table>
	</form>
</div>


<jsp:include page="/template/footer.jsp"></jsp:include>