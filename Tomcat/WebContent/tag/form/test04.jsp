<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form 의 다양한 종류</title>
</head>
<body>
	<!-- 입력창은 총 3종류가 존재 : input / select / textarea -->
	<form action="test04.jsp">

		<!-- input > test / number / file / checkbox / radio / search / date ... -->
		<h1>Input</h1>
		<input type="file" name="a"> 
		<input type="submit" value="전송">

		<br><br>
		
		<!-- select > 드롭다운 리스트 -->
		<h1>Select</h1>
		<h3>- 전송은 select 가 되므로 name은 select에 부여</h3>
		<h3>- option 에 value 를 부여할 경우 표시되는 값과 전송되는 값이 다르게 부여하여 전송할 수 있다.</h3>
		<select name="b">
			<option value="apple">사과</option>
			<option value="banana">바나나</option>
			<option value="strawberry">딸기</option>
		</select>
		<input type="submit" value="전송">
		
		<br><br>
		
		<!-- textarea > 멀티 라인 에디터 -->
		<h1>Textarea</h1>
		<h3>textarea 는 value 가 없다. > textarea 태그 사이에 작성</h3>
		<h3>글자를 표시할 때 공백을 주의해야 한다.</h3>
		<textarea name="c" placeholder="입력해랑~">인사말을 적어주세요~!</textarea> <br>
		<input type="submit" value="전송">
	</form>
</body>
</html>