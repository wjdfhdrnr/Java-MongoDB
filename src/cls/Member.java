package cls;

import java.util.Date; // (자동 import : ctrl+shift+O)

// 내가 원하는 타입을 만듦. 실행하는 클래스 아님!!
// 아이디, 암호, 이메일, 나이, 연락처, 가입일자 (설계상에서 정해지는 항목)
public class Member {
	
	String userId = "";
	String userPw = "";
	String userEmail = "";
	int userAge = 0;
	String userPhone = "000-0000-0000";
	Date useDate = null; // 클래스형의 타입을 만들어 놓음 
	
	// setter <= 누군가에 의해서 값을 저장시키는 역할함.
	// getter <= 누군가에 의해서 값을 가지고 역할함.
	// 마우스 오른쪽 >> Source >> Generate Getter and Setter >> ALL 생성
	
	// 메소드(함수)
	// 1. Main4에서 사용할 수 있다. public
	// 2. 반환타입(String)문자로 반환해야 함.
	// 3. 메소드명(Main4에서 전달할 값)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId; // class에 선언한 userId에 변경된(=입력된)값을 저장한다는 의미.
	}
	
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public Date getUseDate() {
		return useDate;
	}
	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}
	
	// 마우스 오른쪽 >> Source >> Generate toString() // 객체 정보 출력용
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPw=" + userPw + ", userEmail=" + userEmail + ", userAge=" + userAge
				+ ", userPhone=" + userPhone + ", useDate=" + useDate + "]";
	}

}
