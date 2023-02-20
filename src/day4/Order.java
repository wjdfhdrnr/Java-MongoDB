package day4;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class Order {
	private int no = 0; 
	private int cnt = 0; 
	private Date date = null;
	private Item memberid = null;
	private Item itemcode = null;
	
	public Order() {
		super();
	}
	
	public Order(int no, int cnt, Date date, Item memberid, Item itemcode) {
		super();
		this.no = no;
		this.cnt = cnt;
		this.date = date;
		this.memberid = memberid;
		this.itemcode = itemcode;
	}
	
	

}
