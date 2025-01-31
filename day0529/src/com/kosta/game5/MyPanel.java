package com.kosta.game5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener {
	//사용자, 적, 미사일 맴버로 초기화
	Enermy enermy;
	Player player;
	Missile missile;
	
	public MyPanel() {
		super();
		this.addKeyListener(this);
		//키보드 이벤트를 바로 설정 할 수 없어서
		//패널에 키보드 이벤트를 설정하기 위해
		//포커스를 설정
		this.requestFocus();
		setFocusable(true);
		
		//화면에 보여줄 사용자, 적, 미사일의 객체들을 생성
		enermy = new Enermy("enermy.png");
		player = new Player("player.png");
		missile = new Missile("missile.png");
		
		//사용자, 적, 미사일이 다들 동시다발적으로 움직이게 하기 위하여 해서 쓰레드를 만들어준다.
		class MyThread extends Thread{
			public void run() {
				while(true) {
					//각각의 그래픽오브젝트의 위치를 갱신.
					setBackground(Color.black);
					enermy.update();
					player.update();
					missile.update();
					//갱신된 위치에 다시 그려줄 것을 요청
					repaint();
					try {
						//0.05초 동안 대기시간을 준다.
						Thread.sleep(50);
					}catch( InterruptedException e) {}
					
					if (((missile.x > (enermy.x-40))&&(missile.x<(enermy.x+80))) &&
							((missile.y < enermy.y+20)&&(missile.y > enermy.y))){
					    System.out.println("enermy.x : "+enermy.x);
					    System.out.println("missile.y : " +missile.y);
					    System.out.println("격추!");
					    missile.y = -100;
					    
					    enermy = new Enermy("enermy.png"); 
					}
				}//end while()
			}//end run()
		}// end MyThread
		
		//쓰레드 객체 생성
		MyThread t = new MyThread();
		t.start();
	}
	//쓰레드에서 각각
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		enermy.draw(g);
		player.draw(g);
		missile.draw(g);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	//키가 눌러 지면 다음의 keyPressed메소드가 동작
	@Override
	public void keyPressed(KeyEvent event) {
		player.KeyPressed(event);
		missile.KeyPressed(event, player.x, player.y);
		
	}
	
}
