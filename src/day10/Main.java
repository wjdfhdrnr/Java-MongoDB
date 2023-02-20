package day10;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		/*
		// 배열과 다른점 : 순차적으로 데이터가 추가 되지 않음. 
		// 키를 통해서 데이터를 꺼냄. // 키는 고유해야 함. 같은것은 존재할 수없음. 
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("id","abc"); 
		map.put("name", "가나다"); 
		map.put("age", 21); 
		map.put("name", "나다라");// name이 가나다 => 나다라
		
		
		String id = (String)map.get("id"); // 꺼낸 value가 Object이기 때문에 형변환필요 		
		String name = (String)map.get("name"); 
		int age = (int) map.get("age");

		System.out.println(id); 
		System.out.println(name); 
		System.out.println(age);
		*/
		 
		// *******************************************************************************

		// DB연결과 컬렉션 선택된 상황
		// MemberDB mDB = new MemberDBImpl();

		/*
		//1) insertMemberMap 
		//빈 map 객체를 생성 
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("_id", "ccc3"); 
		map.put("password", "ccc1P"); 
		map.put("name", "이름2"); 
		map.put("phone", "010"); 
		map.put("role", "A"); 
		map.put("age", 13); map.put("regdate", new Date());
		
		int ret = mDB.insertMemberMap(map); 
		System.out.println(ret);
		*/

		/*
		//2) selectMemberMapOne 
		Map<String, Object> map = mDB.selectMemberMapOne("ccc1"); 
		System.out.println("아이디 => " + map.get("_id")); 
		System.out.println("암호 => " + map.get("password"));
		System.out.println("이름 => " + map.get("name")); 
		System.out.println("연락처 => " + map.get("phone")); 
		System.out.println("권한 => " + map.get("role"));
		System.out.println("나이 => " + map.get("regdate"));
		System.out.println("등록일 => " + map.get("age"));
		*/
		

		/*
		//3) selectMemberMapList 
		List<Map<String, Object>> list = mDB.selectMemberMapList(); 
	    for(Map<String, Object> map : list) {
		System.out.println("아이디 => " + map.get("_id")); 
		System.out.println("암호 => " + map.get("password")); 
		System.out.println("이름 => " + map.get("name"));
		System.out.println("연락처 => " + map.get("phone")); 
		System.out.println("권한 => "+ map.get("role")); 
		System.out.println("나이 => " + map.get("regdate"));
		System.out.println("등록일 => " + map.get("age"));
		System.out.println("-----------------------------------"); }
		*/

		// ******************************************************************************

		AddressDB mDB = new AddressDBImpl();

		/*
		//1) insertAddress 
		Address address = new Address(); 
		Member member = new Member(); 
		address.setAddress("주소"); 
		address.setPostcode("우편번호");
		address.setRegdate(new Date());
		 
		member.setId("ccc2"); 
		address.setMemberid(member);
		 
		int ret= mDB.insertAddress(address); System.out.println(ret);
		*/
		
		
		//2) selectAddressList
		Member member = new Member();
		member.setId("ccc1");
		
		List<Address> list = mDB.selectAddressList(member);
		for (Address address : list) {
			System.out.println("주소등록아이디 => " + address.getCode());
			System.out.println("주소 => " + address.getAddress());
			System.out.println("우편번호 => " + address.getPostcode());
			System.out.println("등록일자 => " + address.getRegdate());
			System.out.println("멤버아이디 => " + address.getMemberid());
			System.out.println("--------------------------");
		}
		
		

		/*
		//3) selectAddressOne 
		Address address = mDB.selectAddressOne(10002); 
		System.out.println("아이디 => " + address.getCode());
		System.out.println("주소 => " + address.getAddress());
		System.out.println("우편번호 => " + address.getPostcode());
		System.out.println("등록일자 => " + address.getRegdate()); 
		System.out.println("멤버아이디 => " + address.getMemberid()); 
		*/
		
		/*
		//4) selectAddressListMap
		Member member = new Member();
		member.setId("ccc1");
		List<Map<String, Object>> list = mDB.selectAddressListMap(member);		
		for(Map<String, Object> map : list) {
		System.out.println("아이디 => " + map.get("_id")); 
		System.out.println("주소 => " + map.get("address")); 
		System.out.println("우편번호 => " + map.get("postcode"));
		System.out.println("등록일자 => " + map.get("regdate")); 
		System.out.println("멤버아이디 => "+ map.get("memberid")); 
		System.out.println("---------------------------------------");
		}
		*/
		
		

	}

}
