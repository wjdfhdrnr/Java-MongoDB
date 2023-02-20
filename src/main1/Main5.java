package main1;

import java.util.Date;

import cls.Board;

public class Main5 {

	public static void main(String[] args) {

		// 게시글 1개를 적절한 내용으로 추가한 후 출력하기
		// 1. 객체 생성
		Board brd = new Board();
		
		// 2. 객체를 기반으로 메소드를 사용해서 적절한 동작 수행
		brd.setBrdNo(1L); 
		brd.setBrdWriter("이성희");
		brd.setBrdTitle("java class");
		brd.setBrdContent("board작성");
		brd.setBrdHit(1234);
		Date date = new Date(); // 짧게 brd.setBrdDate(new Date());해도됨
		brd.setBrdDate(date);
		
		// 3. toString을 호출해서 현재의 값을 반환 후에 출력
		System.out.println(brd.toString());

	}

}
