package main;
//for문
import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt(); // 키보드로 숫자 입력정수(13)
		int num1 = scan.nextInt();
		scan.close();

		int i; // 반복문용 변수

		// i++ => i=i+1
		// i+=2 => i=i+2
		// for(임시변수=초기값; 임시변수를 이용한 조건; 임시변수의 변화(1씩증가))

		/*
		 * -- 실습(1)-- for(i=1; i<=num; i+=2) { System.out.print(i+","); }
		 * System.out.println(); for(i=num; i>=1; i--) { System.out.print(i+","); }
		 */

		// 문제1) 두개의 숫자를 입력받아서 범위 만큼 출력(같은 숫자는 없음)
		// ex) 3 7 => 34567, 8 2 => 2345678
		if (num < num1) {
			for (i = num; i <= num1; i++) {
				System.out.print(i + " ");
			}
		} else if (num > num1) {
			for (i = num1; i <= num; i++) {
				System.out.print(i + " ");
			}
		}

	}

}
