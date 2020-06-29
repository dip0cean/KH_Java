<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2>패스워드 찾기</h2>
	
	<%if(request.getParameter("error") != null){ %>
		<h2><font color="red">아이디와 휴대전화, 생년월일을 확인해주세요.</font></h2>
	<%} %>
	
	<form action="find_pw.do" method="post">
		<table>
			<tr>
				<th>
					아이디
				</th>
				<td>
					<input type="text" name="member_id" placeholder="ID">
				</td>
			</tr>
			<tr>
				<th>
					휴대전화
				</th>
				<td>
					<input type="text" name="member_phone" placeholder="전화번호 입력">
				</td>
			</tr>
			<tr>
				<th>
					생년월일
				</th>
				<td>
					<input type="date" name="member_birth">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="찾기">
				</td>
			</tr>	
		</table>
	</form>	
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>