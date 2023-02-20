package main;
// 클래스의 위치를 추가하기 ctrl+shift+o
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		// 클래스명 객체명 = new 클래스명(준비물);
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 숫자입력?");
		int a = sc.nextInt(); // nextInt 반환타입
		System.out.println("두번째 숫자입력?");
		int b = sc.nextInt();
				
		int c = a+b;
		System.out.println("입력한 두수의 합은 = " + c);
		
		// 다 사용했음
		sc.close();
		*/
		
		//문제1) 숫자 3개를 입력받아서 합과 평균(소수점표시되게)
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
		
		int sum = d+e+f;
		float avg = sum/(float)3; //주의) 반드시 실수 변수 1개 이상 필요
		System.out.println("세수의 합은 = " + sum);
		System.out.println("세수의 평균은 = " + avg);
		
		sc.close();
		
		/*[자료형] 

		//정수형
		int a1 = 13;
		long a2 = 13L;
		
		//실수형
		float a3 = 3.14f;
		float avg = sum / 3.0f;
		double a4 = 2.45d;
		
		//문자형
		char a5 = 'c';
		*/

	}

}
