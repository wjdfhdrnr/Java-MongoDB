package day4;

import java.util.Date;

import day10.Address;
import day10.Member;

public class AddressMain {

	public static void main(String[] args) {
		Member member = new Member("id", "pw", "ㄱ나다라ㅏㅏㅏ", "010-0000-0000", "C", new Date());
		Address address = new Address(1000,"부산","23432",member);
		System.out.println(address.toString());
		
		boolean result = address.invalidCode();
		System.out.println("코드 유효 : " + result);
		
		boolean result1 = address.invalidAddress();
		System.out.println("주소 유효 : " + result1);
		
		boolean result2 = address.invalidPostcode();
		System.out.println("우편번호 유효 : " + result2);
		
		String year = address.getYear();
		System.out.println(year);
		
		String month = address.getMonth();
		System.out.println(month);
		
		String day = address.getDay();
		System.out.println(day);

	}

}
