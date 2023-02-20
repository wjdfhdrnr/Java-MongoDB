package main1;

public class Main2 {

	public static void main(String[] args) {
		
		int a=1;
		int b=2;
		int c=4;
		int d=5;
		int e=12;
		
		// 배열의 위치 0부터 시작해서 4(전체개수의-1)까지
		int[] age = {1,2,4,5,12}; // 나이 변수가 5개 생성
		// System.out.println(age[0]); // 1
		// System.out.println(age[4]); // 12
		
		int i; //반복문 임시변수
		for(i=0;i<age.length;i++) {
			System.out.print(age[i]+" ");
		}
		System.out.println();
		
		// 문제1) age의 값들을 반대로 출력하세요.
		for(i=age.length-1;i>=0;i--) { // i의 시작위치가 'age.lenth-1'
			System.out.print(age[i]+" ");
		}
		System.out.println();
		
		// 문제2) age의 값들의 합과 평균 구하시오.
		int sum=0;
		for(i=0;i<age.length;i++) {
			sum+=age[i];
		}
		float avg = sum / (float)age.length;
		System.out.print("합 : " + sum + " 평균 : " + avg);
		
		System.out.println();
		
		// 문제3) age 5개 중에서 짝수만 출력하세요.
		for(i=0;i<age.length;i++) {
			if(age[i]%2==0) {
				System.out.print(age[i]+" ");
			}
		}
		
		
	}

}
