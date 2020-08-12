<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 > 학생 정보 불러오기</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.2/axios.min.js" integrity="sha512-VZ6m0F78+yo3sbu48gElK4irv2dzPoep8oo9LEjxviigcnnnNvnTOJRSrIhuFk68FMLOpiNz+T77nNY89rnWDg==" crossorigin="anonymous"></script>
</head>
<body>
	<h1>학생 목록</h1>
	<!-- 목록을 불러오기 위한 버튼(Trigger) -->
	<button onclick="getList();">리스트 불러오기</button>
	<div class="list-wrap"></div>
	
	<script>
		function getList() {
			var list = document.querySelector(".list-wrap");
			
			list.innerHTML = "";
			
			axios({
				url:"${pageContext.request.contextPath}/test/test9",
				method:"get"
			}).then(function (resp) {
				console.log(resp)
				console.log(resp.data)
				
				for(var i = 0; i < resp.data.length; i++) {
					var h3 = document.createElement("div");
					h3.textContent = resp.data[i].name + " | " + resp.data[i].score + "점";
					list.appendChild(h3);
				}
			})  
		}
	</script>
</body>
</html>