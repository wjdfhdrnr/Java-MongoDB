package day4;

import java.util.Date;

import day10.Member;

public class MemberMain {

	public static void main(String[] args) {
		
		// 1. 객체 생성(값 세팅)
		Member member = new Member("id", "pw", "ㄱ나다라ㅏㅏㅏ", "010-0000-0000", "C", new Date());
		System.out.println(member.toString());
		
		// 2. 세팅된 이름값이 유효한지 확인하기
		boolean result = member.invalidName();
		System.out.println("이름값 : " + result);
		
		
		// 3. 휴대폰 번호 길이가 정확한지 확인하기
		int result1 = member.invalidPhone();
		System.out.println("휴대폰 길이 유효 : " + result1) ;
		
		// 4. 권한 정보가 C와 S로만 되어 있는지 확인하기
		int result2 = member.invalidRole();
		System.out.println("접근유효 : " + result2) ;
		
		// 5. id는 길이가 30자 이내인지 확인하기
		boolean a = member.invalidID();
		System.out.println("id 길이 : " + a) ;
		
		//6. 연락처 정보가 000-0000-0000인데 00000000000으로 반환하기
		String b = member.changePhone();
		System.out.println("연락처 정보 변경 : " + b);
		

	}

}
