package com.kosta.exam01;

import java.util.Scanner;

/*
	주민등록번호를 입력 받아서 올바른 주민등록번호인지 판별하는 프로그램
	<<처리조건>>
	ㅍ = 11-{(2×ㄱ+3×ㄴ+4×ㄷ+5×ㄹ+6×ㅁ+7×ㅂ+8×ㅅ+9×ㅇ+2×ㅈ+3×ㅊ+4×ㅋ+5×ㅌ) mod 11}
	즉, 소괄호 안에 있는 것을 계산한 값을 
	11로 나눠서 나온 나머지를 11에서 뺀 값이 ㅍ이다. (단, 10은 0, 11은 1로 표기한다.)
 */
public class JuminValidation_re {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String jumin;
		int []chck = {2,3,4,5,6,7,0,8,9,2,3,4,5}; 	
		int r = 0;//연산한 결과를 담을 변수
		int check = 0; // 주민번호의 끝자리를 담을 변수
		System.out.println("주민번호를 입력하세요:xxxxxx-xxxxxxx");
		jumin = sc.next();
		
		//형식에 맞춰 입력했는지 정규표현식으로 판별
//		String regex = "[0-9][0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
		String regex = "\\d{6}-\\d{7}";
		if(jumin.matches(regex) != true) {
			System.out.println("올바른 주민등록번호 형식이 아닙니다.");
			return;
		}
		
		check = Integer.parseInt(jumin.charAt(jumin.length()-1)+"");
		//반복문 0부터 주민번호 길이 -1보다 적을때 까지 수행
		// 각자리에 해당하는 수를 곱하기 하여 누적
		for(int i=0; i<jumin.length()-1; i++) {
			if(i == 6) {
				continue;
			}
			r = r + chck[i] * Integer.parseInt(jumin.charAt(i)+"");
		}
		
		//계산된 결과에 11로 나눈 나머지를 구한다.
		r = r %11;
		
		//11 에서 그 결과를 빼주기
		r = 11-r;
		
		if(r == 10) {
			r=0;
		}
		if(r == 11) {
			r=1;
		}
		System.out.println(r);
		System.out.println(check);
		
		if(r == check) {
			System.out.println("유효한 주민번호");
		}else {
			System.out.println("유효 하지 않은 주민번호");
		}
		
		
	}
}