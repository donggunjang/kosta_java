package com.kosta.game5;

import java.awt.event.KeyEvent;

public class Missile extends GraphicObject {
	boolean launched = false;
	
	//미사일 생성시에 미사일로 표현할 이미지 파일명을 전달 받아
	//부모생성자인 GraphicObject 생성자에게 전달
	public Missile(String name) {
		super(name);
		//맨 처음 미사일 위치를 화면에 보이지 않게 설정
		y = -100;
	}
	@Override
	public void update() {
		if(launched) { //미사일이 발사 되었으면 y의 위치를 1씩 감소시켜서 위이로 이동
			y -= 10;
		}
		
		if(y < -100) { //y위치가 화면에서 벗어나면(-100보다 작아지면) launched에 false을 담아서 미사일을 정지 시킨다.
			launched = false;
		}
	}
	
	//키보드가 눌러지면 눌러진 키 이벤트 정보와 
	//player의 위치 xy를 갖고 이 메소드를 호출
	public void KeyPressed(KeyEvent event, int x, int y) {
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			//미사일을 발사 시키기 위하여 launhced에 true를 저장.
			launched =true;
			
			//미사일을 플레이어의 위치에서 부터 발사시키기 위하여
			//미사일의 x,y를 매개변수로 전달받은 플레이어의 위치x,y로 설정
			this.x = x;
			this.y = y;
		}
	}
	
	

}
