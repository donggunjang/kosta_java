package com.kosta.exam01;

import java.util.Scanner;

/*
	주민등록번호를 입력 받아서 올바른 주민등록번호인지 판별하는 프로그램
	<<처리조건>>
	ㅍ = 11-{(2×ㄱ+3×ㄴ+4×ㄷ+5×ㄹ+6×ㅁ+7×ㅂ+8×ㅅ+9×ㅇ+2×ㅈ+3×ㅊ+4×ㅋ+5×ㅌ) mod 11}
	즉, 소괄호 안에 있는 것을 계산한 값을 
	11로 나눠서 나온 나머지를 11에서 뺀 값이 ㅍ이다. (단, 10은 0, 11은 1로 표기한다.)
 */
public class JuminValidation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String jumin;
		int []chck = {2,3,4,5,6,7,8,9,2,3,4,5}; 	
		int sum = 0;//연산한 결과를 담을 변수
		int check = 0; // 주민번호의 끝자리를 담을 변수
		System.out.println("주민번호를 입력하세요:xxxxxxxxxxxxx");
		jumin = sc.next();
		check = Integer.parseInt(jumin.charAt(jumin.length()-1)+"");
		
		for(int i=0; i<jumin.length()-1; i++) {
			sum = sum + chck[i] * Integer.parseInt(jumin.charAt(i)+"");
		}
		int jumin_chck = 11-(sum % 11);
		System.out.println(jumin_chck);
		System.out.println(check);
		
		
		switch(jumin_chck) {
			case 10: jumin_chck = 0;break;
			case 11: jumin_chck = 1;break;
		}
		if(check == jumin_chck) {
			System.out.println("유효한 주민번호입니다.");
		}else {
			System.out.println("유효하지 않은 주민번호입니다.");
		}
		
	}
}