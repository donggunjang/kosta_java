package com.kosta.exam01;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Panel은 복자한 화면구성을 위한 서브 컨테이너 역할이나
//그래픽을 표현하기 위하여 사용하는 화면 구성요소 이다.
//아래의 LinePanel은 그래픽을 표현하기 위하여 Panel클래스로 부터 상속 받고
//마우스 움직임에 대한 이벤트를 처리 하귀 위하여 MouseListener 인터페이스를 구현 한다.
public class LinePanel extends Panel implements MouseListener {
	
	//선을 그리면 이전에 그려진 선이 사라진다.
	//그려진 모든 선을 그리려면
	//선을 그랠때 마다 리스트에 담아두고 paint메소드에서
	//리스트에 담긴 요소만큼 모두 다시 그려주도록 해야 한다.
	
	List<GraphicInfo> list;
	//화면에 그려진 모든 그래픽(선)을 담기 위하여 리스트를 선언
	//리스트에는 그래픽의 정보를 표현하기 위한 GraphicInfo만 담도록 한정.
	
	int x1,y1,x2,y2;
	//현재의 그래픽(선)의 시작점 x1,y1과 끝점 x2,y2를 저장하기 위한 맴버변수를 선언
	
	public LinePanel() { // LinePanel생성자 이면 객체생성시에 자동 동작
//		list = new ArrayList<GraphicInfo>();
		list = new LinkedList<GraphicInfo>();
		//리스트를 사용하기 위하여 생성
		addMouseListener(this);
		//현재 패널인 LinePanel에 마우스 이벤트 처리 담당자가 자신임을 등록
		
	}
	
//	윈도우프로그래밍(GUI 프로그래밍)에서는 화면을 다시 그려줘야 할 필요가 있으면
//	다음의 paint메소드가 자동으로 동작한다.
//	처음 LinePanel을 생성하여 프레임에 담으면 이 paint메소드가 자동으로 동작하고
//	프레임의 크기를 조절하면 그 속에 있는 패널의 크기도 변경되기 때문에
//	그때도 paint가 자동으로 동작한다.
//	무언가 다시 그려줘야 할 필요가 있을 때 paint가 자동으로 동작한다.
//	그러나 원래 윈도우는 모르는 사항에 대해서 다시 그려줄것을 요청하려면
//	우리가 paint를 직접호출할 수는 없고 repaint메소드를 호출하여 paint를 요청할 수 있다.
	@Override
	public void paint(Graphics g) {
		
		//사용자가 그린 그래픽(선)의 모든 정보는
		//리스트에 담겨 있기 때문에
		//리스트에 담긴 요소만큼 반복실행하여
		//선을 그려준다.
		
		for(GraphicInfo s:list) {
			g.drawLine(s.getX1(), s.getY1(), s.getX2(), s.getY2());
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		//마우스가 눌러졌을때 동작하는 메소드
		//눌러진 마우스의 위치정보를 매개변수 MouseEvent e가 받아온다.
		//이를 통해 마우스가 눌러진 x,y를 그래픽(선)의 시작점인 x1,y1에 저장.
		x1 = e.getX();
		y1 = e.getY();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		//마우스가 떼어졌을때 동작하는 메소드
		//마우스가 떼어졌을때 x,y를 그래픽(선)의 끝점을 위한 x2,y2에 저장
		x2 = e.getX();
		y2 = e.getY();
		
		//현재 그려진 그래픽(선)의 시작점 x1,y1 끝점 x2,y2를 리스트에 저장
		list.add(new GraphicInfo(x1,y1,x2,y2));
		
		//리스트에 담긴 그래픽의 정보만큼 모두 다시 그려줄 것을 요청.
		repaint();
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}