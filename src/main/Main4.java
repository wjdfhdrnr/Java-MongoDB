package main;
//비교 및 논리 연산자
import java.util.Scanner;
// 자동배치 : ctrl+shift+F
public class Main4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("첫번째 숫자입력?");
		int a = sc.nextInt();

		// = => 값을 넣음
		// == => 같으냐?
		// != => 같지 않느냐?
		// && AND
		// || OR

		if (a % 5 == 0) {
			System.out.println("입력한 값은 5의배수");
		} else {
			System.out.println("입력한 값은 5의배수가 아님");
		}
		
		// 100이하~90이상(A), 89~80(B), 79~70(C), 나머지(D)
		if(90<=a && a<=100) {
			System.out.println("A");
		}else if(80<=a && a<=89){
			System.out.println("B");
		}else if(70<=a && a<=79){
			System.out.println("C");
		}else{
			System.out.println("D");
		}
		
		//소스코드변경
		
		// 입력받은 숫자 a가 짝수인지 홀수인지 확인
		// 입력받은 숫자가 3,5,3 5인지 확인
		// ex) 15=>3 5
		// ex) 5=>5
		if(a%2==0) {
			System.out.println("입력받은 숫자는 짝수입니다.");
		}else {
			System.out.println("입력받은 숫자는 홀수입니다.");
		}
		
		if(a%5==0 && a%3==0) {
			System.out.println("3 5");
		}else if(a%5==0) {
			System.out.println(5);
		}else if(a%3==0) {
			System.out.println(3);
		}
		
		sc.close();
		

	}

}
