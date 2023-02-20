package day4;

import java.util.Date;

import day10.Member;

public class OrderMain {

	public static void main(String[] args) {
		Member member = new Member("id", "pw", "ㄱ나다라ㅏㅏㅏ", "010-0000-0000", "C", new Date());
		Item item = new Item(1234, "물품명", "물품설명입니다.물품설명입니다.물품설명입니다.",1000,8,new Date(),member);
		Order order = new Order(100,15,new Date(),item,item);
		
		System.out.println(item.toString());
		

	}

}
