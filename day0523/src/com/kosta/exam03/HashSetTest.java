package com.kosta.exam03;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set data = new HashSet();
//		data.add(new Integer(100));
		boolean f1 = data.add(100); //자동으로 객체로 만들어 준다. auto Boxing
		boolean f2 = data.add("사과");
		boolean f3 = data.add(56.7);
		data.add(true);
		boolean f4 = data.add(100); //false
		
		System.out.println(data);
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		System.out.println(f4);
	}

}
