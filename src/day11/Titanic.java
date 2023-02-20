package day11;

import lombok.Data;

@Data
public class Titanic {
	
	
	private String survived = "_"; // survived 생존여부 0 = No, 1 = Yes	
	private int pclass = 0; // pclass 티켓 등급 1 = 1st, 2 = 2nd, 3 = 3rd	
	private String sex = "_"; // sex 성별  	
	private Float age = 0.0f; // Age 나이  	 
	private int sibsp = 0; // sibsp 타이타닉에 탑승한 형제/자매 수 	 
	private int parch = 0; // parch 타이타s닉에 탑승한 부모/자녀 수 	 
	private String ticket = "_"; // ticket 티켓번호 	
	private Float fare = 0.0f; // fare 운임(티켓요금)  
	private String cabin = "_"; // cabin 객실 번호 	
	private String embarked = "_"; // embarked 탑승한 곳(항구) C = Cherbourg, Q = Queenstown, S = Southampton	
	private String name = "_";
	private int passengerid = 0;
	

}
