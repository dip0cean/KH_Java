<%@page import="homepage.beans.dao.MemberDAO"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
/* 	String rootPath = request.getContextPath(); */
	MemberDTO mdto = (MemberDTO)session.getAttribute("userinfo"); 
	MemberDAO mdao = new MemberDAO();
	
	if(mdto != null) {

		mdto = mdao.get(mdto.getMember_id());
		
	}
	
	boolean isLogin = mdto != null;
%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="rootpath" value="${pageContext.request.contextPath }"></c:set>
	<c:choose>
		<c:when test="${userinfo.access_auth == '운영자' }">
			관리자
		</c:when>
		<c:when test="${not empty userinfo}">
			일반회원
		</c:when>
		<c:otherwise>
			비회원
		</c:otherwise>
	</c:choose>
	
	<div class="center">
		<ul class="navi">
			<c:choose>
				<c:when test="${userinfo.access_auth == '운영자' }">
					<li><a href="${rootpath }/admin/home.jsp"> Setting </a></li>
				</c:when>
				<c:when test="${not empty userinfo}">
					<li><a href="${rootpath }/member/logout.do"> Logout </a></li>
					<li><a href="${rootpath }/member/mypage.jsp"> My page </a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${rootpath }/user/join.jsp"> Join </a></li>
					<li><a href="${rootpath }/user/login.jsp"> Login </a></li>
				</c:otherwise>
			</c:choose>
			<li>
				<a href="${rootpath }/post/board.jsp?page=1">Board</a>
				<ul>
					<li><a href="${rootpath }/post/board.jsp?go=공지"> 공지 </a></li>
					<li><a href="${rootpath }/post/board.jsp?go=일반"> 일반 </a></li>
					<li><a href="${rootpath }>/post/board.jsp?go=정보"> 정보 </a></li>
					<li><a href="${rootpath }/post/board.jsp?go=질문"> 질문 </a></li>
				</ul>
			</li>
		</ul>	
	</div>