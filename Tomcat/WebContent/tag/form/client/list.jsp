
<%@page import="tomcat.Beans.ClientDTO"%>
<%@page import="java.util.List"%>
<%@page import="tomcat.Beans.ClientDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Client 테이블의 데이터를 아이디 또는 권한으로 검색할 수 있도록 페이지를 구성 -->
<%
	// 검색어를 search 라는 이름의 파라미터로 처리하려고 한다.
	String key = request.getParameter("search");
	boolean isSearch = key != null && !key.equals("");

	ClientDAO cdao = new ClientDAO();
	List<ClientDTO> list;

	if (isSearch) {
		list = cdao.getSearch(key);
	} else {
		list = cdao.getList();
		key = "";
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 검색</title>
<style>
h1 {
	color: black;
	text-decoration: none;
}
</style>
</head>
<body>
	<div align="center">
		<h1>
			<a href="list.jsp">회원 정보 검색</a>
		</h1>

		<form action="list.jsp">
			<input type="search" name="search" placeholder="검색어 입력" value=<%=key%>> 
			<input type="submit" value="검색">
		</form>

		<!-- 검색 결과가 있을 경우 -->
		<%
			if (!list.isEmpty()) {
		%>
		<h4>
			총
			<%=list.size()%>
			건의 검색 결과가 있습니다.
		</h4>

		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>권한</th>
					<th>포인트</th>
					<th>메뉴</th>
				</tr>
			</thead>
			<tbody align="center">
				<%
					for (ClientDTO cdto : list) {
				%>
				<tr>
					<td><%=cdto.getClient_no()%></td>
					<td><%=cdto.getClient_id()%></td>
					<td><%=cdto.getClient_auth()%></td>
					<td><%=cdto.getClient_point()%></td>
					<td>
						<a href="detail.jsp?no=<%=cdto.getClient_no()%>"><input type="button"value="상세"></a> 
						<a href="edit.jsp?no=<%=cdto.getClient_no()%>"><input type="button" value="수정"></a>
						<a href="delete.jsp?no=<%=cdto.getClient_no()%>"><input type="button" value="삭제"></a>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
			<tfoot align="right">
				<tr>
					<td><a href="/Tomcat/tag/form/client/regist.jsp"><input type="button" value="회원가입"></a></td>
					<td colspan="5" align="right">[이전] 1 2 3 4 5 6 7 8 9 10 [다음]</td>
				</tr>
			</tfoot>
		</table>

		<!-- 검색 결과가 없을 경우 -->
		<%
			} else {
		%>
		<h4>데이터가 없습니다.</h4>
		<%
			}
		%>
	</div>

</body>
</html>