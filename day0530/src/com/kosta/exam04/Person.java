package com.kosta.exam04;

//성금자를 위한 클래스( 전화(call())를 걸어서 모금액을 증가 )
//다른 성금자와 관계없이 계속 입금을 하기 위하여 쓰레드를 상속
public class Person extends Thread{

	 //성금자 이름
	 String name;
	
	 //다른 성금자와 모금액을 공유하기 위하여 모금액 클래스인 Account 를 생성
	 Account account;
	 
	 
	 public Person(String name, Account account) {
		super();
		this.name = name;
		this.account = account;
	}

	// 성금자가 해야할 일을 run을 오버라이딩하여 써줌
	 @Override
	 public void run() {
		 
		 //1000원씩 10번을 입금하도록 하자.
		 for(int i=1; i<=10; i++) {
			 account.call(1000);
			 System.out.println(name+"의"+i+"번째 입금");
			 try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }
}