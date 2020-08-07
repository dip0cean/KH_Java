package com.d0.spring;

public class Test04 {
	public static void main(String[] args) {
		// ATM 을 하나 만들고 Thread 3명에게 이용하도록 하기
		
		ATM ATM = new ATM();
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					
					ATM.withdrawal();
					
				} catch (Exception e) {}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					
					ATM.withdrawal();
					
				} catch (Exception e) {}
			}
		};
		
		Thread t3 = new Thread() {
			@Override
			public void run() {
				try {
					
					ATM.withdrawal();
					
				} catch (Exception e) {}
			}
		};
		
		t1.start();
		t2.start();
		t3.start();
	}
}
