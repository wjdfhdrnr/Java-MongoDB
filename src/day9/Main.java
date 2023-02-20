package day9;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		try {
			// 1. 접속, 컬렉션2개 객체 변수보관
			ReplyDB replyDB = new ReplyDBImpl();

			/*
			 // 3. 답글 객체 
			 Reply reply = new Reply(); 
			 reply.setContent("답글내용");
			 reply.setWriter("답글작성자");
			 
			 Board board = new Board(); 
			 board.setBrdNo(4L);
			 reply.setBoard(board);
			 

			// 2. 추가하는 메소드(Reply타입 인자필요)
						
			// (1) insertReply
			short ret = replyDB.insertReply(reply);
			System.out.println(ret);
			*/
			
			 
			/*
			// (2) selectReplyOne
			Reply reply = replyDB.selectReplyOne(205);
			if (reply != null) {
				System.out.println("답글번호 => " + reply.getReplyNo());
				System.out.println("답글내용 => " + reply.getContent());
				System.out.println("답글작성자 => " + reply.getWriter());
				System.out.println("답글일자 => " + reply.getRegdate());
				System.out.println("원본게시글정보 => " + reply.getBoard());
			}
			*/
			
			/*
			// (3) selectReplyList
			// 원본 게시글을 이용한 전체 답글 조회하기, list 내부가 vector, arraylist인지 알 필요 없음.
			List<Reply> list = replyDB.selectReplyList(3L);
			for(Reply reply : list) {
				if(reply != null) {
					System.out.println("답글번호 => " + reply.getReplyNo());
					System.out.println("답글내용 => " + reply.getContent());
					System.out.println("답글작성자 => " + reply.getWriter());
					System.out.println("답글일자 => " + reply.getRegdate());
					System.out.println("--------------------------");
				}
			}
			*/
			
			/*
			// (4) deleteReply
			short ret = replyDB.deleteReply(205);
			System.out.println(ret);
			*/
			
			
			/*
			// (5) updateReply
			Reply reply = new Reply(); 
			reply.setReplyNo(209L);
			reply.setContent("업데이트된 답글내용");
			reply.setWriter("업데이트된 답글작성자");
			replyDB.updateReply(reply);
			*/
			
			//*****************************************************************************************
			
			
			// Board에 Reply 정보추가
			BoardDAO boardDAO = new BoardDAOImpl();
			
			
			/*
			// Board selectBoardList 출력 정보 추가
			List<Board> list = boardDAO.selectBoardList();
			for(Board board : list) {
				System.out.println("게시글번호 => " + board.getBrdNo());
				System.out.println("게시글제목 => " + board.getBrdTitle());
				System.out.println("게시글작성자 => " + board.getBrdContent());
				System.out.println("게시글조회수 => " + board.getBrdHit());
				System.out.println("게시글날짜 => " + board.getBrdDate());
				System.out.println("답글개수 => " + board.getReplyCount());
				System.out.println("답글번호는 => " + board.getReplyNoList().toString());
				System.out.println("-------------------------------------------");
			}
			*/
			
			
			// selectBoardReplyCount
			List<Board> list = boardDAO.selectBoardReplyCount(2);
			for(Board board:list) {
				System.out.println("게시글번호 => " + board.getBrdNo());
				System.out.println("게시글제목 => " + board.getBrdTitle());
				System.out.println("게시글작성자 => " + board.getBrdContent());
				System.out.println("게시글조회수 => " + board.getBrdHit());
				System.out.println("게시글날짜 => " + board.getBrdDate());
				System.out.println("-------------------------------------------");				
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
