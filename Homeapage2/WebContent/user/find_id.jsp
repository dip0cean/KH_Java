<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2>아이디 찾기</h2>
	<%if(request.getParameter("error") != null) {%>
	
	<h3><font color="red">휴대전화와 생년월일을 확인해주세요.</font></h3>
			
		<%} %>
	<form action="find_id.do" method="post">
		<table>
			<tr>
				<th>
					휴대전화
				</th>
				<td>
					<input type="text" name="member_phone" placeholder="전화번호 입력" size="15" maxlength="11">
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