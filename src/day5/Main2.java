package day5;

public class Main2 {

	public static void main(String[] args) {
		// 클래스명 객체명 = new 생성자명();
		Exam<String> obj = new Exam<String>(); // String자료형으로 정함
		obj.setElement("aaa");
		String str = obj.getElement();
		System.out.println(str);
		
		// 제너릭 클래스의 타입은 원시타입은 불가능!! 
		/*
		[원시타입]
		정수 타입	byte, short, int, long
		문자 타입   char
		실수 타입	float, double
		논리 타입	boolean

		[객체타입]
		정수 타입 Byte, Short, Integer, Long
		문자 타입 Character
		실수 타입 Float, Double,
		논리 타입 Boolean
		문자열 타입 : String
		날짜 타입 : Date
		*/
		Exam<Integer> obj1 = new Exam<Integer>(); // int가 아닌 Integer
		obj1.setElement(13);
		int ret = obj1.getElement();
		System.out.println(ret);
	

	}

}
