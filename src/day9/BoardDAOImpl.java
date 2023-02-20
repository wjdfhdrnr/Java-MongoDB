package day9;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import day8.Config;

public class BoardDAOImpl implements BoardDAO {

	private MongoCollection<Document> boardColl = null; // boards
	private MongoCollection<Document> seqColl = null; // sequence
	private MongoCollection<Document> replies = null;

	public BoardDAOImpl() {
		try {
			// 설계도면 객체 = 클래스면.정적메소드()
			// 정적메소드는 객체가 1개만 생성되기 때문에 리소스 낭비가 없음.
			MongoClient client = MongoClients.create(Config.URL);
			if (client != null) {
				this.boardColl = client.getDatabase("db218").getCollection(Config.BOARDCOL);
				this.seqColl = client.getDatabase("db218").getCollection("sequence");
				this.replies = client.getDatabase("db218").getCollection(Config.REPELYCOL);
				System.out.println("DB접속 성공지점");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB접속 실패했음");
		}
	}

	// 글제목, 내용, 작성자 정보만 전달
	// 글번호(시퀀스), 조회수 1, 날짜 현재시간
	@Override
	public int insertBoard(Board board) {
		try {
			// 시퀀스를 이용한 idx값을 받고 idx값을 1증가 시키기
			Bson filter = Filters.eq("_id", "SEQ_BOARD_NO");
			Bson update = Updates.inc("idx", 1); // 가져온값("idx") 1증가

			// 1을 가져오고 2로 바꿔줌("_id"와 "SEQ_BOARD_NO"가 일치한다, 1증가 시키겠다.) => 해당 내용 위에 2줄 작성
			Document doc = this.seqColl.findOneAndUpdate(filter, update);

			// 글번호, 조회수, 날짜현재시간 기본 세팅
			board.setBrdNo(doc.getLong("idx")); // 받은 idx값으로 글번호를 설정하기(DB에서 수동으로 넣은 idx 1을 가져오는 것)
			board.setBrdHit(100L);
			board.setBrdDate(new Date());

			// Board타입의 값을 Document로 복사 하세요
			Document doc1 = new Document();
			doc1.append("_id", board.getBrdNo());
			doc1.append("title", board.getBrdTitle());
			doc1.append("content", board.getBrdContent());
			doc1.append("writer", board.getBrdWriter());
			doc1.append("hit", board.getBrdHit());
			doc1.append("date", board.getBrdDate());

			InsertOneResult result = this.boardColl.insertOne(doc1);
			System.out.println(result);

			if (result.getInsertedId().asInt64().getValue() == board.getBrdNo()) {
				return 1; // 정확하게 데이터가 추가된 경우 1을 반환
			}
			return 0; // 실행은 됐으나 추가하지 못한 경우에 0을 반환
		} catch (Exception e) {
			e.printStackTrace();
			return -1; // 실행되지 못할 경우 -1, 치명적 오류, 시스템 오류 등..
		}
	}

	@Override
	public Board selectBoardOne(long no) {
		try {
			Bson filter = Filters.eq("_id", no);
			Document doc = this.boardColl.find(filter).first(); // 어차피 하나이므로(게시글번호가 기본키라서) first사용하면 Document타입으로 반환가능
																
			System.out.println(doc.toString());

			Board board = new Board();
			board.setBrdNo(doc.getLong("_id"));
			board.setBrdTitle(doc.getString("title"));
			board.setBrdContent(doc.getString("content"));
			board.setBrdWriter(doc.getString("writer"));
			board.setBrdHit(doc.getLong("hit"));
			board.setBrdDate(doc.getDate("date"));

			return board;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Board> selectBoardList() {
		// Board타입을 n개 보관할 수 있는 동적배열
		List<Board> list = new ArrayList<Board>();
		try {
			// 글번호를 기준으로 내림차순(-1), 오름차순(1)
			Bson sort = Filters.eq("_id", -1); // 글번호 기준 내림차순으로 출력되도록

			// MongoCursor<Document> == ArrayList<Document>
			MongoCursor<Document> docs = this.boardColl.find().sort(sort).cursor();
			while (docs.hasNext()) { // docs에 꺼낼 요소가 존재하나요?
				Document doc = docs.next(); // 1개 꺼내기(전체 개수 1감소했음)

				Board board = new Board();
				board.setBrdNo(doc.getLong("_id"));
				board.setBrdTitle(doc.getString("title"));
				board.setBrdContent(doc.getString("content"));
				board.setBrdWriter(doc.getString("writer"));
				board.setBrdHit(doc.getLong("hit"));
				board.setBrdDate(doc.getDate("date"));
				// Document => Board 복사
				list.add(board);

				// 답글개수
				Bson filter = Filters.eq("board", doc.getLong("_id"));
				long replyCount = replies.countDocuments(filter);
				board.setReplyCount(replyCount);

				// 답글번호
				FindIterable<Document> replyDocs = replies.find(filter);
				List<Long> replyList = new ArrayList<Long>();
				for (Document replyDoc : replyDocs) {
					// 답글 개수만큼 반복됨.
					replyList.add(replyDoc.getLong("_id"));
				}
				board.setReplyNoList(replyList);
			}
		} catch (Exception e) {
			// 오류 발생 처리
			e.printStackTrace();
			list = null;
		} finally {
			// 정상이든 오류든 모두 실행
		}
		return list;
	}

	// 조회수가 hit보다 이하 조회해서 메인에서 출력하기
	// Bson filter = Filters.lte("hit", hit);
	@Override
	public List<Board> selectBoardHitList(long hit) {
		// Board타입을 n개 보관할 수 있는 동적배열
		List<Board> list = new ArrayList<Board>();
		try {
			// 글번호를 기준으로 내림차순(-1), 오름차순(1)
			Bson sort = Filters.eq("_id", -1); // 글번호 기준 내림차순으로 출력되도록
			Bson filter = Filters.lte("hit", hit);

			// MongoCursor<Document> == ArrayList<Document>
			MongoCursor<Document> docs = this.boardColl.find(filter).sort(sort).cursor();
			while (docs.hasNext()) { // docs에 꺼낼 요소가 존재하나요?
				Document doc = docs.next(); // 1개 꺼내기(전체 개수 1감소했음)

				Board board = new Board();
				board.setBrdNo(doc.getLong("_id"));
				board.setBrdTitle(doc.getString("title"));
				board.setBrdContent(doc.getString("content"));
				board.setBrdWriter(doc.getString("writer"));
				board.setBrdHit(doc.getLong("hit"));
				board.setBrdDate(doc.getDate("date"));

				// Document => Board 복사
				list.add(board);

			}
		} catch (Exception e) {
			// 오류 발생 처리
			e.printStackTrace();
			list = null;
		} finally {
			// 정상이든 오류든 모두 실행
		}
		return list;

	}

	// 글번호와 제목, 내용, 작성자를 전송하면 해당글번호의 제목, 내용, 작성자를 변경하기
	@Override
	public int updateBoard(Board board) {
		try {
			Bson filter = Filters.eq("_id", board.getBrdNo());

			Bson update1 = Updates.set("title", board.getBrdTitle());
			Bson update2 = Updates.set("content", board.getBrdContent());
			Bson update3 = Updates.set("writer", board.getBrdWriter());

			Bson update = Updates.combine(update1, update2, update3);

			UpdateResult result = this.boardColl.updateOne(filter, update);
			System.out.println(result.toString());
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// 글번호가 전달되면 1개 삭제하기
	@Override
	public int deleteBoard(long no) {
		try {
			Bson filter = Filters.eq("_id", no);
			DeleteResult result = this.boardColl.deleteOne(filter);
			System.out.println(result.toString());

			if (result.getDeletedCount() == 1L) {
				return 1;
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// 댓글 수가 n개 이상인것만 조회
	@Override
	public List<Board> selectBoardReplyCount(int n) {
		try {
			// 1. 전체 게시글을 가져옴
			FindIterable<Document> list = this.boardColl.find();
			
			// 2. 반복한다.
			List<Board> retList = new ArrayList<Board>();
			for(Document doc : list) {
				// 3. 게시글 번호를 이용해서 답글의 개수를 구한다.
				Bson filter = Filters.eq("board", doc.getLong("_id"));
				long replyCount = this.replies.countDocuments(filter);
				if(replyCount >= n) {
					// 답글의 개수가 전달받는 n보다 크면
					Board board = new Board();
					board.setBrdNo(doc.getLong("_id"));
					board.setBrdTitle(doc.getString("title"));
					board.setBrdContent(doc.getString("content"));
					board.setBrdWriter(doc.getString("writer"));
					board.setBrdHit(doc.getLong("hit"));
					board.setBrdDate(doc.getDate("date"));
					
					retList.add(board);
				}
			}
			return retList;					
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

}
