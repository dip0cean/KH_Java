package com.d0.spring.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/*
 * 웹 소켓의 기본적인 이해를 돕기 한 서버
 * - WebSocketServer 를 만들기 위해서는 특정 클래스/인터페이스를 추가해야 한다. 
 */

@Slf4j
// public class WebSocketBasicServer Implements WebSockeyHandler {
public class WebSocketBasicServer extends TextWebSocketHandler {
	
	/*
	 * 접속 시 실행되는 메소드
	 * - session > 접속한 사용자의 웹소켓 정보 (HttpSession 과는 다르다.)
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info(" -----접속----");
		log.info("접속 = {}", session);
	}
	
	/*
	 * 메세지 수신 시 실행될 메소드
	 * - Set 저장소 > 중복 금지를 위해 (순서 X / 중복 X)
	 * - session > 접속한 사용자의 웹소켓 정보 > sender
	 * - message > 사용자가 전송한 메세지 정보
	 * 	- payload = 내용 
	 * 	- byteCount = 문자 크기
	 * 	- last = 메세지의 종료 여부 > 분할의 마지막
	 */
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.info(" -----수신----");
		log.info("session = {}", session);
		log.info("message = {}", message);
	}
	
	
	/*
	 * 사용자 접속 종료 시 실행되는 메소드 > callback
	 * - session > 사용자의 웹소켓 정보
	 * - status > 접속이 종료된 원인과 관련된 정보
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info(" -----종료----");
		log.info("session = {}", session);
		log.info("status = {}", status);
	}

}
