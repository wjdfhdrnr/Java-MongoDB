package day13;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main1 {

	public static void main(String[] args) {
		ItemDB iDB = new ItemDBImpl();
		
		/*
		// deleteItemOne
		int ret = iDB.deleteItemOne(100);
		System.out.println(ret);
		*/
		
		/*
		// deleteItemMany
		long no[] = {1008,1009,10000};
		int ret = iDB.deleteItemMany(no);
		System.out.println(ret);
		*/
		
		/*
		// updateItemOne
		Item item = new Item();
		item.setNo(1004);
		item.setName("갤럭시S23");
		item.setContent("블랙");
		item.setPrice(890000);
		item.setQuantity(27);
		
		int ret = iDB.updateItemOne(item);
		System.out.println(ret);
		*/
		
		/*
		// selectItemList
		List<Item> list = iDB.selectItemList(3);
		for(Item ret : list) {
			System.out.println("번호 => " + ret.getNo());
			System.out.println("이름 => " + ret.getName());
			System.out.println("내용 => " + ret.getContent());
			System.out.println("가격 => " + ret.getPrice());
			System.out.println("물량 => " + ret.getQuantity());
			System.out.println("등록일자 => " + ret.getRegdate());
			System.out.println("---------------------------------");
		}
		*/
		
		List<Item> list = iDB.selectItemList(100);
		
		// 문제1) 가격대별 수량 구하기
		// 1 ~ 999 => 1개
		// 1000 ~ 9999 => 1개
		// 10000 ~ 9999 => 1개
		// 100000원 이상 => 1개
		
		/*
		int[] cnt = {0,0,0,0};
		
		for(Item item : list) {
			if(item.getPrice()>=1 && item.getPrice()<1000) {
				cnt[0]++;
			}
			else if(item.getPrice()>=1000 && item.getPrice()<10000) {
				cnt[1]++;
			}
			else if(item.getPrice()>=10000 && item.getPrice()<100000) {
				cnt[2]++;
			}
			else {
				cnt[3]++;
			}
		}
		
		for(int i=0; i< cnt.length; i++) {
			System.out.println(cnt[i]);
		}
		*/
		
		// 문제2) 시간대별 재고수량 합계(Data to String으로 변환)
		// 0시 => 1개
		// 1시 => 2개
		// 2시 => 1개
		// ~~~
		// 23시 => 1개
		
		// int n = new Date().getHours(); // getHours 버전 올리면서 사용x 예정이라 줄끄여서뜸
		
		/*
		int b[] = new int[24];
		for(Item i : list) {
			Calendar c = Calendar.getInstance();
			c.setTime(i.getRegdate());
			int n = c.get(Calendar.HOUR);
			b[n]++;
		}
		for(int i=0; i<b.length; i++) {
			System.out.println(i+ "시간대 재고 : " + b[i]);
		}
		*/
		
		/*
		// 문제3) 재고수량이 1000이상인것만 3자리 콤마를 넣어서 출력
		// ex) 물품번호,  이름,   가격,   재고수량
		//      1001,  가나다,  300,  12,343,343
		NumberFormat numberFormat = NumberFormat.getInstance();		
		for(Item item : list) {
			if(item.getQuantity()>=1000) {
				System.out.println("물품번호 => " + item.getNo()
							+ ", 이름 => " + item.getName() + ", 가격 => " + item.getPrice()
							+ ", 재고수량 => " + numberFormat.format(item.getQuantity()) );
			}
		}
		*/
		
		/*
		int a = 12345678;
		DecimalFormat df = new DecimalFormat("###,###"); // 문자변경전 포멧
		String s = df.format(a); // 숫자 => 문자로 변경 포멧
		System.out.println(s);
		*/
		
		
		
	}
}
