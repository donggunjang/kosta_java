package com.kosta.exam04;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
	public static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		System.out.println("1.추가 2.검색 3.삭제 0.종료");
		System.out.println("메뉴를 선택하세요");
	}//어떤 기능을 사용할지 선택하는 메소드
	
	public static void insertStudent(ArrayList<Student> list) {
		String name, addr, phone;
		System.out.println("*** 학생 정보 추가***");
		System.out.println("이름을 입력하세요:");
		name = sc.next();
		System.out.println("주소를 입력하세요:");
		addr = sc.next();
		System.out.println("전화번호를 입력하세요:");
		phone = sc.next();
		
		Student s = new Student(name, addr, phone);
		list.add(s);
		System.out.println("학생의 정보를 추가하였습니다.");
		System.out.println("-------------------------------------------");
		
	}//삽입
	
	public static void searchStudent(ArrayList<Student> list) {
		String phone;
		boolean flag = false;
		System.out.println("*** 학생 정보 검색 ***");
		System.out.println("검색할 학생의 전화번호를 입력하세요:");
		phone = sc.next();
		for(Student s:list) {
			if(s.getPhone().equals(phone)) {
				System.out.println("*** 학생의 정보 ***");
				System.out.println(s);
				flag = true;
				break;
			}//end if
		}//end for
		if(flag == false) {
			System.out.println("검색하신 학생의 정보는 없습니다.");
		}
		System.out.println("-------------------------------------------");
		
	}//검색
	
	public static void deleteStudent(ArrayList<Student> list) {
		String phone;
		System.out.println("*** 학생 정보 삭제 ***");
		System.out.println("검색할 학생의 전화번호를 입력하세요:");
		phone = sc.next();		//A,B,C,D		//D 삭제 ==> i=3, size:3
		int i;
		int cnt = list.size();
		for(i=0; i<list.size(); i++) {
			Student s = list.get(i);
			if(s.getPhone().equals(phone)) {
				list.remove(i);
				System.out.println("해당 학생의 정보를 삭제 했습니다.");
			}//end if
		}//end for
		
		if(i==cnt) {
			System.out.println("삭제하려는 학생의 정보가 없습니다.");
		}
	}//삭제

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		int sel;
		
		while(true) {
			menu();
			sel = sc.nextInt();
			if(sel==0) {
				break;
			}//end if
			
			switch(sel) {
				case 1:insertStudent(list);break;
				case 2:searchStudent(list);break;
				case 3:deleteStudent(list);break;
			}
			
		}//end while
		System.out.println("종료");
	}

}
