package day14;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import day8.Config;

public class BoardDBImpl implements BoardDB{
	
	MongoCollection<Document> boards = null;
	MongoCollection<Document> sequence = null;


	public BoardDBImpl() {
		this.boards = DBConn.getInstance().getCollection(Config.BOARDCOL);
		this.sequence = DBConn.getInstance().getCollection(Config.RESEQUENCECOL);
	}
	
	// 게시판 글쓰기
	@Override
	public int insertBoardOne(Board board) {
		try {
			Bson filter = Filters.eq("_id", "SEQ_BOARD_NO");
			Bson update = Updates.inc("idx", 1);
			
			Document doc = this.sequence.findOneAndUpdate(filter, update);
			
			board.setNo(doc.getLong("idx"));
			board.setDate(new Date());
			
			Document doc1 = new Document();
			doc1.append("_id",board.getNo());
			doc1.append("title",board.getTitle());
			doc1.append("content",board.getContent());
			doc1.append("writer",board.getWriter());
			doc1.append("hit",board.getHit());
			doc1.append("date",board.getDate());
			
			InsertOneResult result = this.boards.insertOne(doc1);
			System.out.println(result);
			
			if(result.getInsertedId().asInt64().getValue()==board.getNo()) {
				return 1;
			}
			return 0;	
		}
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}

	// 게시판 조회(최신글 순으로 10개씩, 페이지네이션)
	@Override
	public List<Board> selectBoardList(int page) {
		try {
			Bson sort = Filters.eq("_id", -1);
			FindIterable<Document> docs =this.boards.find().sort(sort).skip((page-1)*10).limit(10);
					
			List<Board> list = new ArrayList<Board>();
			for(Document doc : docs) {
				Board board = new Board();
				board.setNo(doc.getLong("_id"));
				board.setTitle(doc.getString("title"));
				board.setContent(doc.getString("content"));
				board.setWriter(doc.getString("writer"));
				board.setHit(doc.getLong("hit"));
				board.setDate(doc.getDate("date"));
				
				list.add(board);
			}
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 게시판 수정(제목, 내용만 변경)
	@Override
	public int updateBoardOne(Board board) {
		try {
			
			Bson update1 = Updates.set("title", board.getTitle());
			Bson update2 = Updates.set("content", board.getContent());
			Bson update = Updates.combine(update1,update2);
			
			UpdateResult result = this.boards.updateOne(Filters.eq("_id", board.getNo()), update);
			return 1;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

	// 게시판 1개 조회
	@Override
	public Board selectBoardOne(long no) {
		try {
			Document doc = this.boards.find(Filters.eq("_id", no)).first();
			
			Board board = new Board();
			board.setNo(doc.getLong("_id"));
			board.setTitle(doc.getString("title"));
			board.setContent(doc.getString("content"));
			board.setWriter(doc.getString("writer"));
			board.setHit(doc.getLong("hit"));
			board.setDate(doc.getDate("date"));
			
			return board;	
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 게시판 삭제
	@Override
	public int deleteBoardOne(long id) {
		try {
			DeleteResult result = this.boards.deleteOne(Filters.eq("_id", id));
			return 1;
		}
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	
	
	

}
