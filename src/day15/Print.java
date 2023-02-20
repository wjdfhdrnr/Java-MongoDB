package day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Print {

	// n이 오면 n단을 출력하는 메소드 구현
	// ex) 3
	// 3*1=3
	// ~
	// 3*9=27
	public void gugudan(int n) {
		for(int i=1; i<10; i++) {
			System.out.println(n + " * " + i + " = " + n*i);
		}
	}
	
	// n개의 정수형이 오면 합을 구해서 반환하는 메소드 구현
	public long sum(List<Long> list) {
		long sum = 0; 
		for(Long ret : list) {
			sum += ret; 
		 }
		return sum;
	}
	
	// n개의 실수형이 전달되면 합과 평균을 구해서 반환하는 메소드 구현
	public Map<String, Object> sumAvg(List<Double> list){
		double sum = 0.0d;
		double avg = 0.0d;
		
		for(Double ret : list) {
			sum += ret;
		}
		
		avg = sum/list.size();
		
		Map<String,Object> map = new HashMap<>();
		map.put("sum", sum);
		map.put("avg", avg);
		
		return map;
	}
	
	// 3권 정도 임의의 값으로 추가한 후 실행하기
	public void printBook(List<Book> book) {
		for(Book list : book) {
			System.out.println("책번호 : " + list.getCode());
			System.out.println("제목 : " + list.getTitle());
			System.out.println("저자 : " + list.getAuthor());
			System.out.println("가격 : " + list.getPrice());
			System.out.println("일자 : " + list.getRegdate());
			System.out.println("------------------------------------");
		}
		
	}
	
	// 전체 책과 필터하는 가격 조건 전달 받으면 가격보다 큰 책만 반환
	public List<Book> queryPrice(List<Book> book, long price){
		
		List<Book> list = new ArrayList<>();
		for(Book one: book) {
			if(one.getPrice() > price) {
				list.add(one);
			}
		}
		return list;
		
		
	}
	
	// 가격에서 일의 자리가 0인것만 조회
	// ex)12233 => X
	// ex)12300 => O
	public List<Map<String, Object>> queryPrice(List<Book> book){
		List<Map<String, Object>> list = new ArrayList<>();
		for(Book one : book) {
			if(one.getPrice()%10 == 0) {
				Map<String, Object> map = new HashMap<>();
				map.put("code", one.getCode());
				map.put("title", one.getTitle());
				map.put("author", one.getAuthor());
				map.put("price", one.getPrice());
				map.put("regdate", one.getRegdate());
				list.add(map);
			}
		}
		return list;
	}

}
