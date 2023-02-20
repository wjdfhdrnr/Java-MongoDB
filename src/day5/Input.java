package day5;

import java.util.Date;
import java.util.Scanner;

import cls.Book;
import day10.Member;


// 입력을 담당하는 클래스
public class Input {
	
	// 변수 정의 X
	
	public static Member inputData() {
		Scanner in = new Scanner(System.in);
		System.out.println("가입정보입력 => 아이디, 암호, 이름, 연락처, 권한");
		// String data = new String("입력한 값");
		String data = in.nextLine(); // a, b, 가나다, 010-0000-0000, C
		in.close();
		// System.out.println(data);
		
		// 문제1) ','로 분할하고 각각의 데이터에 대해 앞뒤에 공백이 있으면 제거(split(), trim())
		String[] str = data.split(",");
		
		// Member타입으로 반환해야함
		Member member = null; // 아직 객체가 안만들어 졌음
				
		// 입력한 항목이 정확한지 개수로 확인함.
		if(str.length == 5) {
			// 객체 생성과 동시에 작업
			member = new Member(str[0].trim(), str[1].trim(),
								str[2].trim(), str[3].trim(),								
								str[4].trim(), new Date());			
		}
		
		return member;
	}
	
	public static Book inputBookDate() {
		Scanner scan = new Scanner(System.in);
		System.out.println("책정보입력 => 책번호,책제목,저자,가격,분류");
		String str = scan.next(); // nextLine아님
		// scan.close();
		
		String[] data = str.split(",");
		Book book = null;
		if(data.length==5) {
			// 형변환은 static메소드
			int no = Integer.parseInt(data[0]); // 형변환
			String title = data[1];
			String author = data[2];
			int price = Integer.parseInt(data[3]); // 형변환
			char cate = data[4].charAt(0); // 형변환
			
			book = new Book(no, title, author, price, cate,  new Date());
		}
		
		return book;
		
	}

}
