package main;
// 자료형, 사칙연산

// 클래스명 첫번째 문자 대문자 ex) Student Car StudentClass
// 변수명 소문자 ex) car student studentAge
// 메소드 소문자 ex) printMyAge()
public class Main1 {

	public static void main(String[] args) {
		// 타입 변수명 = 초기값;
		// byte, short, int(32bit), long(64bit) => 정수 ex) 3, -1
		// char => 문자 ex) 'a', '1', 'O'
		// float, double => 실수 ex) 1.0, 1.34
		// boolean 참거짓 => true, false
		int a = 15;
		int b = 16;
		
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b); // 나누기 => (정수/정수=정수), (정수/실수=실수)
		System.out.println(a % b);
		
		// problem1)int a = 124;일 경우 각 자리수의 합의 구하시오.(범위 100~999)
		// ex) 124 = > 7, 235 => 10
		a = 124;
		int sum = 0;
		while(a>0) {
			sum+=a%10;
			a=a/10;
		}
		System.out.println(sum);
		
		int c =124;
		int c1 = c % 10; //4
		int c2 = c / 10 % 10; //2
		int c3 = c / 100; //1
		System.out.println(c1 + c2 + c3);
		
		//문제2) 1000~9999의 숫자를 뒤집어서 출력하시오.
		// ex) 2451 => 1542
		int d = 2451;
		int d1 = d / 1000; //2
		int d2 = d / 100 % 10; // 4
		int d3 = d / 10 % 10; // 5
		int d4 = d % 10; // 1
		System.out.println(d4*1000 + d3*100 + d2*10 + d1);
				
				
		
	}

}
