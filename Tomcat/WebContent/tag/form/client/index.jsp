<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쉿! 성헌의 숲,,</title>
</head>
<body>
	<div align="center">
		<h1>어서오세요! 성헌의 숲에~</h1>
		<form action="/Tomcat/client/login.do">
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" placeholder="아이디를 입력하세요." required="required"></td>
					<td rowspan="2"><input type="submit" value="로그인" height="50"></td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="password" name="pw" placeholder="패스워드를 입력하세요." required="required"></td>
				</tr>
			</thead>
			<tbody align="center">
				<tr>
					<td><a href="regist.jsp"><input type="button" value="회원 가입"></a></td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>

</body>
</html>