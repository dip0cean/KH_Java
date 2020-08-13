<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 등록 > 학생 이름 중복 확인</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.2/axios.min.js" integrity="sha512-VZ6m0F78+yo3sbu48gElK4irv2dzPoep8oo9LEjxviigcnnnNvnTOJRSrIhuFk68FMLOpiNz+T77nNY89rnWDg==" crossorigin="anonymous"></script>
</head>
<body>
	<h1>학생 등록</h1>
	<form action="insert" method="post">
		<input type="text" name="name" placeholder="이름" onblur="checkName();"> <span id="check"></span>
		<br><br>
		<input type="text" name="age" placeholder="나이">
		<br><br>
		<input type="text" name="score" placeholder="점수">
		<br><br>
		<input type="submit" value="등록">
	</form>

	<script>
		function checkName() {
			// 이름이 DB 에 있는지 확인 후 결과를 #check span 태그에 출력
			var input = document.querySelector("input[name=name]");
			var span = document.querySelector("input[name=name] + span");
			
			var name = input.value;
			
			if(!name) {
				return;
			}
			
			// axios 를 이용해서 비동기 통신을 보낸다.
			axios({
				url:"${pageContext.request.contextPath}/test/test8?name=" + name,
				method:"get"
			}).then(function(resp) {
				
				console.log(resp)
				console.log(resp.data)
				
				if(!resp.data) {
					span.textContent = "사용 가능한 이름입니다."
				} else {
					span.textContent = "사용 중인 이름입니다."
				}
			})
		}
	</script>
</body>
</html>