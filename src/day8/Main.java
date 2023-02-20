package day8;

import day8.frame.BookInsertFrame;
import day8.frame.BookSelectListFrame;
import day8.frame.BookSelectListPageFrame;

public class Main {

	// 화면을 실행시키는 역할
	public static void main(String[] args) {
		// 1) insertBook 기능
		//new BookInsertFrame();
		
		// 2) selectBookList 기능
		//new BookSelectListFrame();
		
		/*
		// 데이터 여러개 넣기
		BookDB bookDB = new BookDBImpl();
		for(int i=0; i<23; i++) {
			Book book = new Book();
			book.setTitle("제목"+i);
			book.setAuthor("저자"+i);
			book.setPrice(10000+i);
			book.setCate('A');
			bookDB.insertBook(book);
		}
		*/
		
		// 3) selectBookListPage 기능
		new BookSelectListPageFrame();
		
		
		
		

	}

}
