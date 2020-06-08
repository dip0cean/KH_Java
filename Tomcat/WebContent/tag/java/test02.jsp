<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 테스트</title>
</head>
<body>
	<div align="center">
		<h1> 구구단 테이블 만들기 </h1>
		<table border="1">
			<thead >
				<tr>
				<%for(int i = 2; i <= 9; i++) { %>
					<th><%=i %>단</th>
			<%} %>	
				</tr>
			</thead>
			<tbody>
			<%for(int k = 1; k <= 9; k++) { %>
				<%int sum = 0; %>
					<tr>
				<%for(int i = 2; i <= 9; i++) { %>
					<%sum = k * i; %>	
					<td><%=i %> X <%=k %> = <%=sum %></td>
				<%} %>	
					</tr>
			<%} %>	
			</tbody>
		</table>
	</div>
</body>
</html>