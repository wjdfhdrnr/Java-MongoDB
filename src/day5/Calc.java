package day5;

public class Calc {
	
	// 변수X
	
	// getter, setter, toStirng X : 줄것도 없고, 받을것도 없다.
	// 생성자를 만들지 않으면 public Calc(){}
	
	// 2개의 정수가 전달되면 더하기를 해서 반환하는 메소드
	public int sumPLus(int n , int m) {
		int sum = n + m;
		return sum;
	}
		
	// 예외처리 : 코드는 문제없지만 물리적인 원인으로 발생하는 오류 대처 (ex:DB서버 중단 상황 등)
	// class내부에서 처리하는 방법과 Main에서 처리하는 방법 2가지가 있음
	
	// class내부에서 처리하는 방법
	public float sumDiv(int n, int m) {
		try {
			// 정수/정수 => 정수이므로 (float)붙임
			//float div = (float)n / (float)m;  
			float div = n / m; // 10/0 => 에러
			// 실행0
			// 실행1 오류가 발생
			// 실행2
			return div;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace(); // 오류를 추가할 수 있게 상세히 출력해줌. 개발자를 위해서
			return 0.0f; // 사용자한테 오류 났다고 출력되는거			
		}
		
	}
	
	// throws Exception : 오류가날 확률이 있다는 뜻. 오류가 나면 던지겠다. => Main에서 처리
	public int sumMinus(int n, int m) throws Exception{
		int tmp = n - m;
		return tmp;
	}
	
	// static 정적
	public static int sumMul(int n, int m) {
		int tmp = n*m;
		return tmp;
	}	

}
