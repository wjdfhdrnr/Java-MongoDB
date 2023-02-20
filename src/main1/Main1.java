package main1;

public class Main1 {

	public static void main(String[] args) {
		// 정수형 : byte, short, int, long
		// 실수형 : float, double
		// 문자형 : char
		// 논리형 : boolean
		int age=13;
		
		//if(조건) age=50, age!=50, age>=50
		// if(조건&&조건), && and , || or, ! not 
		if(age>=50) {
			System.out.println("50보다 크거나 같습니다");
		}
		else {
			System.out.println("50보다 작습니다.");
		}
		
		// [클래스형]
		// 정수형 : Byte, Short, Integer, Long => 클래스로 만들어 놓은것
		// String
		System.out.println(	Integer.SIZE); // 32bit=>4byte
		
		// for, while, do while
		int i=0; // 반복문 임시 변수
		for(i=1; i<=5; i++) { // 1 2 3 4 5   6(x)
			System.out.print( i + " ");  
		}
		
		for(i=1;i<=1000;i++) {
			if(i>=10) {
				// 반복문을 강제로 종료시킴
				// break;는 강제종료
				break; // 10일때 종료됨 11부터는 수행되지 않는다. 
			}
		}
		
		// 1~10까지의 홀수만 출력한 것
		for(i=1;i<=10;i++) {
			if(i%2==0) { // 짝수일 경우에
				continue; // 현위치를 기준으로 아래 소스코드는 수행되지 않음.
			}
			System.out.println(i);
		}
		
	}

}
