package day5;

import java.util.ArrayList;

import cls.Book;
import day10.Member;

// 출력을 담당하는 클래스
public class Output {
	
	// 변수 X
	
	public static void printMember(Member member) {
		System.out.println("=========가입정보========");
		System.out.println("아이디 : " + member.getId());
		System.out.println("암호 : " + member.getPassword());
		System.out.println("이름 : " + member.getName());
		System.out.println("연락처 : " + member.getPhone());
		System.out.println("권한 : " + member.getRole());
		System.out.println("가입일자 : " + member.getRegdate());
		System.out.println("======================");
		
	}
	
	public static void printBook(Book book) {
		System.out.println("=========책등록정보========");
		System.out.println("책번호 : " + book.getNo());
		System.out.println("책제목 : " + book.getTitle());
		System.out.println("저자 : " + book.getAuthor());
		System.out.println("가격 : " + book.getPrice());
		System.out.println("분류 : " + book.getCate());
		System.out.println("등록일자 : " + book.getDate());
		System.out.println("======================");
		
	}
	
	
	public static void printBookList(ArrayList<Book> list) {
		for(int i=0;i<list.size();i++) {
			
			Book oneBook = list.get(i);
			printBook(oneBook); // 위에서만든 printBook메소드
			
		}
	}
	

}
