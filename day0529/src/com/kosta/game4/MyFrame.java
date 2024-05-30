package com.kosta.game4;

import java.awt.Color;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	MyPanel panel;
	
	public MyFrame() {
		setBackground(Color.black);
		panel = new MyPanel();
		add(panel);
		setSize(800, 600);
		setVisible(true);
		
		//프레임을 닫으면 프로그램을 종료하도록 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
