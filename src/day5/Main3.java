package day5;

import java.util.ArrayList;

public class Main3 {

	public static void main(String[] args) {
		
		// 배열은 원시타입, 객체타입 다 가능함. 객체타입 초기값은 null. 
		int[] a = new int[5]; // 5개 만들어짐, 초기값 0
		int[] b = {1,2,3,4,5}; // 5개 만들어짐, 초기밧 {} 설정
		String c[] = new String[5]; // 5개 만들어짐, 초기값 null
		Integer d[] = new Integer[5]; // 5개 만들어짐, 초기값 null
		
		// c.length() : 데이터가 안들어가있어도 배열의 길이인 5출력
		// 컬렉션 : 배열의 개수를 모를때 사용하기 용이(=가변 배열)
		ArrayList<Integer> e = new ArrayList<Integer>(); 
		e.add(100);
		e.add(200);		
		e.add(300);		
		e.add(400);		
		System.out.println(e.size()); // 출력 : 4
		e.remove(2);
		System.out.println(e.size()); // 출력 : 3
		
		for(int i=0; i<e.size(); i++) { // 0 1 2
			System.out.print(e.get(i) + " ");
		}
		
		System.out.println();
		
		// 뒤집기
		for(int i=e.size()-1; i>=0; i-- ) {
			System.out.print(e.get(i) + " ");
		}
		
	}

}
