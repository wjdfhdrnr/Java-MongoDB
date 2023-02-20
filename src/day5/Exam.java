package day5;

// Student, Book

// 제너릭 클래스 : 클래스 명 우측에 '<T>'추가
// 자료형(=타입)을 설정한다음에 클래스로 사용하겠다.
// T는 정해져 있지 않음 => T는 누가 정하나? Main2.java에서 정할 예정
public class Exam<T> {
	
	// 변수 1개
	private T element; // 선언한 변수의 자료형을 가변할 수 있음.(int, String,...)

	// source => Generate getters and setters
	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}
	
}
