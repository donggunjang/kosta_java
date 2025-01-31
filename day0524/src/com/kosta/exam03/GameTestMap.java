package com.kosta.exam03;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

//컴퓨터와 사용자가 가위,바위,보 하는 게임을 만들기
public class GameTestMap {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "가위");
		map.put(1, "바위");
		map.put(2, "보");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("0.가위 1.바위 2.보");
		int user = sc.nextInt();
		
		Random r = new Random();
		int com = r.nextInt(3);
		System.out.printf("컴퓨터는 %s를 냈습니다.\n", map.get(com));
		System.out.printf("사용자는 %s를 냈습니다.\n", map.get(user));
		if(com == user) {
			System.out.println("비겼습니다.");
		}else if((user==0 && com == 2)|| //가위 내서 이기는 경우
				(user==1 && com == 0)||	 //바위 내서 이기는 경우
				(user==2 && com== 1)){	 //보를 내서 이기는 경우
			System.out.println("이겼습니다.");
		}else {
			System.out.println("졌습니다.");
		}
	}
}
