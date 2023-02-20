package day15;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		
		Print print = new Print();
		
		/*
		// 문제1)
		print.gugudan(3);
		
		System.out.println("--------------------------");
		
		// 문제2)
		List<Long> list = new ArrayList<Long>();
		list.add(1L);
		list.add(2L);
		long ret = print.sum(list);
		System.out.println("합 => " + ret);
		
		System.out.println("--------------------------");
		
		// 문제3)
		List<Double> list1 = new ArrayList<Double>();
		list1.add(2.3d);
		list1.add(2.5d);
		
		Map<String, Object> ret1 = print.sumAvg(list1);
		System.out.println("합 => " + ret1.get("sum"));
		System.out.println("평균 => " + ret1.get("avg"));
		*/
		
		//*********************************************************** Book
		/*
		// 문제4)
		List<Book> list = new ArrayList<>();
		
		for(int i=0; i<3; i++) {
			Book book = new Book();
			book.setCode(i+1);
			book.setTitle("제목");
			book.setAuthor("작가");
			book.setPrice(10000);
			book.setRegdate(new Date());
			list.add(book);
		}
		print.printBook(list);
		*/
		
		// 문제5)
		// 문제6)
		
		//*********************************************************** BookStore
		
		// 1) addBook
		
		BookStore bookStore = new BookStore();
		
		
		Book book = new Book();
		book.setCode(1L);
		book.setTitle("제목");
		book.setAuthor("작가");
		book.setPrice(25000L);
		book.setRegdate(new Date());
		
		int ret = bookStore.addBook(book);
		System.out.println(ret);
		
		
		// 2) serachBook
		List<Book> list = bookStore.searchBook("제목");
		for(Book l : list) {
			System.out.println(l.getCode());
			System.out.println(l.getTitle());
			System.out.println(l.getAuthor());
			System.out.println(l.getPrice());
			System.out.println(l.getRegdate());
		}
		
		
		
		
		
		
	}

}
