package com.kosta.dbGUI;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// 학생의 이름, 국어, 영어, 수학을 입력받아 
// student테이블에 정보를 추가하는 프로그램을 GUI로 작성합니다.
// 화면구성및 변수명등은 자유롭게 합니다.

public class InsertStudentGUI extends JFrame {
	JTextField jtf_name;
	JTextField jtf_kor;
	JTextField jtf_eng;
	JTextField jtf_math;
		
	public InsertStudentGUI() {
		setLayout(new FlowLayout());
		jtf_name = new JTextField(10);
		jtf_kor = new JTextField(5);
		jtf_eng = new JTextField(5);
		jtf_math = new JTextField(5);
		
		add(new JLabel("이름"));
		add(jtf_name);
		add(new JLabel("국어"));
		add(jtf_kor);
		add(new JLabel("영어"));
		add(jtf_eng);
		add(new JLabel("수학"));
		add(jtf_math);
		
		JButton btnAdd= new JButton("등록");
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				String name = jtf_name.getText();
				int kor = Integer.parseInt(jtf_kor.getText());
				int eng = Integer.parseInt(jtf_eng.getText());
				int math = Integer.parseInt(jtf_math.getText());
				
				try {
					String sql = "insert into student values('"+name+"',"+kor+","+eng+","+math+")";
					
					//1. jdbc드라이버를 메모리로 로드한다.
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					//2. DB서버에 연결한다.
					conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:XE", 
							"c##mdang", 
							"madang");
					
					//3. 데이터베이스 명령어 실행 담당 객체를 생성
					stmt = conn.createStatement();
					
					//4. 데이터베이스 명령어를 실행한다.
					int re = stmt.executeUpdate(sql);
					
					if(re == 1) {
						System.out.println("학생의 정보를 추가 하였습니다.");
					}else {
						System.out.println("학생의 정보 추가에 실패하였습니다.");
					}
					
				}catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}finally {
					try {
						if(stmt != null) {
							stmt.close();
						}
						if( conn != null) {
							conn.close();
						}				
					}catch (Exception ex) {
						// TODO: handle exception
					}
				}				
			}
		});
		
		add(btnAdd);
		setSize(550, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {	
		new InsertStudentGUI();
	}

}