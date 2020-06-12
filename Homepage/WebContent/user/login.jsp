<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2>로그인</h2>
	
	<!-- 오류 메세지는 주소에 error 라는 파라미터가 있을 경우에만 출력 -->
	<%if(request.getParameter("error") != null) {%>
	
	<h3><font color="red">아이디와 비밀번호를 확인해주세요.</font></h3>
			
		<%} %>
	
	<form action="login.do" method="post">
		<table>
			<tbody>
				<!-- 아이디 -->
				<tr>
					<th>아이디</th>
					<td><input type="text" name="member_id" placeholder="ID" required>
					</td>
					<td rowspan="2" align="center">
						<input type="submit" value="login">
					</td>	
				</tr>
				
				<!-- 패스워드 -->
				<tr>
					<th>패스워드</th>
					<td><input type="password" name="member_pw" placeholder="PW" required>
					</td>
					<td>
					</td>
				</tr>
			</tbody>
				
				<!-- 전송 -->
			<tfoot>
				<tr>
					<td colspan="3" align="center">
						<a href="find_id.jsp"><input type="button" value="Find ID"></a>
						<a href="find_pw.jsp"><input type="button" value="Find PW"></a>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>