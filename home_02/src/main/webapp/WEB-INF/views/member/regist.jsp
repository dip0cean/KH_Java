<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h1>회원 가입 페이지</h1>
	<form action="regist" method="post">
		<div>
			아이디
			<input type="text" name="member_id" placeholder="아이디">
		</div>
		<div>
			비밀번호
			<input type="password" name="member_pw" placeholder="비밀번호">
		</div>
		<div>
			닉네임
			<input type="text" name="member_nick" placeholder="닉네임">
		</div>
		<div>
			우편번호
			<input type="text" name="post" placeholder="우편번호">
		</div>
		<div>
			기본주소
			<input type="text" name="base_addr" placeholder="기본주소">
		</div>
		<div>
			상세주소
			<input type="text" name="extra_addr" placeholder="상세주소">
		</div>
		<div>
			생년월일
			<input type="date" name="member_birth" placeholder="생년월일">
		</div>
		<div>
			휴대전화
			<input type="text" name="member_phone" placeholder="휴대전화">
		</div>
		<div>
			자기소개
			<textarea rows="50" cols="50" name="member_intro" placeholder="자기소개"></textarea>
		</div>
			<input type="submit" value="회원가입">
	</form>
</body>
</html>