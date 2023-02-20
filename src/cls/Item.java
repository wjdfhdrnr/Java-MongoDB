package cls;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 클래스
@Getter
@Setter
@ToString
public class Item {
	
	private long no = 0L; // 물품번호
	private String name = null; // 물품명
	private String content = null; // 물품내용
	private int price = 0; // 가격
	private long quantity = 0L; // 수량
	private Date date = null;
	
	// 메소드(특정한 기능 구현)
	public void discountPrice(float per) {
		// 현재 가격에서 per(=할인)만큼 빼야됨
		this.price = (int)(this.price - (this.price*per));
	}
	
	public void checkQuantity(int num) {
		if(this.quantity<num) {
			//this.quantity+=num;
			this.quantity=1000;
		}
		
		
	}
	
	

	
}
