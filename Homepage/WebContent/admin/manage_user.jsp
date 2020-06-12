<%@page import="java.util.List"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="homepage.beans.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String member_id = request.getParameter("member_id");
	MemberDAO mdao = new MemberDAO();
	
	List<MemberDTO> list = mdao.search(member_id);
	
	if(member_id == null) {
		member_id = "";
	}
	
%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2>회원 검색</h2>
	
	<form action="manage_user.jsp" method="get">
		<input type="text" name="member_id" value="<%=member_id %>" placeholder="User ID"> 
		<input type="submit" value="검색">
	</form>
	<br><br>
	<%if(list.isEmpty()){ %>
	<h5>검색 결과가 존재하지 않습니다.</h5>
	<%}else{ %>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>닉네임</th>
				<th>권한</th>
				<th>관리메뉴</th>
			</tr>
		</thead>
		<tbody align="center">
			<%for(MemberDTO mdto : list){ %>
			<tr>
				<td><%=mdto.getMember_id()%></td>
				<td><%=mdto.getMember_nick()%></td>
				<td><%=mdto.getAccess_auth()%></td>
				<td>
					<a href="#">상세</a>
					<a href="#">수정</a>
					<a href="#">탈퇴</a>
				</td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<%} %>

</div>

<jsp:include page="/template/footer.jsp"></jsp:include>