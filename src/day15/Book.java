package day15;

import java.util.Date;
import lombok.Data;

@Data
// 책 타입을 생성함
public class Book {
	
	public long code = 0L;
	private String title = null;
	private String author = null;
	private long price = 0L;
	private Date regdate = new Date();
	
}
