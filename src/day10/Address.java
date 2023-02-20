package day10;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class Address {
	
	private long code = 0L;
	private String address = null;
	private String postcode = null;
	private Date regdate = new Date(); 
	private Member memberid = null;
	


	public Address() {
		super();
	}
	
	public Address(long code, String address, String postcode, Member memberid) {
		super();
		this.code = code;
		this.address = address;
		this.postcode = postcode;
		this.memberid = memberid;
	}
	


	// 코드는 1000~9999 사이인지 확인
	public boolean invalidCode() {
		if(this.code>=1000L && this.code<=9999L) {
			return true;
		}
		return false;
	}
	
	// 주소는 100미만인지 확인
	public boolean invalidAddress() {
		if(this.address.length()<100) {
			return true;
		}
		return false;
	}
	
	// 우편번호가 5자리인지 확인
	public boolean invalidPostcode() {
		if(this.postcode.length()==5) {
			return true;
		}
		return false;
	}
	
	// 날짜에서 년만 반환하기(문자로 반환)
	public String getYear() {
		SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = obj.format(this.regdate);
		//System.out.println(str);
		return str.substring(0, 4);
	}

	
	// 날짜에서 월만 반환하기(문자로 반환)
	public String getMonth() {
		SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = obj.format(this.regdate);
		return str.substring(6,7);
	}
	
	// 날짜에서 일만 반환하기(문자로 반환)
	public String getDay() {
		SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = obj.format(this.regdate);
		return str.substring(9,10);
	}
	
	
	
	
	

}
