package day7;

import java.util.List;

import day9.BoardDAO;
import day9.BoardDAOImpl;

public class Main {

	public static void main(String[] args) {
		
		/*
		Parent p = new Parent();		
		// 메소드는 객체변수.메소드호출()
		p.work();
		p.study();
		*/
		
		
		/*
		// 부모가 가지고 있는 메소드 그대로 이용
		Parent c1 = new Child1();
		c1.work();
		c1.study();
		
		Parent c2 = new Child2();
		c2.work(); // 재정의
		c2.study(); // 부모상속 기능 기대로
		*/
		
		
		/*
		new Frame1();
		*/
		
		
		/*
		// 인터페이이스 자체로는 객체를 만들 수 없음 => 기능을 정의만 했으므로
		//MyListener ml = new MyListener(); => 객체생성 오류남
		MyListener m1 = new MyInter1();
		MyListener m2 = new MyInter2();
		
		Print p = new Print();
		p.action(m1);
		*/
		
		
		/*
		// 배열은 생성시에 반드시 개수가 정해져야 함. ex)5
		int[] a = {2,5,1,23,4}; // 5개의 int형 공간이 생성, 위치는 0부터 4까지
		int b[] = new int[5]; // 5개의 int형 생성됨. 초기화 0으로 초기화
		String[] c = new String[5]; // 5개의 문자 타입 생성, 초기화 null
		
		b[0] = 12;
		b[1] = 15;
		b[2] = 233;
		
		// 실제적으로 추가된 개수와 상관없음. 생성할때의 개수일 뿐임. => 그래서 실무에서 배열 사용 어렵다.(추가된 갯수를 모름)
		System.out.println(b.length); // 5가 출력됨.		
		
		// 제너릭형태 => 객체를 생성하면 타입도 설정할 수 있는 클래스
		// ArrayList는 List 인터페이스를 상속받은 클래스(= List 인터페이스 구현 클래스)
		List<Integer> arr = new ArrayList<Integer>();
		List<String> arr1 = new ArrayList<String>();
		
		for(int i=0;i<3;i++) {
			arr.add(10+i); // 10 11 12
		}
		arr.size(); // 3이다.
		*/
		
		// ----------------------------------------- 20230207 Board Implements
		// 설계도면 객체 = new 구현한클래스의생성자();
		BoardDAO obj = new BoardDAOImpl();
		
		/*
		// 1) insertBoard
		// 고객이 입력한 내용에 해당
		Board board = new Board();
		board.setBrdTitle("제목");
		board.setBrdContent("내용");
		board.setBrdWriter("작성자");
		int ret = obj.insertBoard(board);
		System.out.println(ret);
		*/
		
		/*
		// 2) selectBoardOne
		Board brd = obj.selectBoardOne(4L);
		System.out.println(brd.toString());
		*/
		
		
		/*
		// 3) selectBoardList
		// 목록으로 전송됨. 목록은 반드시 반복문을 사용해서 1개씩 출력
		List<Board> list = obj.selectBoardList();
		
		// 방법(1) 배열의 위치를 이용하여 출력하는 방식
		for(int i=0; i<list.size(); i++) {
			Board one = list.get(i);
			System.out.println(one.getBrdNo() + "," + one.getBrdTitle() + "," + one.getBrdHit() + ","
					+ one.getBrdWriter() + "," + one.getBrdDate());			
		}
		
//		// 방법(2) list의 값을 1개씩 출력하는 방식 <= 더 간단한 방법
//				for(Board one : list) {
//					System.out.println(one.getBrdNo() + "," + one.getBrdTitle() + "," + one.getBrdHit() + ","
//							+ one.getBrdWriter() + "," + one.getBrdDate());
//		}
		 */
		
		
		/*
		// 4) selectBoardHitList
		List<Board> list = obj.selectBoardHitList(100);
		System.out.println(list);
		*/
		
		
		/*
		// 5) updateBoard
		Board b = new Board();
		b.setBrdNo(4);
		b.setBrdTitle("변경된 제목");
		b.setBrdContent("변경된 내용");
		b.setBrdWriter("변경된 작성자");
		
		int ret = obj.updateBoard(b);
		System.out.println(ret);
		*/
		
		/*
		// 6) deleteBoard
		int ret = obj.deleteBoard(5L);
		System.out.println(ret);
		*/
		
		
		
	}

}
