package main;

import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		float a1 = scan.nextFloat();
		float a2 = scan.nextFloat();
		float a3 = scan.nextFloat();

		float avg = (a1 + a2 + a3) / 3.0f;
		if (avg >= 90) {
			System.out.println("A");
		} else if (avg >= 80) {
			System.out.println("B");
		} else {
			System.out.println("C");
		}
		
		// Scanner 닫기(마지막에 한번만)
		scan.close();
	}

}
