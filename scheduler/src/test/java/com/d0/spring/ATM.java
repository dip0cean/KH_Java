package com.d0.spring;

public class ATM {

	private long money = 100000000L;

	public synchronized void withdrawal() {
		System.out.println("인출 시작");
		try {
			Thread.sleep(5000L);
		} catch (Exception e) {}
		System.out.println("인출 종료");
	}
}
