<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Table Tag Test 01</title>
</head>
<body>
	<div align="center">
		<h1>공지 게시판</h1>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th width="50%">제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>

			<tbody align="center">
				<tr>
					<td><a href="/Tomcat/client/list.do">15</a></td>
					<td align="left">긴급 서버 점검 안내</td>
					<td>운영자</td>
					<td>2020-06-05</td>
					<td>50</td>
				</tr>
				<tr>
					<td><a href="/Tomcat/student/list.do">14</a></td>
					<td align="left">운영 규칙 개정 안내</td>
					<td>운영자</td>
					<td>2020-06-01</td>
					<td>102</td>
				</tr>
				<tr>
					<td><a href="https://naver.com/">13</a></td>
					<td align="left">규정 위반 계정 제제 안내</td>
					<td>운영자</td>
					<td>2020-05-30</td>
					<td>150</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>