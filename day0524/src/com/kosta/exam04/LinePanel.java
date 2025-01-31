package com.kosta.exam04;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinePanel extends Panel implements MouseListener {

	
	List<GraphicInfo> list;
	
	int x1,y1,x2,y2;
	
	public LinePanel() { 
		list = new ArrayList<GraphicInfo>();
		addMouseListener(this);
		
	}
	@Override
	public void paint(Graphics g) {
		int x,y,width,height;
		for(GraphicInfo s:list) {
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
//			g.drawRect(x, y, width, height);
			g.drawOval(x, y, width, height);
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
		
		list.add(new GraphicInfo(x1,y1,x2,y2));
		repaint();
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}