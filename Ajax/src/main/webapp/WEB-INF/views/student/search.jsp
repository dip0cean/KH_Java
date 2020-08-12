<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>점수 구간 검색</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.2/axios.min.js" integrity="sha512-VZ6m0F78+yo3sbu48gElK4irv2dzPoep8oo9LEjxviigcnnnNvnTOJRSrIhuFk68FMLOpiNz+T77nNY89rnWDg==" crossorigin="anonymous"></script>
</head>
<body>
	<h1>점수 구간 검색</h1>
	<h4>검색 최고 점수</h4>
	<input type="range" class="finish" onmouseup="valueChange();"><span id="max">0</span>
	<h4>최고 점수 기준 최저 점수</h4>
	<input type="range" class="start" onmouseup="valueChange();"><span id="min">0</span>
	<br><br>
	<button onclick="searchScore();">조회</button>
	<hr>
	<h2>학생 리스트</h2>
	<div id="student"></div>
	
	<script>
		function valueChange(){
			var finish = document.querySelector(".finish").value;
			var start = document.querySelector(".start");
			
			start.setAttribute("max",finish);
			
			var max = document.querySelector("#max");
			max.textContent = finish;
			
			var min = document.querySelector("#min");
			min.textContent = start.value;
		}
	
		function searchScore() {
			var start = document.querySelector(".start").value;
			var finish = document.querySelector(".finish").value;
			
			var student = document.querySelector("#student"); 
			
			student.innerHTML = "";
			
			axios({
				url:"${pageContext.request.contextPath}/test/test10?start=" + start + "&finish=" + finish,
				method:"get"
			}).then(function (resp) {
				console.log(resp.data)
				
				for(var i=0; i < resp.data.length; i++) {
					var name = document.createElement("span");
					name.textContent = resp.data[i].name + "의 점수는 ";
					var score = document.createElement("span");
					score.setAttribute("style","color: blue; font-weight: bolder;")
					score.textContent = resp.data[i].score + "점 입니다.";
					var br = document.createElement("br");
					student.appendChild(name);
					student.appendChild(score);
					student.appendChild(br);
				}
			})
		}
	</script>
</body>
</html>