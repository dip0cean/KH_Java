<%@page import="homepage.beans.dto.MemberJoinDTO"%>
<%@page import="java.util.List"%>
<%@page import="homepage.beans.dao.MemberJoinDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberJoinDAO mjdao = new MemberJoinDAO();
	List<MemberJoinDTO> list = mjdao.getList();

%>

<jsp:include page="/template/header.jsp"></jsp:include>
<div align="center">
	<h2>통계</h2>
	
	<%for(MemberJoinDTO mjdto : list) { %>
	<h5>- <%=mjdto.getJoin() %> : <%=mjdto.getCount() %>명</h5>
	<%} %>

</div>

<jsp:include page="/template/footer.jsp"></jsp:include>#