package day4;

import java.util.Date;

import day10.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class Item {
	private long code = 0L;
	private String name = null;
	private String content = null;
	private int price = 0;
	private int quantity = 0;
	private Date regdate = null;
	private Member memberid = null;
	
	public Item() {
		super();
	}

	public Item(long code, String name, String content, int price, int quantity, Date regdate, Member memberid) {
		super();
		this.code = code;
		this.name = name;
		this.content = content;
		this.price = price;
		this.quantity = quantity;
		this.regdate = regdate;
		this.memberid = memberid;
	}
	
	
	
	// 수량이 n개 미만이면 n개로 변경하는 메소드
	public void checkQuntity(){
		if(this.quantity<10) {
			this.quantity = 10;
		}
	}
	
	// 가격에 할인율 만큼 빼서 리턴하는 메소드
	public int dcPrice(float per) {
		int dcprice = (int)(this.price-(this.price*per));
		this.setPrice(dcprice); // price값 할인가로 업데이트
		return dcprice;
	}
	
	// 총 판매금액을 리턴하는 메소드(가격*수량)
	public int totalPrice() {
		return(this.price * this.quantity);
	}
	// 내용이 20자 이상이면 ex)12345678901234567890...으로 변환하는 메소드
	public String validContent() {
		if(this.content.length()>=20) {
			return(this.content.substring(0, 20)+"...");
		}
		return this.content;
	
	}
	// 이름을 뒤집어서 반환하는 메소드 ex)가나다 => 다나가
	public String reverseName() {
		/*
		StringBuffer obj = new StringBuffer(this.name);
		String re = obj.reverse().toString();
		return re;
		*/
		int i=0;
		String ret = ""; // 문자를 누적할 변수
		for(i=this.name.length()-1; i>=0; i--) {
			char tmp = this.name.charAt(i);
			ret+=tmp;
		}
		return ret;
	}

	
	
	
	
	

}
