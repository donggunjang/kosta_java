package com.kosta.exam05;

class Book{
	private String title;
	private String author;
	//생성자
	//매개변수가 있는 생성자를 만들 수 있다.
	public Book(String t, String a) {
		System.out.println("생성자 동작");
		title = t;
		author = a;
	}
	
	public void setTitle(String t) {
		title = t;
		return;
	}
	
	public void setAuthor(String a) {
		author = a;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAthor() {
		return author;
	}
}
public class BookTest {
	public static void main(String[] args) {
		Book b1 = new Book("재미있는자바","장동건");
		Book b2 = new Book("즐거운자바","홍길동");
		//책 제목,저자 출력
		System.out.printf("제목: %s\t",b1.getTitle());
		System.out.printf("저자: %s\n",b1.getAthor());
		System.out.println("-----------------------------");
		System.out.printf("제목: %s\t",b2.getTitle());
		System.out.printf("저자: %s\n",b2.getAthor());
		
	}
}
