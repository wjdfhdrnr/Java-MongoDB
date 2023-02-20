package day5;

import day10.Member;

// 메인은 테스트용, 입력(X) 출력(X), 특정클래스(일을 지시하기만)
public class Main4 {

	public static void main(String[] args) {
		
		// 콘솔에서 입력한 항목을 기반으로 Member 타입으로 반환해주세요.
		Member member = Input.inputData(); // stactic 메소드 이므로 객체 생성 별도 필요X
		// System.out.println(member.toString()); // 확인용
		
		// DB에서 조회하기
		Output.printMember(member); // 이것도 static 메소드
		
		//Output.printMember(Input.inputDate()); // 위 두줄을 간단하게 요약
		
	}

}
