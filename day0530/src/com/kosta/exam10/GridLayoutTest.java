package com.kosta.exam10;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutTest extends JFrame{
	JButton []arr = new JButton[15];
	
	public GridLayoutTest() {
//		setLayout(new GridLayout(5,3));
		setLayout(new GridLayout(3,5));
		for(int i=0; i<arr.length-3; i++) {
			arr[i] = new JButton("버튼"+(i+1));
			add(arr[i]);
		}
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		new GridLayoutTest();
	}

}
