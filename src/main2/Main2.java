package main2;

import java.util.Date;

import cls.Book;
import cls.BookStore;
import cls.Item;

public class Main2 {

	public static void main(String[] args) {
		
		/*[Book클래스]
		// 클래스명 객체명 = new 생성자(준비물);
		Book book = new Book(1,"java","가나다",40000,'B',new Date());
		
		
		book.setNo(1);
		book.setTitle("java");
		book.setAuthor("가나다");
		book.setPrice(40000);
		book.setCate('B');
		book.setDate(new Date());
		
		
		System.out.println(book.toString());
		*/
		
		// 서점이 생성됨. 책을 100권 보관할 수 있는 배열생성
		BookStore bookStore = new BookStore();
		
		bookStore.setPhone("051-707-7070");
		bookStore.setAddress("부산 남구");
		
		// 추가하고자 하는 책을 생성
		Book book = new Book(100,"java","저자",1230,'B',new Date());
		
		// 서점에 1권의 책 등록
		bookStore.insertBook(book);
		
		
		// 문제1) 임의의 책을 2권 생성한후 서점에 등록하기
		Book book1 = new Book(101,"java1","저자1",1231,'A',new Date());
		Book book2 = new Book(102,"java1","저자2",1232,'C',new Date());
		
		bookStore.insertBook(book1);
		bookStore.insertBook(book2);
		
		// 마지막 등록한 책 삭제
		bookStore.deleteBook();
		
		// 현재까지 등록된 책 조회
		//bookStore.selectBook();
		
		// [등록 책 할인율 변경]
		/*
		bookStore.discountPrice(0.2f);
		bookStore.selectBook();
		*/
		
		// [가격 1000원이상 책 수량]
		// bookStore.priceQuery(1000);
		
		// [분류 코드로 책 조회]
		//bookStore.printCate('B');
		
		
	}

}
