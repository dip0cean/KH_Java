package com.d0.spring.websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/*
 * 접속한 사용자를 기억해두고 모두에 대한 처리를 수행하는 서버
 */
@Slf4j
public class WebSocketGroupServer extends TextWebSocketHandler {

	// 해당 서버는 사용자를 기억해야 한다. > Set 이용 > CopyOnWriteArraySet
	// - 중복 불가 / 동기화 지원
	
	// 사용자의 정보(WebSocketSession)를 set 의 저장 포맷으로 설정
	private Set<WebSocketSession> users = new CopyOnWriteArraySet<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
		log.info("--------접속--------");
		log.info("현재 접속자 수 = {}",users.size());
		log.info("--------------------");
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 메세지를 모든 사용자에게 전송 > 사용자 수만큼 반복하여 전송
		
		TextMessage newMessage = new TextMessage(message.getPayload());
		
		for(WebSocketSession ws : users) {
			ws.sendMessage(newMessage);
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
		log.info("--------종료--------");
		log.info("현재 접속자 수 = {}",users.size());
		log.info("--------------------");
	}
}
