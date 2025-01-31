package com.kosta.exam07;

import java.lang.reflect.AnnotatedParameterizedType;
import java.util.Random;

//생산자와 소비자가 공유할 자원인 "제품" 클래스.
//새로운 정수를 제품이라 봅시다.

public class Product {
	// 제품을 위한 정수형 변수를 선언.
	// 생산자는 이정수를 계속하여 새롭게 만들어 주고
	// 소비자는 이 정수를 꼐속하여 가져다 쓰도록 합니다.
	int pdNumber;
	
	// 새 제품이 생산 되었는지 판별하기 위한 변수
	// 생산자는 새 제품을 생산한 다음 isNew에 true를 저장하고
	// 소비자는 제품을 소비한 후에 isNew에 false를 저장.
	boolean isNew;
	
	// 생산자가 새 제품을 생산하기 위한 메소드
	// 생산자가 새 제품을 만들고 있는 동안, 소비자는 접근을 하면 안되기 때문에
	// 임계영역을 설정한다. --> synchronized
	public synchronized void makePdNumber() {
		try {
		//제품이 소비될 때 까지 기다립니다.
			while(isNew == true) {
				wait();
			}
			
			//새 제품을 만듬
			Random r = new Random();
			pdNumber = r.nextInt(100) + 1;
			
			//생산된 제품을 출럭
			System.out.println("제품이 생산 됐습니다. "+pdNumber);
			
			//새 제품을 만들었다고 표시 
			isNew = true;
			//대기중인 소비자를 깨워 줍니다.
			notify();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	} 
	//소비자가 사용하는 메소드
	public synchronized int usePdNumber() {
		int n = 0;
		
		try {
			//새로운 제품을 생산할 때 까지 기다립니다.
			while(isNew == false) {
				wait();
			}
			//제품 소비
			n = pdNumber;
			System.out.println("소비자가 소비함: "+n);
			System.out.println("------------------");
			
			isNew = false;
			notify();
		}catch(Exception e){
			e.printStackTrace();
		}
		return n;
	}
}
