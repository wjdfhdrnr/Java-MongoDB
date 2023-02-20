package day15;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BookStore {

	private String phone;
	private String address;
	private List<Book> list = new ArrayList<>();

	// 책 추가
	public int addBook(Book book) {
		try {
			list.add(book);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// 책 삭제
	public int removeBook(Book book) {
		try {
			list.remove(book);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	// 책제목이 포함된것 검색
	public List<Book> searchBook(String title) {
		List<Book> ret = new ArrayList<Book>();
		try {
			for (Book one : this.list) {
				if (one.getTitle().contains(title)) {
					ret.add(one);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 가격보다 큰것만 검색
	public List<Book> searchBookPrice(long price) {
		try {
			for (Book one : list) {
				if (one.getPrice() > price) {
					list.add(one);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
