package com.kosta.exam05;

public class CountDown extends Thread {

	@Override
	public void run() {
		for(int i=20; i>=0; i--) {
			System.out.println(i+"초 전입니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
