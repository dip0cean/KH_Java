<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 삭제 페이지</title>
</head>
<body>
	<form action="" method="post">
		<input type="hidden" name="product" value="${product }">
		<label>
			<input type="radio" name="check" value="true" class="check" id="1">
			동의합니다.
		</label>
		<label>
			<input type="radio" name="check" value="false" class="check" id="2">
			동의하지 않습니다.
		</label>
		<input type="submit" value="삭제">
	</form>
</body>
</html>