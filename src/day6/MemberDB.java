package day6;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

// 몽고 DB연동

public class MemberDB {
	
	// 변수는 모든 메소드에 사용 가능하기 위해
	private MongoCollection<Document> collection = null; 
		
	// 생성자
	public MemberDB() {
		// 공통변수가 아니기 때문에 생성자 내부에서만 사용가능한 변수로 생성
		// final을 붙이면 생성시 값으로 프로그램이 끝날때 까지 유지됨(변수값 새롭게 대입 불가)
		// mongodb://아이디:암호@서버주소:포트번호:DB명
		final String url = "mongodb://id218:pw218@1.234.5.158:37017/db218";
		
		// static 클래스를 통해서 접속이 가능함.
		MongoClient client = MongoClients.create(url);
		MongoDatabase db = client.getDatabase("db218");
		this.collection = db.getCollection("members");
	}
	
		
	// 회원가입 메소드
	public int insertMember(Member member) {
		try {
			// 정상동작
			Document doc = new Document();
			doc.append("_id", member.getId()); // 기본키(고유한값만 넣을 수 있음)
			doc.append("password", member.getPassword());
			doc.append("name", member.getName());
			doc.append("phone", member.getPhone());
			doc.append("role", member.getRole());
			doc.append("age", member.getAge());
			doc.append("regdate", member.getRegdate());
			
			InsertOneResult result = this.collection.insertOne(doc);
			System.out.println(result.toString());
			return 1;
		} 
		catch(Exception e) {
			// 정상동작중에서 오류가 발생시 이쪽으로 수행됨
			// Exception클래스의 e변수에 오류의 정보(오류 메시지)가 전송되게 됨
			e.printStackTrace(); // 오류메시지 전체적으로 출력해줌. 개발자를 위한 기능
			return -1;
		}
	}
	
	// 전체 회원 조회 메소드
	public void printMembers() {
		MongoCursor<Document> list =  this.collection.find().cursor();
		// 가지고 오려하는 데이터 1000개 => 500개만 출력(X)
		// DB에서 조건에 해당되는 정확한 데이터들만 가져오도록(다 가져와서 필터X)
		// 반복자 => 처음부터 끝까지 전체다 반복할 거라고 가정
		// 몇개가 존재하는지 모름
		
		// 가져올 데이터가 있나요?
		while(list.hasNext()) { // hasNext : 그 다음걸 가져올 데이터가 있는지
			// 그러면 1개 가져갈께요.
			Document doc = list.next();			
			System.out.println("아이디 => " + doc.getString("_id"));
			System.out.println("암호 => " + doc.getString("password"));
			System.out.println("나이 => " + doc.getInteger("age"));
			System.out.println("------------------------------------");
		}
	}
	
	// 이름이 "가나다"인 데이터만 조회
	public void printMembersName(String searchName) {
		// 키(필드)가 name인것 중에서 searchName과 정확하게 일치하는거 필터
		Bson filter = Filters.eq("name", searchName); // Bson : Document 데이터 포맷
		printAction(filter);
			
	}
	
	// 문제1) 고객, 판매자만 조회하는 필터
	public void printMemberRole(String searchRole) {
		Bson filter = Filters.eq("role", searchRole);
		printAction(filter);
	}
	
	// 문제2) 나이가 n이상인 것만 필터
	public void printMemberOverAge(int searchAge) {
		Bson filter = Filters.gte("age", searchAge);
		printAction(filter);
		
	}
	
	// 문제3) 회원정보 수정
	// 바꿀 수 있는 정보 : 이름,연락처,나이 => 바꾸고자하는 요소 이 3가지와 id(기본키)까지 총 4개의 항목 필요
	public int updateMember(Member member) {
		try {
			// 변경하고자 하는 항목의 조건
			Bson filter = Filters.eq("_id", member.getId());
			// 변경할 항목들...
			Bson update1 = Updates.set("name", member.getName());
			Bson update2 = Updates.set("phone", member.getPhone());
			Bson update3 = Updates.set("age", member.getAge());
			
			// updateOne(조건, 변경값) => 변경값이 하나의 Bson만 가능.. combine
			Bson update = Updates.combine(update1, update2, update3);
			
			UpdateResult result = this.collection.updateOne(filter, update);
			System.out.println(result.toString());
			return 1;
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		
	}
	
	
	// 문제4) 회원탈퇴 삭제
	public int deleteMember(String id) {
		try {
			Bson filter = Filters.eq("_id", id); // 굳이 Member타입 들고올 필요없이 id만 있으면 삭제가능
			DeleteResult result = this.collection.deleteOne(filter);
			System.out.println(result.toString());
			
			if(result.getDeletedCount() == 1L) { 
				return 1; // 일치하는게 있어서 1개를 지움
			}
			return 0; // 일치하는게 없어서 못지움(출력문 : AcknowledgedDeleteResult{deletedCount=0})
		}
		catch(Exception e){
			e.printStackTrace();
			return -1;
			
		}
	}
	
	private void printAction(Bson filter) {
		MongoCursor<Document> list = this.collection.find(filter).iterator();
		while(list.hasNext()) { 
			Document doc = list.next();
			System.out.println("아이디 => " + doc.getString("_id"));
			System.out.println("암호 => " + doc.getString("password"));
			System.out.println("이름 => " + doc.getString("name"));
			System.out.println("연락처 => " + doc.getString("phone"));
			System.out.println("나이 => " + doc.getInteger("age"));
			System.out.println("권환 => " + doc.getString("role"));
			System.out.println("시간 => " + doc.getDate("regdate"));
			System.out.println("------------------------------------");
		}
	}
}

