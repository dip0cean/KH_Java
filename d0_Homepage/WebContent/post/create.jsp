<%@page import="homepage.beans.dto.PostDTO"%>
<%@page import="homepage.beans.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberDTO mdto = (MemberDTO) session.getAttribute("userinfo");
%>    

<jsp:include page="/template/header.jsp"></jsp:include>

<article class="w-80">
	<form action="create.do" method="post" enctype="multipart/form-data">
		<!-- 원본글 번호가 있다면(답글이라면) 원본글번호를 hidden으로 첨부 -->
		<%if(request.getParameter("post_no") != null) { %>
			<input type="hidden" name="post_no" value="<%=request.getParameter("post_no")%>">
		<%} %>	
	<div class="row center">
		<table class="form-input">
			<tr>
				<th height="40">말머리</th>
					<td>
						<select class="post-sub form-input" name="post_sub">
							<option disabled="disabled">선택</option>
							<option value="공지">공지</option>
							<option value="일반" selected="selected">일반</option>
							<option value="정보">정보</option>
							<option value="질문">질문</option>
						</select>
					</td>
					<th height="40">작성자</th>
					<td><%=mdto.getMember_id() %><input type="hidden" name="post_id" value="<%=mdto.getMember_id() %>"></td>
				</tr>
				<tr>
					<th height="40">제목</th>
					<td colspan="3"><input type="text" class="post-title form-input" name="post_title" size="70" maxlength="100"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">
						<textarea class="post-content form-input" name="post_content"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4"><input type="file" class="post-file form-input" name="post_file" multiple="multiple" accept=".jpeg , .jpg , .png , .gif"></td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<input type="submit" class="btm" value="작성">
					</td>
				</tr>
			</table>
		</div>
	</form>
</article>

<jsp:include page="/template/footer.jsp"></jsp:include>