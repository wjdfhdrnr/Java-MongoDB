package day6;

import java.util.Date;

public class Main1 {

	public static void main(String[] args) {
		
		//1. 객체 생성
		//db서버에 접속하고 members collection 접속
		MemberDB mDB = new MemberDB();
		//mDB.printMembers();
		//mDB.printMembersName("가나다");
		//mDB.printMemberRole("C");
		//mDB.printMemberOverAge(123);
		
		//2. 회원가입하고 싶은 임시 데이터(아이디, 암호, 이름, 연락처, 나이, 권한, 현재시간)
		//Member member = new Member("aaa1","pw1","이름","010",12,"C", new Date());
		
		//3. DB에 추가하는 메소드 수행
		//int ret = mDB.insertMember(member);
		//System.out.println(ret);
		
		/*
		// 문제3) 회원정보 수정
		Member member = new Member();
		member.setId("aaa");
		member.setName("변경될 이름");
		member.setPhone("010-1111-2222");
		member.setAge(33);
		
		int ret = mDB.updateMember(member);
		System.out.println(ret);
		*/
		
		// 문제4
		int ret = mDB.deleteMember("aaa");
		System.out.println(ret);
	}

}
