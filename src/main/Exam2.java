package main;
// 연습문제(2)
public class Exam2 {

	public static void main(String[] args) {
		int num = 5;
		int i = 0; // 반복문 임시 변수
		int j = 0;
		
		for(i=1; i<=num; i++) {
			for(j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println(); // 줄 바꾸기
		}
		
		System.out.println(); 
		
		for(i=1; i<=num; i++) {
			for(j=num; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println(); 
		}
		
		System.out.println(); 
		
		for(i=1; i<=5; i++) {
			for(j=1; j<=2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		//문제1) 숫자 5입력하면 아래 처럼 출력하시오
		// 1 2 3 4 5 4 3 2 1
		int a=5;
		for(i=1; i<10; i++) {
			if(i<=5) {
				System.out.print(i+" ");			
			}
			else {
				a--;
				System.out.print(a+" ");			
			}
		}
		
		System.out.println();
		
		// 문제2) 숫자 13을 입력하면 3의 배수의 합구하기
		// 3 6 9 12 => 30
		int b=13;
		int sum=0;
		for(i=1; i<=b; i++) {
			if(i%3==0) {
				sum+=i;
			}
		}
		System.out.println(sum);
		
		
		// 문제3) 숫자 10을 입력하면 홀수의 합 짝수의 합 각각 구하기
		// 홀수 10 => 1 3 5 7 9 => 25 
		// 짝수 10 => 2 4 6 8 10 => 30
		int c=10;
		int sum1=0;
		int sum2=0;
		for(i=1; i<=c; i++) {
			if(i%2==0) {
				sum1+=i;
			}else {
				sum2+=i;
			}
		}
		System.out.println("짝수의 합 : " + sum1 + ", 홀수의 합 : " + sum2);
		
		// 문제4) 숫자 7을 입력하면 구구단 구하기
		// 7*1=7
		// 7*2=14
		int d=7;
		for(i=1; i<=9; i++) {
			System.out.println(d+"*"+i+"="+d*i);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
