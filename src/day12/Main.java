package day12;

public class Main {

	public static void main(String[] args) {
		//RestTitanic obj = new RestTitanic();
		//obj.saveMongoDB();
		
		
		TatanicDBImpl dbm = new TatanicDBImpl();
		
		Print print = new Print();	
		
		//print.printListAll1(dbm.selectTitanicList());
		//print.printSurvived(dbm.selectTitanicList());
		//print.printAge(dbm.selectTitanicList());
		//print.printPClass(dbm.selectTitanicList());
		//print.printFare(dbm.selectTitanicList());
		//print.printName(dbm.selectTitanicList());
		//print.printAgeSurvived(dbm.selectTitanicList());
		//print.printSexSurvived(dbm.selectTitanicList());
		print.printPClassSurvived(dbm.selectTitanicList());
		
		
		
		
		/* 
		// 1) selectTitanicList
		List<Titanic> list = dbm.selectTitanicList();
		for(Titanic t : list) {
			System.out.println(t);
		}
		*/
		
		/*
		// 2) selectTitanicListMap 
		List<Map<String, Object>> retList = dbm.selectTitanicListMap();
		for(Map<String, Object> m : retList) {
			System.out.println("survived = " + m.get("survived"));
			System.out.println("pclass = " + m.get("pclass"));
			System.out.println("sex = " + m.get("sex"));
			System.out.println("age = " + m.get("age"));
			System.out.println("sibsp = " + m.get("sibsp"));
			System.out.println("parch = " + m.get("parch"));
			System.out.println("ticket = " + m.get("ticket"));
			System.out.println("fare = " + m.get("fare"));
			System.out.println("cabin = " + m.get("cabin"));
			System.out.println("embarked = " + m.get("embarked"));
			System.out.println("name = " + m.get("name"));
			System.out.println("passengerid = " + m.get("passengerid"));
			System.out.println("------------------------------");
		}
		*/
		
		
		/*
		// 3) selectTitanicAge (나이순으로 정렬한 후 n명 조회)
		List<Titanic> list = dbm.selectTitanicAge(3);
		for(Titanic t : list) {
			System.out.println(t);
		}
		*/
		
		
		
		
	}

}
