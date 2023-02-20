package day6;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// **일반적으로 타입용(ex.Member)으로 사용하는 클래스는 getter/setter, toString, 생성자
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String id = null;
	private String password = null;
	private String name = null;
	private String phone = null; // ex) 000-0000-0000
	private int age=0; // 나이
	private String role = null; // 권한 : 고객(C) or 판매자(S)만 가능
	private Date regdate = null;

}
