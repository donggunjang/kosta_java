package com.kosta.game5;

import java.awt.event.KeyEvent;

public class Player extends GraphicObject {
	//생성시에 player로 사용할 이미지 파일명을 매개변수로 전달 받는다.
	public Player(String name) {
		//전달 받은 파일명을 부모클래스의 생성자에게 전달.
		super(name);
		//플레이어의 초기 위치를 150, 350으로 설정
		x = 350;
		y = 450;
	}

	
	//방향키를 눌렀을때마다 10만큼 좌,우,위,아래로 움직이는 동작\
	@Override
	public void KeyPressed(KeyEvent event) {
		switch(event.getKeyCode()) {
			case KeyEvent.VK_LEFT: x -= 10; break;
			case KeyEvent.VK_RIGHT: x += 10; break;
			case KeyEvent.VK_UP: y -= 10; break;
			case KeyEvent.VK_DOWN: y += 10; break;
		}
	}
}
