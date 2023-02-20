package day14;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		//DBConn db = DBConn.getInstance();
		
		//MemberDBImpl dbm = new MemberDBImpl();
		
		/*
		// 1) memberJoin
		
		Member member = new Member();
		member.setId("HHHID");
		member.setPassword("HHHPW");
		member.setName("이름H");
		member.setPhone("010-1234-5678");
		member.setRole("B");
		member.setAge(45);
		member.setRegdate(new Date());
		
		int ret = dbm.memberJoin(member);
		System.out.println(ret);
		*/
		
		/*
		// 2) memberLogin
		Map<String, Object> map = new HashMap<>();
		map.put("_id", "AAAID");
		map.put("password","AAAPW");
		
		Member member = dbm.memberLogin(map);
		if(member == null) {
			System.out.println("아이디 또는 암호가 틀립니다.");
		}
		else {
			System.out.println(member.getName() + " 로그인에 성공했습니다.");
		}
		*/
		
		
		
		/*
		// 3) memberSelectOne
		Member m = dbm.memberSelectOne("AAAID");
		System.out.println("아이디 => " + m.getId());
		System.out.println("비밀번호 => " + m.getPassword());
		System.out.println("이름 => " + m.getName());
		System.out.println("번호 => " + m.getPhone());
		System.out.println("둥굽 => " + m.getRole());
		System.out.println("나이 => " + m.getAge());
		System.out.println("회원가입날짜 => " + m.getRegdate());
		*/
		
		/*
		// 4) memberUpdateOne
		Member member = new Member();
		member.setId("bbb22");
		member.setName("이름B");
		member.setPhone("010-0000-5678");
		member.setRole("B");
		member.setAge(34);
		member.setRegdate(new Date());
		
		int ret = dbm.memberUpdateOne(member);
		System.out.println(ret);
		*/
		
		/*
		// 5) memberUpdatePwOne
		Map<String, Object> map = new HashMap<>();
		map.put("_id", "ccc1");
		map.put("password1", "cPassword");
		
		
		int ret = dbm.memberUpdatePwOne(map);
		System.out.println(ret);
		*/
		
		/*
		// 6) memberDeleteOne
		int ret = dbm.memberDeleteOne("ccc2");
		System.out.println(ret);
		*/
		
		// ********************************************************
		
		BoardDBImpl dbm = new BoardDBImpl();
		
		/*
		// 1) insertBoardOne
		 
		Board board = new Board();
		board.setTitle("Java");
		board.setContent("객체지향프로그래밍");
		board.setWriter("작성자0");
		board.setHit(0L);
		
		int ret = dbm.insertBoardOne(board);
		System.out.println(ret);
		*/
		
		/*
		// 2) insertBoardOne
		List<Board> list = dbm.selectBoardList(3);
		for(Board b : list) {
			System.out.println(b);
		}
		*/
		
		/*
		// 3) UpdateBoardOne
		Board board = new Board();
		board.setNo(7L);
		board.setTitle("Oracle");
		board.setContent("SQL쿼리 배우기");
		
		int ret = dbm.updateBoardOne(board);
		System.out.println(ret);
		*/
		
		/*
		// 4) selectBoardOne
		Board b = dbm.selectBoardOne(8L);
		System.out.println("게시글번호 => " + b.getNo());
		System.out.println("게시글제목 => " + b.getTitle());
		System.out.println("게시글내용 => " + b.getContent());
		System.out.println("게시글작성자 => " + b.getWriter());
		System.out.println("게시글조회수 => " + b.getHit());
		System.out.println("게시글날짜 => " + b.getDate());
		*/
		
		/*
		// 5) deleteBoardOne
		int ret = dbm.deleteBoardOne(6L);
		System.out.println(ret);
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
