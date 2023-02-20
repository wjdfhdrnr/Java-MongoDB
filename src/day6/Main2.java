package day6;

public class Main2 {

	public static void main(String[] args) {
		// age=>0
		Exam2 obj1 = new Exam2();
		obj1.plusAge(); // age=>1
		obj1.plusAge(); // age=>2
		obj1.plusAge(); // age=>3
		// obj1.printAge(); //age => 2, age1 => 100
		obj1.forAge();
		
		/*
		// obj1과 다른 객체(데이터를 전혀 공유X)
		Exam2 obj2 = new Exam2();
		obj2.plusAge(); // age=>1 // 
		// obj2.printAge();
		
		
		// static메소드로 다른 클래스에서 써도 +1됨(한개를 가지고 공유)
		Exam2.plusAge1(); // age1=>101
		Exam2.plusAge1(); // age1=>102
		*/
		
		
	}

}
