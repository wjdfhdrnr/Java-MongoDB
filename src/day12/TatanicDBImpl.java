package day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import day11.Titanic;
import day8.Config;

public class TatanicDBImpl implements TitanicDB {
	private MongoCollection<Document> titanic = null;

	// 1. titanic 컬렉션 접속하기
	public TatanicDBImpl() {
		try {
			this.titanic = MongoClients.create(Config.URL).getDatabase(Config.DBNAME).getCollection(Config.TITANICCOL);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Titanic> selectTitanicList() {
		try {
			Bson sort = Filters.eq("fare", 1); // 오름차순
			// 원본타입
			FindIterable<Document> docs = this.titanic.find().sort(sort);
			// 반환타입
			List<Titanic> list = new ArrayList<Titanic>();
			// 원본 타입 반복
			for (Document doc : docs) {
				// 반환타입으로 복사
				Titanic titanic = new Titanic();
				titanic.setSurvived(doc.getString("survived"));
				titanic.setPclass(doc.getInteger("pclass"));
				titanic.setSex(doc.getString("sex"));
				titanic.setAge(doc.getDouble("age").floatValue());
				titanic.setSibsp(doc.getInteger("sibsp"));
				titanic.setParch(doc.getInteger("parch"));
				titanic.setTicket(doc.getString("ticket"));
				titanic.setFare(doc.getDouble("fare").floatValue());
				titanic.setCabin(doc.getString("cabin"));
				titanic.setEmbarked(doc.getString("embarked"));
				titanic.setName(doc.getString("name"));
				titanic.setPassengerid(doc.getInteger("passengerid"));
				// 반환타입에 추가
				list.add(titanic);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> selectTitanicListMap() {
		try {
			FindIterable<Document> docs = this.titanic.find().sort(Filters.eq("fare", 1));
			List<Map<String, Object>> list = new ArrayList<>();

			for (Document doc : docs) {
				Map<String, Object> map = new HashMap<>();
				map.put("survived", doc.getString("survived"));
				map.put("pclass", doc.getInteger("pclass"));
				map.put("sex", doc.getString("sex"));
				map.put("age", doc.getDouble("age").floatValue());
				map.put("sibsp", doc.getInteger("sibsp"));
				map.put("parch", doc.getInteger("parch"));
				map.put("ticket", doc.getString("ticket"));
				map.put("fare", doc.getDouble("fare").floatValue());
				map.put("cabin", doc.getString("cabin"));
				map.put("embarked", doc.getString("embarked"));
				map.put("name", doc.getString("name"));
				map.put("passengerid", doc.getInteger("passengerid"));

				list.add(map);

			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// 나이순으로 정렬한 후 n명 조회
	@Override
	public List<Titanic> selectTitanicAge(int n) {
		try {
			Bson sort = Filters.eq("age", -1);
			FindIterable<Document> docs = this.titanic.find().sort(sort).limit(n);

			List<Titanic> list = new ArrayList<Titanic>();

			for (Document doc : docs) {
				Titanic titanic = new Titanic();
				titanic.setSurvived(doc.getString("survived"));
				titanic.setPclass(doc.getInteger("pclass"));
				titanic.setSex(doc.getString("sex"));
				titanic.setAge(doc.getDouble("age").floatValue());
				titanic.setSibsp(doc.getInteger("sibsp"));
				titanic.setParch(doc.getInteger("parch"));
				titanic.setTicket(doc.getString("ticket"));
				titanic.setFare(doc.getDouble("fare").floatValue());
				titanic.setCabin(doc.getString("cabin"));
				titanic.setEmbarked(doc.getString("embarked"));
				titanic.setName(doc.getString("name"));
				titanic.setPassengerid(doc.getInteger("passengerid"));

				list.add(titanic);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
