package day11;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// RestClient1 client = new RestClient1();
		
		/*
		RestClient2 client = new RestClient2();
		client.parseData();
		*/
		
		/*
		RestClient7 client = new RestClient7();
		List<Member1> list = client.parseData1();
		for(Member1 m : list) {
			System.out.println(m.getId());
			System.out.println(m.getName());
			System.out.println(m.getAge());
			System.out.println(m.getHeight());
			System.out.println(m.getWeight());
			System.out.println("----------------------------");
		}
		*/
		
		/*
		RestClient10 client = new RestClient10();
		List<Score1> list = client.parseData1();
		for(Score1 s : list) {
			System.out.println(s.getId());
			System.out.println(s.getName());
			System.out.println(s.getAge());
			System.out.println(s.getKor());
			System.out.println(s.getMath());
			System.out.println(s.getEng());
			System.out.println("----------------------------------");
		}
		*/
		
		/*
		// *************************************************** RestCkueb10 class
		RestClient10 client = new RestClient10();
		
		int sumKor = client.sumKor();
		System.out.println("국어 점수 합계 = " + sumKor);
		
		int maxEng = client.maxEng();
		System.out.println("영어 점수 최대값 = " + maxEng);
		
		int[] ret = client.sumKorMathEng();
		System.out.println("국어합계 = " + ret[0]);
		System.out.println("수학합계 = " + ret[1]);
		System.out.println("영어합계 = " + ret[2]);
		
		
		List<Map<String, Object>> list = client.sumStudent();
		// System.out.println(list.toString()); // 디버깅용 출력문
		
		for(Map<String, Object> s : list) {
			System.out.println("아이디 = " + s.get("id"));
			System.out.println("이름 = " + s.get("name"));
			System.out.println("총점 = " + s.get("total"));
			System.out.println("평균 = " + s.get("avg"));
			System.out.println("------------------------------------");
		}
		*/
		
		RestTitanic client = new RestTitanic();		
			
		List<Titanic> list = client.parseData();
		for(Titanic s : list) {
			System.out.println(s);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
