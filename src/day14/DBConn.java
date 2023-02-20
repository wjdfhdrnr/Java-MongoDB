package day14;

import org.bson.Document;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

import day8.Config;

// DB접속 클래스
// 객체 1번 생성만 => singleton패턴(고정된 메모리영역을 사용하여 메모리 낭비를 줄이고 공통된 객체를 사용할 때 매번 객체를 새로 생성하지 않는 방식)
public class DBConn {
	
	// 스스로의 객체를 만들기 위한 변수 설정
	private static DBConn db = null;
	
	// 외부에서 생성자를 호출할 수 없도록 => private
	private DBConn() {
		
	}
	
	public static DBConn getInstance() {
		db = new DBConn();
		return db;
	}
	
	// 외부에서 접속하고자 하는 컬렉션 이름을 넘겨주면 DB에 접속한 후 컬렉션 연결 객체를 반환
	// 객체명.getCollection('memeber');
	public MongoCollection<Document> getCollection(String coll){
		try {
			return MongoClients.create(Config.URL).getDatabase(Config.DBNAME).getCollection(coll);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

}
