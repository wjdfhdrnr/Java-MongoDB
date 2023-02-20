package day10;

import java.util.List;
import java.util.Map;

public interface MemberDB {
	
	// 추가 하기
	public int insertMember(Member member);
	public int insertMemberMap(Map<String, Object> map); // 가변적일 때 Map사용하는게 더 편리할 수 있음
	
	// 1개 조회
	public Member selectMemberOne(String id);
	public Map<String, Object> selectMemberMapOne(String id);
	
	// 전체 조회
	public List<Member> selectMemberList();
	public List<Map<String, Object>> selectMemberMapList();
	
}
