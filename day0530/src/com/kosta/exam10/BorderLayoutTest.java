package com.kosta.exam10;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest extends JFrame {
	
	public BorderLayoutTest() {
		setLayout(new BorderLayout());
		add(new JButton("북"), BorderLayout.NORTH);
		add(new JButton("남"), BorderLayout.SOUTH);
		add(new JButton("서"), BorderLayout.WEST);
		add(new JButton("동"), BorderLayout.EAST);
		add(new JButton("적도"), BorderLayout.CENTER);
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new BorderLayoutTest();

	}

}
