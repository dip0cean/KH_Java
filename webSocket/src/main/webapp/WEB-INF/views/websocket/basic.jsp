<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>해당 JSP는 Web Socket 을 연결해주기 위한 매개체</title>
</head>
<body>
	<h1>해당 JSP는 Web Socket 을 연결해주기 위한 매개체입니다.</h1>
	<hr>
	<h2>Web Socket 은 다이렉트로 갈 수 없고, Web Socket 과 연결하기 위한 매개체가 필요하다.</h2>
	<br><br><br>
	<h3>Web Socket</h3>
	<button onclick="connect();">접속</button>
	<br><br>
	<button onclick="disconnect();">종료</button>
	<hr>
	<h2>채팅 테스트</h2>
	<input type="text" id="chat-input">
	<button onclick="send();">전송</button>
	
	<script>
		// 웹소켓 접속 함수
		function connect() {
			var uri = "ws://localhost:8080/spring/test/basic";
			socket = new WebSocket(uri);
			
			// 연결 확인을 위한 예약 작업 > Call Back
			socket.onopen = function(){
				console.log("서버와 연결되었습니다.");
			};
			socket.onclose = function(){
				console.log("서버와 연결이 종료되었습니다.");
			};
			socket.onerror = function(e){
				console.log("서버 연결 중 오류가 발생했습니다.");
			};
			socket.onmessage = function(e){
				console.log("서버에서 행운의 메세지가 도착했습니다.");
			};
		}
		
		// 웹소켓 접속 종료 함수
		function disconnect() {
			socket.close();
		}
		
		// 메세지 전송 함수 > 입력된 글자를 불러와서 서버에 전송
		function send() {
			var text = document.querySelector("#chat-input").value;
			
			console.log("메세지가 전송되었습니다.");
			
			if(!text){
				return;
			}
			
			socket.send(text);
			document.querySelector("#chat-input").value = "";
		}
	</script>
</body>
</html>