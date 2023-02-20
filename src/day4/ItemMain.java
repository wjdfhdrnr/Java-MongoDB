package day4;

import java.util.Date;

import day10.Address;
import day10.Member;

public class ItemMain {

	public static void main(String[] args) {
		Member member = new Member("id", "pw", "ㄱ나다라ㅏㅏㅏ", "010-0000-0000", "C", new Date());
		Address address = new Address(1000,"부산","23432",member);
		Item item = new Item(1234, "물품명", "물품설명입니다물품설명입니다물품설명입니다물품설명입니다",1000,8,new Date(),member);
		
		System.out.println(item.toString());
		
		item.checkQuntity();
		System.out.println(item.getQuantity());
		
		int result1 = item.dcPrice(0.2f);
		System.out.println("할인가 : " + result1);
		
		int result2 = item.totalPrice();
		System.out.println("총 판매금액 : " + result2);
		
		String result3 = item.validContent();
		System.out.println("물품설명 : " + result3);
		
		String reverse = item.reverseName();
		System.out.println("이름 뒤집기 : " + reverse);
	}

}
