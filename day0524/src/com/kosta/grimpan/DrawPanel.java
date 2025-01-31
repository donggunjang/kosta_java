package com.kosta.grimpan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DrawPanel extends Panel implements MouseListener {
	
	List<GraphicInfo> list;
	int x1,y1,x2,y2;
	
	//그리기 도구를 위한 맴버 변수
	int drawType; //0.선 1.사각형 2.원
	//색 선택을 위한 맴버 변수
	Color drawColor;
	
	
	public DrawPanel() { 
		list = new ArrayList<GraphicInfo>();
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		int x,y,width,height;
		for(GraphicInfo s:list) {
			g.setColor(s.getDrawColor());
			x = s.getX1();
			y = s.getY1();
			width = s.getX2()-s.getX1();
			height = s.getY2()-s.getY1();
			if(s.getX1() > s.getX2()) {
				width = s.getX1() - s.getX2();
				x = s.getX2();
			}
			if(s.getY1() > s.getY2()) {
				height = s.getY1()-s.getY2();
				y = s.getY2();
			}
			switch(s.getDrawType()) {
				case 0: g.drawLine(s.getX1(), s.getY1(),s.getX2(),s.getY2()); break;
				case 1: g.drawRect(x, y, width, height); break;
				case 2: g.drawOval(x, y, width, height); break;
				
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		
		list.add(new GraphicInfo(x1,y1,x2,y2,drawType,drawColor));
		repaint();
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}