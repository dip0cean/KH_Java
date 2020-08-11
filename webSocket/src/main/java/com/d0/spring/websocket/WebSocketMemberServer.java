package com.d0.spring.websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.d0.spring.vo.MessageVO;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

// 해당 서버는 로그인된 사용자만 메세지를 보낼 수 있다.
@Slf4j
public class WebSocketMemberServer extends TextWebSocketHandler {

	// 사용자 저장소 > 동기화
	private Set<WebSocketSession> users = new CopyOnWriteArraySet<WebSocketSession>();

	// 접속
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
		log.info("--------접속--------");
		log.info("접속자 정보 = {}", session);
		log.info("접속자 Attribute = {}", session.getAttributes());

		// 로그인 했을 경우 - DTO / 로그인 하지 않을 경우 - NULL
		log.info("접속자 ID = {}", session.getAttributes().get("userinfo"));
		log.info("현재 접속자 수 = {}", users.size());
		log.info("--------------------");
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		String id = (String) session.getAttributes().get("userinfo");
		boolean userinfo = id != null;

		if (userinfo) {

			MessageVO vo = MessageVO.builder().id(id).payload(message.getPayload()).build();
			ObjectMapper mapper = new ObjectMapper();
			String result = mapper.writeValueAsString(vo);

			for (WebSocketSession ws : users) {

				TextMessage newMessage = new TextMessage(result);
				ws.sendMessage(newMessage);

			}

		}

	}

	// 종료
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
		log.info("--------종료--------");
		log.info("현재 접속자 수 = {}", users.size());
		log.info("--------------------");
	}
}
