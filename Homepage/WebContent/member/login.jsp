<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h1>로그인</h1>
	<form action="login.do" method="post">
		<table>
			<tbody>
				<!-- 아이디 -->
				<tr>
					<th>아이디</th>
					<td><input type="text" name="member_id" placeholder="ID" required>
					</td>
				</tr>
	
				<!-- 패스워드 -->
				<tr>
					<th>패스워드</th>
					<td><input type="password" name="member_pw" placeholder="PW" required>
					</td>
				</tr>
				
				<!-- 전송 -->
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="login">
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr align="center">
					<td colspan="2">
					<a href="#">아이디 찾기</a>
					<br>
					<a href="#">비밀번호 찾기</a>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>