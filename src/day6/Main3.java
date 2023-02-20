package day6;

import java.util.Date;

public class Main3 {

	public static void main(String[] args) {
		ItemDB mDB = new ItemDB();
		
		
		// 1) 물품등록
		Item item = new Item(10000L, "이름", "내용", 1000, 5, new Date());	
		int ret = mDB.insertItem(item);
		System.out.println(ret);
		
		
		// 2) 전체물품 출력
		//mDB.printItems();
		
		/*
		// 3) 물품명, 물품내용, 가격, 수량 변경
		Item item = new Item();
		item.setCode(10L);
		item.setName("변경된 물품명");
		item.setContent("변경된 물품내용");
		item.setPrice(1000000);
		item.setQuantity(33);
		
		int ret = mDB.updateItem(item);
		System.out.println(ret);
		*/
		
		/*
		// 4) 물품정보 삭제
		int ret = mDB.deleteItem(100L);
		System.out.println(ret);
		*/
		

	}

}
