package cls;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 전체 데이터 세팅할 수 있는 생성자

// 책번호 no, 책제목 title, 저자 author, 가격 price, 분류 cate('A','B','C'), 등록일자 date
public class Book {
	
	private int no = 0; // Integer no1=null;와 보관형태 같음. <= 이 경우 null만 가능. 
	private String title = "";
	private String author = "";
	private int price = 0;
	private char cate = 'A';
	private Date date = null;
	
	/* [상단 @으로 대체]
	// 메소드(함수)
	public void print() {
		
	}
	
	// 생성자 Constructor 클래스명과 같음, 반환타입없음(보통 없는거 하나 만들고, 전체 데이터 세팅할 수 있는거 총 2개 만듦)
	public Book() {
		super();
	}
	
	
	
	
	public Book(int no, String title, String author, int price, char cate, Date date) {
		super();
		this.no = no;
		this.title = title;
		this.author = author;
		this.price = price;
		this.cate = cate;
		this.date = date;
	}
	*/

	
	
	
	

}
