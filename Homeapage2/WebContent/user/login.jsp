<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<article class="w-70">
	<div class="row-empty"></div>
	<div class="row-empty"></div>
	<div class="row-empty"></div>
	
		<!-- 오류 메세지는 주소에 error 라는 파라미터가 있을 경우에만 출력 -->
		<%if(request.getParameter("error") != null) {%>
		
	<div class="row center">	
		<h3><font color="red">아이디와 비밀번호를 확인해주세요.</font></h3>
	</div>	
				
			<%} %>
	
	<div class="row-empty"></div>
	
		<div class="login-form">
			<form action="login.do" method="post">
				<div class="row center">
					<input class="id input-cursor" type="text" name="member_id" placeholder="ID" required autocomplete="off">
				</div>
				
				<div class="row center">
					<input class="pw input-cursor" type="password" name="member_pw" placeholder="PW"required>
				</div>
				
				<div class="row center">	
					<input class="trans"type="submit" value="Login">
				</div>	
			</form>
		</div>
	<div class="row-empty"></div>
	<div class="row-empty"></div>	
		<div class="row center">
			<a href="join.jsp"><input class="btm" type="button" value="Join"></a>
			<a href="find_id.jsp"><input class="btm" type="button" value="Find ID"></a>
			<a href="find_pw.jsp"><input class="btm" type="button" value="Find PW"></a>
		</div>
	<div class="row-empty"></div>
	<div class="row-empty"></div>	
</article>
<jsp:include page="/template/footer.jsp"></jsp:include>