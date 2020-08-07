package com.d0.spring;

import javax.swing.JOptionPane;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test02 {
	public static void main(String[] args) {
		// 목표 : 앞 예제의 작업들을 병렬로 처리
		// - main 을 제외한 별도의 Thread 가 필요
		
		// 스레드 생성 및 구동
		Thread t = new Thread() {
			@Override
			public void run() {
				// 별도의 스레드에서 구동되어야 할 코드 작성
				
				for(int i = 1; i 
						<= 100; i++) {
					log.debug("i = {}",i);
					
					try {
						Thread.sleep(1000L);
					} catch(Exception e) {}
				}
			}
		};
		
		t.start();
		
		// 알림창
		JOptionPane.showMessageDialog(null, "야! 너두 할 수 있어^^");
	}

}
