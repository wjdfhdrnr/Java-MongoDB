package day14;

import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import day8.Config;

public class MemberDBImpl implements MemberDB{
	
	MongoCollection<Document> members = null;

	public MemberDBImpl() {
		members = DBConn.getInstance().getCollection(Config.MEMBERCOL);
		
	}
	
	// 회원가입
	@Override
	public int memberJoin(Member member) {
		try {
			Document join = new Document();
			join.append("_id", member.getId());
			join.append("password", member.getPassword());
			join.append("name", member.getName());
			join.append("phone", member.getPhone());
			join.append("role", member.getRole());
			join.append("age", member.getAge());
			join.append("regdate", member.getRegdate());
			
			InsertOneResult result = this.members.insertOne(join);
			System.out.println(result);
			
			if(result.getInsertedId().asString().getValue().equals(member.getId())) {
				return 1;
			}
			return 0;
		}
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	// 로그인
	// 1. 아이디를 이용해서 정보를 가져옴. 아이디와 암호가 일치하는 확인후에 반환
	// 2. 아이디, 암호를 and 필터를 이용해서 조회
	@Override
	public Member memberLogin(Map<String, Object> map) {
		try {
			
			String id = (String)map.get("_id");
			String pw = (String)map.get("password");
			
			Document doc = this.members.find(Filters.eq("_id", map.get("_id"))).first();
			
			if(doc.getString("_id").equals(id)
				&&(doc.getString("password")).equals(pw)) {
				Member member = new Member();
				member.setId(doc.getString("_id"));
				member.setPassword(doc.getString("password"));
				member.setName(doc.getString("name"));
				member.setPhone(doc.getString("phone"));
				member.setRole(doc.getString("role"));
				member.setAge(doc.getInteger("age"));
				member.setRegdate(doc.getDate("regdate"));
				
				return member;
			}
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 회원정보조회
	@Override
	public Member memberSelectOne(String id) {
		try {
			Document doc = this.members.find(Filters.eq("_id", id)).first();
			
			Member member = new Member();
			member.setId(doc.getString("_id"));
			member.setPassword(doc.getString("password"));
			member.setName(doc.getString("name"));
			member.setPhone(doc.getString("phone"));
			member.setRole(doc.getString("role"));
			member.setAge(doc.getInteger("age"));
			member.setRegdate(doc.getDate("regdate"));
			
			return member;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	// 회원정보변경(비밀번호변경x)	
	@Override
	public int memberUpdateOne(Member member) {
		try {
			Bson update1 = Updates.set("name", member.getName());
			Bson update2 = Updates.set("phone", member.getPhone());
			Bson update3 = Updates.set("role", member.getRole());
			Bson update4 = Updates.set("age", member.getAge());
			Bson update5 = Updates.set("regdate", member.getRegdate());
			
			Bson update = Updates.combine(update1, update2, update3, update4, update5);
			
			UpdateResult result = this.members.updateOne(Filters.eq("_id", member.getId()), update);
			return 1;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	// 비밀번호변경
	@Override
	public int memberUpdatePwOne(Map<String, Object> map) {
		
		try {
			String id = (String)map.get("_id"); // 현재 아이디
			String pw1 = (String)map.get("password1"); // 바꿀 비번
			
			// 아이디와 암호일치확인(=로그인)
			Member member = this.memberLogin(map);
			
			if(member != null) { // 아이디와 암호일치
				System.out.println("비밀번호 변경 가능");
				// 비밀번호 변경
				Bson filter = Filters.eq("_id", id);
				Bson update = Updates.set("password", pw1);
				UpdateResult ret = this.members.updateOne(filter, update);
				
				if(ret.getModifiedCount()==1L) {
					return 1;
				}
			}
			return 0;
		}
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}

	@Override
	public int memberDeleteOne(String id) {
		try {
			DeleteResult result = this.members.deleteOne(Filters.eq("_id", id));
			return 1;
		}
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	

}
