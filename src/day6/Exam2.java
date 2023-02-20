package day6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor //  파라미터가 없는 기본 생성자를 생성
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를 만들어줍니다

public class Exam2 {
	private int age = 0;
	private static int age1 = 100; // DB접속시 초기 형태로 많임 씀(자원공유)
	
	public void plusAge() {
		this.age++;
	}
	
	public static void plusAge1() {
		age1++; // static안 클래스변수선언은 위 클래스변수도 static선언해줘야 오류x
	}
	
	public void printAge() {
		System.out.println("age => " + this.age);
		System.out.println("age1 => " + age1);
	}
	
	public void forAge() {
		// 1 2 3
		for(int i=1; i<=this.age; i++) {
			System.out.print( i + ", ");
		}
		
		System.out.println("");
		// 1 2 3
		int m=1;
		while(m<=this.age) {
			System.out.print( m + ", ");
			m++;
		}
	}
	

}
