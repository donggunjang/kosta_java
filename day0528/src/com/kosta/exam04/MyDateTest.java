package com.kosta.exam04;

import java.util.Scanner;

public class MyDateTest {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String day;
			System.out.print("날짜를 입력하세요:");
			day = sc.next();
			MyDate mydate = new MyDate(day);
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}