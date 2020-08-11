<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>해당 JSP는 Web Socket 을 연결해주기 위한 매개체</title>
</head>
<body>
	<h1>Group Example</h1>
	<h3>login : ${not empty userinfo }</h3>
	<h3>ID : ${userinfo}</h3>
	<hr>
	<h3>Web Socket 에 접속하기</h3>
	<button onclick="connect();" class="on">접속</button>
	<button onclick="disconnect();">종료</button>
	<hr>
	<h2>채팅 테스트</h2>
	<input type="text" id="chat-input">
	<button onclick="send();">전송</button>
	<hr>
	<h2>메세지 기록</h2>
	<div class="message-wrap"></div>

	<script>
		var socket;

		// 웹소켓 접속 함수
		window.onload = function() {
			var uri = "ws://localhost:8080/spring/test/member";
			socket = new WebSocket(uri);

			// 연결 확인을 위한 예약 작업 > Call Back
			socket.onopen = function() {
				console.log("서버와 연결되었습니다.");
				document.querySelector(".on").disabled = true;
			};
			socket.onclose = function() {
				console.log("서버와 연결이 종료되었습니다.");
			};
			socket.onerror = function(e) {
				console.log("서버 연결 중 오류가 발생했습니다.");
			};
			socket.onmessage = function(e) {
				console.log("서버에서 행운의 메세지가 도착했습니다.");
				console.log(e);
				
				var div = document.createElement("div");
				// e.data 는 JSON String 이므로 객체로 바꾸어 필요한 정보를 추출
				var obj = JSON.parse(e.data);
				div.textContent = "[" + obj.id + "]  " + obj.payload;
				document.querySelector(".message-wrap").appendChild(div);
			};
		}

		function connect() {
			var uri = "ws://localhost:8080/spring/test/member";
			socket = new WebSocket(uri);

			// 연결 확인을 위한 예약 작업 > Call Back
			socket.onopen = function() {
				console.log("서버와 연결되었습니다.");
				document.querySelector(".on").disabled = true;
			};
			socket.onclose = function() {
				console.log("서버와 연결이 종료되었습니다.");
			};
			socket.onerror = function(e) {
				console.log("서버 연결 중 오류가 발생했습니다.");
			};
			socket.onmessage = function(e) {
				console.log("서버에서 행운의 메세지가 도착했습니다.");
				var div = document.createElement("div");
				div.textContent = e.data;
				document.querySelector(".message-wrap").appendChild(div);
			};
		}

		// 웹소켓 접속 종료 함수
		function disconnect() {
			socket.close();
			document.querySelector(".on").disabled = false;
		}

		// 메세지 전송 함수 > 입력된 글자를 불러와서 서버에 전송
		function send() {
			var text = document.querySelector("#chat-input").value;

			if (!text) {
				return;
			}

			socket.send(text);
			document.querySelector("#chat-input").value = "";
		}
	</script>
</body>
</html>