package com.d0.spring;

import javax.swing.JOptionPane;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test01 {
	public static void main(String[] args) {
		// 1개의 스레드를 이용하여 두가지 작업을 수행
		// - 앞의 작업이 완료되어야 뒤 작업이 실행됨> Blocking
		
		// 알림창
		JOptionPane.showMessageDialog(null, "Hello");
		
		// 1부터 100까지 출력
		for(int i = 1; i < 100; i++) {
			log.debug("i = {}",i);
		}
	}
}
