package cls;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

// 전화번호, 위치, 보유책(최대 100개 보유)
public class BookStore {
	
	private String phone = ""; // 서점 연락처
	private String address = ""; // 서점위치
	private Book[] books = null; // 책
	
	private int idx = 0; // 현재 배열에 추가되어 있는 책의 위치 // idx는 생성자 만들면 안됨.
	
	// 생성자 1번만 사용가능함. 반환값없음, 클래스명과 정확하게 일치.
	// 준비물이 없는 빈 생성자
	public BookStore() {
		this.books = new Book[100]; // 0~99까지임 // this없어도됨
	}
	
	// 책등록하는 메소드 필요
	public void insertBook(Book book) {
		if(this.idx >= 100) {
			System.out.println("책 추가 불가");
		}
		else {
			books[this.idx] = book;
			idx++;
		}
		
	}
	
	// '현재'까지 등록된 책 목록 출력
	public void selectBook() {
		int i=0;
		for(i=0;i<this.idx;i++) {
			System.out.println(books[i].toString());
		}
	}
	
	// 마지막 등록한 책을 삭제하는 메소드(마지막=>idx-1)
	public void deleteBook() {
		if(this.idx > 0) {
			this.idx--;
		}
	}
	
	// 문제1) 등록한 책의 가격을 전달받은 만큼 할인율 변경 메소드
	public int discountPrice(float per) {
		for(int i=0;i<this.idx;i++) {
			int price = this.books[i].getPrice();
			
			//실수형 = > 정수로 형변환시 결과 값에 손실이 일어남.
			int result = (int)(price-(price*per));
			this.books[i].setPrice(result);
		}
		return 1;
	}
	
	// 문제2) 가격이 n원 이상인 책 수량을 반환하는 메소드
	public int priceQuery(int pr) {
		short cnt = 0;
		for(int i=0;i<this.idx;i++) {
			if(this.books[i].getPrice()>=pr) {
				cnt+=1;
			}
		}
		return cnt;
	}
	
	// 문제3) 전달받은 분류코드 항목만 출력하는 메소드(분류 코드를 조회)
	public void printCate(char cate) {
		for(int i = 0; i<this.idx; i++) {
			if(this.books[i].getCate() == cate) {
				System.out.println(books[i].toString());
			}
		}
	}
}
