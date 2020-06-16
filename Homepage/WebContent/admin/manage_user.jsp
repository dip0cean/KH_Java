<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@page import="homepage.beans.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String type = request.getParameter("type");
	String keyword = request.getParameter("keyword");
	session.setAttribute("keyword", keyword);
	MemberDAO mdao = new MemberDAO();

	List<MemberDTO> list;
	if (type == null && keyword == null) {
		list = mdao.search();
		keyword = "";
	} else {
		list = mdao.search(type, keyword);
	}
%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	<h2>회원 검색</h2>
	<%if(request.getParameter("succ") != null) { %>
		<h3><font color="red">회원 정보를 삭제했습니다.</font></h3>
	<%} %>
	
	<form action="manage_user.jsp" method="get">
		<table>
			<tr>
				<td><select name="type">
						<option disabled="disabled">선택</option>
						<option value="MEMBER_ID">아이디</option>
						<option value="MEMBER_NICK">닉네임</option>
						<option value="ACCESS_AUTH">회원 등급</option>
				</select> <input type="text" name="keyword" value="<%=keyword%>"
					placeholder="검색어"> <input type="submit" value="검색">
				</td>
			</tr>
		</table>
	</form>
	<br>
	<br>

	<table style="width: 1038px;">
		<thead>
			<tr>
				<th>아이디</th>
				<th>닉네임</th>
				<th>회원 등급</th>
				<th>관리메뉴</th>
			</tr>
			<tr>
				<td colspan="4">
					<hr>
				</td>
			</tr>
		</thead>
		<tbody align="center">

			<%
				for (MemberDTO mdto : list) {
			%>
			<tr>
				<td><%=mdto.getMember_id()%></td>
				<td><%=mdto.getMember_nick()%></td>
				<td><%=mdto.getAccess_auth()%></td>
				<td>
				<a href="user_info.jsp?member_id=<%=mdto.getMember_id()%>"><input type="button" value="상세"></a> 
				<a href="user_edit.jsp?member_id=<%=mdto.getMember_id()%>"><input type="button" value="수정"></a> 
				<a href="user_exit.jsp?member_id=<%=mdto.getMember_id()%>"><input type="button" value="삭제"></a>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<hr>
				</td>
			</tr>

			<%
				}
			%>

		</tbody>
	</table>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>