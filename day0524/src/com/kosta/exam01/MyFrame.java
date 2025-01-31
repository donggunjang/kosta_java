package com.kosta.exam01;

import java.awt.Frame;

// 윈도우 프로그래밍(GUI 프로그래밍)을 위하여
// 자바가 제공하는 Frame을 상속받은 MyFrame 클래스를 만든다.

public class MyFrame extends Frame {
	//MyFrame의 구성요서(부속품, 맴버변수)로 LinePanel을 선언.
	LinePanel lp;
	
	public MyFrame() {
		
		//생성자에서 부속품인 LinePanel을 생성
		lp = new LinePanel();
		
		//생성된 LinePanel을 Frame에 담아준다.
		//담지 않으면 Panel이 보이지 않는다.
		add(lp);
		
		//Frame의 크기를 설정.
		setSize(800,600);
		//Frame을 화면에 보여줄 것을 요청
		setVisible(true);
		
	}
}
