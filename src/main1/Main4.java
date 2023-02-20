package main1;

import java.util.Date;

import cls.Member;

public class Main4 {

	public static void main(String[] args) {
		// 클래스명 객체명 = new 클래스명();
		Member member = new Member(); // Member클래스를 별도로 다른 파일에 만들어놓음으로서 여기서 간단하게 선언할 수 있다.
		
		member.setUserId("aaa"); // setUserId는 반환값이 없으므로 선언x
		member.setUserAge(26);
		member.setUserEmail("yam3472@naver.com");
		member.setUserPw("bbb");
		member.setUserPhone("010-1234-5678");
		
		Date date = new Date();
		member.setUseDate(date);
		
		System.out.println(member.toString()); // 객제 정보 출력됨
		
		String result = member.getUserId(); // 위 setUserId한 값이 변경됐는지 값을 가져와서 확인하기 위해 getUserId사용.
		System.out.println(result);
		
		
		
	}

}
