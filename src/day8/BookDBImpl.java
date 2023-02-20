package day8;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;

public class BookDBImpl implements BookDB {
	// 공통변수 : 생성자, 메소드 모두 접근 가능한 변수
	private MongoCollection<Document> sequence = null;
	private MongoCollection<Document> books = null;
	
	
			
	// 생성자
	public BookDBImpl() {
		try {
			MongoDatabase db = MongoClients.create(Config.URL).getDatabase(Config.DBNAME);
			this.sequence = db.getCollection("sequence");
			this.books = db.getCollection("books");
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public int insertBook(Book book) {
		try {
			// 책번호(기본키), 등록일자는 자동으로 등록되도록
			Bson filter = Filters.eq("_id","SEQ_BOOK_NO");
			Bson update = Updates.inc("idx", 1);
			Document doc = this.sequence.findOneAndUpdate(filter, update);
			
			Document doc1 = new Document();
			doc1.append("_id", doc.getInteger("idx"));
			doc1.append("title", book.getTitle());
			doc1.append("author", book.getAuthor());
			doc1.append("price", book.getPrice());
			doc1.append("cate", book.getCate());
			doc1.append("regdate", new Date());
			InsertOneResult result = this.books.insertOne(doc1);
			System.out.println(result);
			
			if(result.getInsertedId().asInt32().getValue()==doc.getInteger("idx")) {
				return 1;
			}
			return 0;
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<Book> selectBookList() {
		try {
			// 반환 타입을 위한 빈 배열 객체 생성(비어있음)
			List<Book> list = new ArrayList<Book>();
			
			FindIterable<Document> docs = this.books.find();
			// docs의 값을 doc에 list로 다 복사하기
			for(Document doc: docs) { 
				Book book = new Book();
				book.setNo(doc.getInteger("_id"));
				book.setTitle(doc.getString("title"));
				book.setAuthor(doc.getString("author"));
				book.setPrice(doc.getLong("price"));
				book.setCate(doc.getString("cate").charAt(0)); // String=>char
				book.setDate(doc.getDate("regdate"));
				
				list.add(book); // 반복 횟수 만큼 list에 추가하기
			}
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	// 데이터를 최소 21개 이상을 추가하고 해보기
	// BookSelectListPageFrame.java 만들기
	@Override
	public List<Book> selectBookListPage(int page) {
		List<Book> list = new ArrayList<Book>();
		try {
			Bson sort = Filters.eq("_id", -1); // 책번호를 기준으로 내림차순(-1) // MongoDB에서 {_id:-1}표현을 대체하기 위해 사용 
			// sort(),skip(),limit() 메소드로 find()메소드 상황에 따라 제약걸어 활용 
			// page=1 => o skip, page=2 => 10 skip, page=3 => 20 skip
			FindIterable<Document> docs = this.books.find().sort(sort).skip(10*(page-1)).limit(10);
			
			for(Document doc: docs) { 
				Book book = new Book();
				book.setNo(doc.getInteger("_id"));
				book.setTitle(doc.getString("title"));
				book.setAuthor(doc.getString("author"));
				book.setPrice(doc.getLong("price"));
				book.setCate(doc.getString("cate").charAt(0)); // String=>char
				book.setDate(doc.getDate("regdate"));
				
				list.add(book);
			}
			return list;
			
		}			
		catch(Exception e) {
			return null;
		}		
	}

	@Override
	public int deleteBook(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBook(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Book selsectBookOne(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> selectBookPrice(long price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> selectBookCate(char cate) {
		// TODO Auto-generated method stub
		return null;
	}

}
