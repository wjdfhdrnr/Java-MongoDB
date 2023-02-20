package day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;

import day8.Config;

public class AddressDBImpl implements AddressDB {
	private MongoCollection<Document> addresses = null;
	private MongoCollection<Document> sequence = null;
	private MongoCollection<Document> members = null;
	
	

	public AddressDBImpl() {
		this.addresses = MongoClients.create(Config.URL).getDatabase(Config.DBNAME).getCollection(Config.ADDRESSCOL);
		this.sequence = MongoClients.create(Config.URL).getDatabase(Config.DBNAME).getCollection(Config.RESEQUENCECOL);	
		this.members = MongoClients.create(Config.URL).getDatabase(Config.DBNAME).getCollection(Config.MEMBERCOL);	
	}

	@Override
	public int insertAddress(Address address) {
		try {

			// 시퀀스를 이용하여 숫자 가져오기
			Document doc = this.sequence.findOneAndUpdate(Filters.eq("_id", "SEQ_ADDRESS_CODE"), Updates.inc("idx", 1));
			long code = (long) doc.get("idx");

			Document saveDoc = new Document().append("_id", code).append("address", address.getAddress())
					.append("postcode", address.getPostcode()).append("regdate", address.getRegdate())
					.append("memberid", address.getMemberid().getId());
			// ***** 회원정보 전체 추가하지 않음, 기본키인 아이디만 추가함

			InsertOneResult result = this.addresses.insertOne(saveDoc);
			if (result.getInsertedId().asInt64().getValue() == code) {
				return 1;
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	@Override
	public int insertAddressMap(Map<String, Object> map) {
		try {

			Document doc = new Document();
			doc.put("_id", map.get("_id"));
			doc.put("address", map.get("address"));
			doc.put("postcode", map.get("postcode"));
			doc.put("regdate", map.get("regdate"));
			doc.put("member", map.get("member"));

			InsertOneResult result = this.addresses.insertOne(doc);

			System.out.println(result);
			if (result.getInsertedId().asString().getValue().equals(map.get("_id"))) {
				return 1;
			}
			return 0;

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// 주소코드가 오면 주소정보를 전달하는 + 회원정보도 같이
	@Override
	public Address selectAddressOne(long code) {
		try {
			Document doc = this.addresses.find(Filters.eq("_id", code)).first();	
			
			// Document => Address로 변환 메소드
			Address address = documentToAddress(doc);
			
			// members의 컬렉션에서 해당 아이디 정보를 가져와야함
			Bson filter1 = Filters.eq("_id", doc.getString("memberid"));
			Document docMember = this.members.find(filter1).first();
			
			// Document => Member로 바꾼후
			Member member = new Member();
			member.setId(docMember.getString("_id"));
			member.setName(docMember.getString("name"));
			member.setPhone(docMember.getString("phone"));
			member.setRole(docMember.getString("role"));
			member.setRegdate(docMember.getDate("regdate"));
			
			address.setMemberid(member);
			return address;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Map<String, Object> selectAddressMapOne(long code) {
		return null;
	}

	// 사람 한명에 주소는 여러개일수 있음 => 때문에 member id조회하면 여러 주소정보 뜨도록
	@Override
	public List<Address> selectAddressList(Member member) {
		try {
			List<Address> list = new ArrayList<Address>();
			// 주소에서 member로 전달되는 해당아이디 주소만 목록 조회
			FindIterable<Document> docs= this.addresses.find(Filters.eq("memberid", member.getId()));
			
			for(Document doc:docs) {			
				Bson filter1= Filters.eq("_id", member.getId());
				Document doc1 = this.members.find(filter1).first();
				//System.out.println(doc);
		  		//System.out.println(doc1);
				
				// 회원정보는 아직 없음
				Address address = documentToAddress(doc);
				// set을 이용해서 address 객체에 회원정보 추가
				address.setMemberid(documentToMember(doc1));
						
				list.add(address);
			}
			return list;			
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Map<String, Object>> selectAddressListMap(Member member) {
		try {
			FindIterable<Document> docs = this.addresses.find();
			List<Map<String, Object>> list = new ArrayList<>();
			
			for(Document doc : docs) {
				list.add(documentToMap(doc));
			}
			if(!list.isEmpty()) {
				return list;
			}
			return null;
		}
		catch (Exception e) {
			return null;
		}
		
	}
		
	// Document => Address
	private Address documentToAddress(Document doc) {
		Address address = new Address();
		address.setCode(doc.getLong("_id"));
		address.setAddress(doc.getString("address"));
		address.setPostcode(doc.getString("postcode"));
		address.setRegdate(doc.getDate("regdate"));
		return address;
	}
	
	private Map<String, Object> documentToMap(Document doc){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("_id", doc.get("_id"));
		map.put("address", doc.get("address"));
		map.put("postcode", doc.get("postcode"));
		map.put("regdate", doc.get("regdate"));
		map.put("memberid", doc.get("memberid"));
		return map;
		
	}
	
	private Member documentToMember(Document doc) {
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
}

