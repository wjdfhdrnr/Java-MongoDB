package day8;

import java.util.List;

public interface BookDB {
	
	// 책등록
	public int insertBook(Book book);
	
	// 책전체조회
	public List<Book> selectBookList();
	
	// 책 10개씩 조회
	public List<Book> selectBookListPage(int page);
	
	// 책 삭제
	public int deleteBook(int no); // 기본키 : no
	
	// 책 수정
	public int updateBook(Book book);
	
	// 책 1권 조회
	public Book selsectBookOne(int no);
	
	// n이상 가격에 해당하는 책 조회 
	public List<Book> selectBookPrice(long price);
	
	// 분류에 해당하는 항목만 조회
	public List<Book> selectBookCate(char cate);
}
