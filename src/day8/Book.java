package day8;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
	
	private int no = 0;  
	private String title = "";
	private String author = "";
	private long price = 0;
	private char cate = 'A';
	private Date date = null;
}