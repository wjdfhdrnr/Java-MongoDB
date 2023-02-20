package day5;

public class Main1 {

	public static void main(String[] args) {
			
		// 객체 생성
		// Calc calc = new Calc(); 
				
		
		// 필요한 메소드(기능) 호출
		/*
		// [더하기]
		int ret = calc.sumPLus(3, 4);
		System.out.println(ret);
		*/
		
		
		// < 예외처리 >
		
		// [나누기]
		/*
		float ret1 = calc.sumDiv(10, 0);
		System.out.println(ret1);
		*/
		
		
		/*
		// [빼기]
		int ret2;
		try{
			ret2 = calc.sumMinus(10, 5); // 이것만 작성하면 오류생김 : Unhandled exception type Exception 메세지확인하고, try catch작성.
			System.out.println(ret2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		//*****************************************************************************************************************
		
		// < Static >
		
		// 객체생성은 많은 메모리, 자원 사용 => main마다 객체 생성하지 않고, 공통 클래스를 하나 만들어줌 => public static
		// 프로그램이 실행될때 static 메소드가 있는 클래스는 자동적으로 1개의 객체를 생성.
		// 앞서 말했듯이 1개의 객체가 생성됐으므로 바로 클래스명으로 접근해서 호출하면됨.
		// [곱하기]
		
		int ret4 = Calc.sumMul(3, 4);
		System.out.println(ret4);
		
		
		

	}

}
