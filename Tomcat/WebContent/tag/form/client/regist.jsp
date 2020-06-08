<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<div align="center">
		<h1>회원 가입</h1>
		<form action="/Tomcat/client/regist.do">
			<table>
				<tbody align="center">
					<tr>
						<th>아이디</th>
						<td><input type="text" name="id" placeholder="5~20자" required="required"></td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input type="password" name="pw" placeholder="8~16자" required="required"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="등록"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>