package com.kosta.exam03;

import java.util.ArrayList;

class Person{
	String name;
	int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void sayHello() {
		System.out.println("Hello" + name);
	}
}

/*
 	ArrayList list = new ArrayList();
 	와 같이 리스트를 생성하면 리스트에 다양한 자료형을
 	담을 수 있다.
 	처음엔 이것이 좋은 줄로만 알았는데
 	컬렉션을 경험 해 보니 결코 좋은것이 아니다라는 것을 느끼게 된다.
 	만약 리스트에 Person도 담고 Shape도 담고
 	Employee도 담고... 등..
 	이렇게 되었을때 리스트에 담긴 데이터의 수 만큼 반복하여
 	결국은 그 요소에 따라 일처리를 시켜야 하는데
 	각각 자료형이 다르면 일일이 instanceof 연산자로 물어보고
 	형변환 한 후에 해당 클래스에 메소드를 호출해야 하는 것은 상당히 번거롭다.
 	가능하면 Object보다는 내가 만든 클래스의 상속관계에 범위를 제한하도록 권장
 	즉, 리스트에 담는 자료형을 제한하도록 한다.
 	이것을 "제네릭"이라고 한다.
 	
 	ArrayList<Person> list = new ArrayList<person>();
 */

public class ArrayListTest02 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(100);
		list.add("자바");
		list.add(true);
		list.add(new Person("홍길동",20));
		list.add(2024);
		list.add(new Person("이순신",24));
		
		for(int i=0; i<list.size(); i++){
			Object obj =list.get(i);
			System.out.println(obj);
			//리스트에 담긴 요소가 Person이면 sayHello() 동작.
			if(obj instanceof Person) {
				((Person)obj).sayHello();
			}
		}
	}

}
