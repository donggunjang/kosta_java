package com.kosta.exam03;

public class PersonTest {

	public static void main(String[] args) {
		Person kim = new Person("김유신");
		Person lee = new Person("이순신");
		
		(new Thread(kim)).start();
		(new Thread(lee)).start();
		
//		Thread t1 = new Thread(kim);
//		Thread t2 = new Thread(lee);
//		t1.start();
//		t2.start();
		
	}
}
