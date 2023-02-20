package day8.frame;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import day8.Book;
import day8.BookDB;
import day8.BookDBImpl;

public class BookSelectListFrame extends JDialog{
	
	private BookDB bookDB = new BookDBImpl(); // DB연결 필요한 컬렉션 객체 생성 완료됨.
	private static final long serialVersionUID = 1L;
	private JTable table;
	
	public BookSelectListFrame() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		// 테이블 생성(JTable 선택)
		table = new JTable();	
		
		
		// Vector == ArrayList와 기능
		String[] colume = {"번호","제목","저자","가격","분류","날짜"};
		/*
		Vector<String> vector = new Vector<String>();
		vector.add("번호");
		vector.add("제목");
		vector.add("저자");
		vector.add("가격");
		vector.add("분류");
		vector.add("날짜");
		*/
		DefaultTableModel model = new DefaultTableModel(colume,0); 
		
		
		List<Book> list = bookDB.selectBookList();
		for(Book book : list) {
			String[] data = {
					book.getNo()+"", // book.getNo가 int인데 + ""를 해주면 String타입으로 변함
					book.getTitle(),
					book.getAuthor(),
					book.getPrice()+"",
					book.getCate()+"",
					book.getDate()+"",					
			};
			model.addRow(data);
		}
		table.setModel(model);
		
		JScrollPane jScrollPane = new JScrollPane(table);
		getContentPane().add(jScrollPane, BorderLayout.CENTER);
		
		this.setSize(600,500);
		this.setVisible(true);
	}

}
