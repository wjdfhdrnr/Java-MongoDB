package day6;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// preview(20230206)

@Getter
@Setter
@ToString
public class Exam1 {
	
	// 클래스의 변수
	private int age = 1;

	// 생성자 => Main에서 클래스를 생성할 때 초기값으로 세팅용
	public Exam1() {
		super();
	}

	public Exam1(int age) {
		super();
		this.age = age; // 초기에 선언한 변수 값에 대입하겠다는 의미
	}
	
	// 메소드, getter, setter, toString도 메소드
	// public 리턴타입 메소드명(외부로부터 넘겨받는 값 == 파라미터){
	public void printAge() {
		int age1 = 15; // 가급적 클래스 변수와 겹치지 않도록 변수명 설정 
		System.out.println(this.age * 2); 
	}
	
	

}
