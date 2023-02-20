package day12;

import java.util.Iterator;
import java.util.List;

import day11.Titanic;

// 출력하는 곳
public class Print {
	
	// for문 사용
	public void printListAll(List<Titanic> list) {
		for(Titanic t : list) {
			System.out.println(t.getName());
		}
	}
	
	// while문 이용해서 출력
	public void printListAll1(List<Titanic> list) {
		// List 타입을 반복자(Iterator)로 변환하기
		Iterator<Titanic> cursor = list.iterator();
		while(cursor.hasNext()) {
			Titanic c = cursor.next();
			System.out.println(c.getName());
			System.out.println("survived = " + c.getSurvived());
			System.out.println("pclass = " + c.getPclass());
			System.out.println("sex = " + c.getSex());
			System.out.println("age = " + c.getAge());
			System.out.println("sibsp = " + c.getSibsp());
			System.out.println("parch = " + c.getParch());
			System.out.println("ticket = " + c.getTicket());
			System.out.println("fare = " + c.getFare());
			System.out.println("cabin = " + c.getCabin());
			System.out.println("embarked = " + c.getEmbarked());
			System.out.println("name = " + c.getName());
			System.out.println("passengerid = " + c.getPassengerid());
			System.out.println("------------------------------");
		}
		
		/*
		// 다른 방법
		int i =0;
		while(i<list.size()) {
			Titanic c = list.get(i);
			System.out.println(c.getName());
			i++;
		}
		*/
	}
	
	// do while문 이용해서 출력
	public void printListAll2(List<Titanic> list) {
		Iterator<Titanic> cursor = list.iterator();
		int i = 0;
		do {
			Titanic c = cursor.next();
			System.out.println(c.getName());
			i++;
		}
		while(cursor.hasNext());
	}
	
	
	// 전체 목록을 받아서 생존자의 인원수를 구하시오. (for문 사용)
	public void printSurvived(List<Titanic> list) {
		int cnt = 0;
		for(Titanic t : list) {
			if(t.getSurvived().equals("Yes")) {
				cnt+=1;
			}
		}
		System.out.println("생존자 인원수 => " + cnt);
	}
	
	// 전체 목록을 받아서 연령대별 인원수를 구하시오. (단 0은 제외, while문 사용)
	// 0.01 ~  9 어린이
	//   10 ~ 19 10대 => X명
	//   20 ~ 29 20대
	//   30 ~ 39 30대
	//   ~~~
	public void printAge(List<Titanic> list) {
		int[] cnt = {0,0,0,0,0,0,0,0,0};
		int i=0;
		while(i<list.size()) {
			Titanic t = list.get(i);
			
			if(t.getAge()>0) {
				int n = t.getAge().intValue() / 10; // intValue()는 데이터타입이 Float일 때 사용 가능
				cnt[n]++;
			}
			i++;
		}
		for(i=0; i< cnt.length; i++) {
			System.out.println(i + "대 => " + cnt[i]);
		}		
	}
	
	// 전체 목록에서 pclass값의 종류별 개수를 구하시오.(종류는 1,2,3)
	public int[] printPClass(List<Titanic> list) {
		int[] cnt = {0,0,0,0};
		for(Titanic t : list) {
			int n = t.getPclass();
			cnt[n]++;
		}
		// cnt[0]은 사용안함. cnt[1]에는 1의 개수, cnt[2]에는 2의 개수, cnt[3]에는 3의 개수
		System.out.println("pclass 1 => " + cnt[1] + ", pclass 2 => " + cnt[2] + ", pclass 3 => " + cnt[3]);
		return cnt;
	}
	
	// 전체 목록에서 운임요금(fare) 30보다 큰 것만 fare와 name으로 출력.(단 fare는 소수점을 올림하여 정수로 표시)
	public void printFare(List<Titanic> list) {
		for(Titanic t : list) {
			if(t.getFare()>=30) {
				System.out.println("fare => " + Math.ceil(t.getFare()) + ", name => " + t.getName());
			}
			
		}
	}
	
	// 전체 목록에서 이름(name)의 Mr. Miss. Mrs. 를 각각 포함하는 인원수를 구하시오.
	public void printName(List<Titanic> list) {
		int cnt[] = new int[3];
		
		for(Titanic t : list) {
			if(t.getName().contains("Mr.")) {
				cnt[0]++;
			}
			if(t.getName().contains("Miss.")) {
				cnt[1]++;
			}
			if(t.getName().contains("Mrs.")) {
				cnt[2]++;
			}
		}
		System.out.println("Mr. => " + cnt[0] + " , Miss => " + cnt[1] + " , Mrs => " + cnt[2]);
	}
	
	
	// 연령대별 생존자수 구하기(전체인원 891명, 비율은 소수점을 표시)
	public void printAgeSurvived(List<Titanic> list) {
		// 연령대별 인원수를 구하고, 연령대별 생존자수 구하기
		// 비율 = 생존자수 / 전체인원 * 100
		int cnt1[] = {0,0,0,0,0,0,0,0,0};
		int cnt2[] = {0,0,0,0,0,0,0,0,0};
		for(Titanic t : list) {
			if(t.getAge()>0 && t.getAge()<10) {
				cnt1[0]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[0]++;
				}
			}
			if(t.getAge()>=10 && t.getAge()<20) {
				cnt1[1]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[1]++;
				}
			}
			if(t.getAge()>=20 && t.getAge()<30) {
				cnt1[2]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[2]++;
				}
			}
			if(t.getAge()>=30 && t.getAge()<40) {
				cnt1[3]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[3]++;
				}
			}
			if(t.getAge()>=40 && t.getAge()<50) {
				cnt1[4]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[4]++;
				}
			}
			if(t.getAge()>=50 && t.getAge()<60) {
				cnt1[5]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[5]++;
				}
			}
			if(t.getAge()>=60 && t.getAge()<70) {
				cnt1[6]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[6]++;
				}
			}
			if(t.getAge()>=70 && t.getAge()<80) {
				cnt1[7]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[7]++;
				}
			}
			if(t.getAge()>=80 && t.getAge()<90) {
				cnt1[8]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[8]++;
				}
			}
		}
		for(int i=0; i< cnt1.length; i++) {
			System.out.println(i*10 + "대 생존확률=> " + (float)cnt2[i]/(float)cnt1[i]*100);
		}	
	}
	
	
	
	// 성별 생존자수 구하기(전체인원 891명, 비율은 소수점으로 표시)
	public void printSexSurvived(List<Titanic> list) {
		// 1. 남여 인원수 구하기
		// 2. 남여 생존자수 구하기
		// 3. 남 생존자수 / 남 전체인원 * 100
		int cnt1[] = {0,0}; // 인원 수 보관 : cnt1[0]은 남자수, cnt1[1]은 여자수
		int cnt2[] = {0,0}; // 생존자 수 보관 : cnt2[0]은 남자의 생존자수, cnt2[1]은 여자의 생존자수
		for(Titanic t : list) {
			if(t.getSex().equals("male")) {
				cnt1[0]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[0]++;
				}
			}
			else if(t.getSex().equals("female")) {
				cnt1[1]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[1]++;
				}
			}
			
		}
		System.out.println("남자 생존 확률 => " +(float)cnt2[0]/(float)cnt1[0]*100); // 남자 생존 확률 => 18.890814
		System.out.println("여자 생존 확률 => " +(float)cnt2[1]/(float)cnt1[1]*100); // 여자 생존 확률 => 74.20382
		
		
		
	}
	
	
	// 티켓 등급별 생존자수 구하기(전체인원 891명, 비율은 소수점으로 표시)
	public void printPClassSurvived(List<Titanic> list) {
		
		int cnt1[] = {0,0,0};
		int cnt2[] = {0,0,0};
		for(Titanic t : list) {
			if(t.getPclass() == 1) {
				cnt1[0]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[0]++;
				}
			}
			else if (t.getPclass() == 2) {
				cnt1[1]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[1]++;
				}
			}
			else if (t.getPclass() == 3) {
				cnt1[2]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[2]++;
				}
			}
		}
		for(int i=0; i< cnt1.length; i++) {
			System.out.println("Pclass " + i + " 생존확률 => " + (float)cnt2[i]/(float)cnt1[i]*100);
		}
		
	
	}
	
}
