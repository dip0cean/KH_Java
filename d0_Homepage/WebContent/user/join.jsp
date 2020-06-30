<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<article class="w-55 center">

	<div class="row-empty"></div>
	<div class="row-empty"></div>
	<div class="row-empty"></div>
	
	<!-- FORM 을 만들 때에는 전송 방식을 설정할 수 있다. -->
	<form action="join.do" method="get">
		<div class="row">
			<!-- 아이디 -->
			<input class="form-input input-cursor" type="text" name="member_id"
				placeholder="영문 + 숫자 5 ~ 20자" required autocomplete="off">
		</div>
		<div class="row">
			<!-- 패스워드 -->
			<input class="form-input input-cursor" type="password" name="member_pw"
				placeholder="영문 + 숫자 + 특수문자 8 ~ 16자" required>
		</div>
		<div class="row">
			<!-- 닉네임 -->
			<input class="form-input input-cursor" type="text" name="member_nick"
				placeholder="한글 5 ~ 8자" required  autocomplete="off">
		</div>
		<div class="row">
			<!-- 우편번호 -->
			<input type="button" class="btm" style="text-align: left;" onclick="findAddr()" value="우편번호 찾기">	
			<input class="post-code form-input input-cursor" type="text" name="member_post"
				placeholder="우편번호" maxlength="6" required autocomplete="off">
		</div>
		<div class="row">
			<!-- 기본주소 -->
			<input class="form-input input-cursor" type="text" name="member_base_addr"
				placeholder="기본 주소" required autocomplete="off">
		</div>
		<div class="row">
			<!-- 상세주소 -->
			<input class="form-input input-cursor" type="text" name="member_extra_addr"
				placeholder="상세 주소" required autocomplete="off">
		</div>
		<div class="row">
			<!-- 생년월일 -->
			<input class="form-input input-cursor" type="date" name="member_birth" required autocomplete="off">
		</div>
		<div class="row">
			<!-- 휴대전화 -->
			<input class="form-input input-cursor" type="text" name="member_phone" size="20"
				maxlength="11" placeholder="휴대전화" required autocomplete="off">
		</div>
		<div class="row">
			<!-- 자기소개 -->
			<textarea class="form-input intro-input input-cursor" name="member_intro"
				placeholder="자신을 소개해주세요!"></textarea>
		</div>

		<div class="row-empty"></div>
		<div class="row-empty"></div>

		<div class="row">
			<!-- 전송 -->
			<input class="join trans" type="submit" value="Join">
		</div>
	</form>

</article>

<jsp:include page="/template/footer.jsp"></jsp:include>