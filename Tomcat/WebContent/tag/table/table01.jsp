<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Table Tag</title>
</head>
<body>
	<table border="1"> <!-- 표 -->
		<thead> <!-- 테이블 헤더(제목) -->
			<tr> <!-- 줄(행, table row) -->
				<th>번호</th> <!-- 셀 -->
				<th>아이디</th>
				<th>닉네임</th>
				<th>등급</th>
				<th>포인트</th>				
			</tr>
		</thead>
			
		<tbody> <!-- 테이블 바디(내용) -->
			<tr>
				<td>01</td>
				<td>master</td>
				<td>성헌</td>
				<td>최고</td>
				<td>99</td>			
			</tr>
		</tbody>
	</table>
</body>
</html>