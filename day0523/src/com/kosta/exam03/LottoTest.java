package com.kosta.exam03;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// 이번주에 구입할 로또번호를 생성
// 로또번호는 1~45까지의 숫자를 중복이 되지 않게 6개가 필요.
public class LottoTest {

	public static void main(String[] args) {
		Random r = new Random();
		Set data = new TreeSet();
		while(true) {
			data.add(r.nextInt(45)+1);
			if(data.size() == 6) {
				break;
			}
		}
		
//		for(int i=1; ; i++) {
//			int n = r.nextInt(45)+1;
//			data.add(n);
//			if(data.size()==6) {
//				break;
//			}
//		}
		
		System.out.println(data);
	}

}
