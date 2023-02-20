package main1;

import java.util.Scanner;

// 문자열
public class Main3 {

	public static void main(String[] args) {
		
		// import안함, java.lang.*에 있기 때문에
		// 클래스명 객체명 = new 클래스명(준비물);
		String str = new String("hello world"); // 이렇게 만드는게 맞음
		String str1 = "hello world"; // 원시타입 같지만 엄밀히 말하면 클래스!
		
		System.out.println(str);
		System.out.println(str1);
		
		// String 클래스의 기능중에서 substring을 사용한 경우
		System.out.println(str.substring(0, 3)); // hel
		
		// ret[0] = hello
		// ret[1] = world
		String[] ret = str.split(" "); // 원하는 기준 문자로 분할하기
		System.out.println(ret[0]);
		System.out.println(ret[1]);
		
	}

}
