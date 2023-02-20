package day13;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import day8.Config;

public class ItemDBImpl implements ItemDB {

	private MongoCollection<Document> sequence = null;
	private MongoCollection<Document> items = null;

	public ItemDBImpl() {
		try {
			this.sequence = MongoClients.create(Config.URL).getDatabase(Config.DBNAME)
					.getCollection(Config.RESEQUENCECOL);
			this.items = MongoClients.create(Config.URL).getDatabase(Config.DBNAME).getCollection(Config.ITEMICCOL);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// n개 조회(정렬기준 물품번호를 내림차순으로)
	@Override
	public List<Map<String, Object>> selectItemListMap(int n) {
		try {
			Bson sort = Filters.eq("_id", -1);
			FindIterable<Document> docs = this.items.find().sort(sort).limit(n);

			// List<Map> 타입으로 반환해서 리턴
			List<Map<String, Object>> list = new ArrayList<>();
			for (Document doc : docs) {
				Map<String, Object> map = new HashMap<>();
				// doc를 map으로 변환하기
				map.put("_id", doc.getLong("_id"));
				map.put("name", doc.getString("name"));
				map.put("content", doc.getString("content"));
				map.put("price", doc.getInteger("price"));
				map.put("quantity", doc.getInteger("quantity"));
				map.put("regdate", doc.getDate("regdate"));

				list.add(doc);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 물품 등록
	@Override
	public int insertItemMap(Map<String, Object> map) {
		try {

			Bson filter = Filters.eq("_id", "SEQ_ITEM_CODE");
			Bson update = Updates.inc("idx", 1);
			Document doc = this.sequence.findOneAndUpdate(filter, update);
			long itemCode = doc.getLong("idx");

			Document saveDoc = new Document();
			saveDoc.append("_id", itemCode); // 시퀀스에서 꺼낸값
			saveDoc.append("name", map.get("name"));
			saveDoc.append("content", map.get("content"));
			saveDoc.append("price", map.get("price"));
			saveDoc.append("quantity", map.get("quantity"));
			saveDoc.append("regdate", new Date()); // 현재 시간

			InsertOneResult result = this.items.insertOne(saveDoc);
			if (result.getInsertedId().asInt64().getValue() == itemCode) {
				return 1;
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// 물품 1개 삭제 ex) 1004
	@Override
	public int deleteItemOne(long no) {
		try {
			DeleteResult result = this.items.deleteOne(Filters.eq("_id", no));
			System.out.println(result.toString());
			return 1;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// 물품 n개 삭제 ex) {1004,1007,1010}
	// 물품 n개 삭제 ex) {1004,1007,1010}
	@Override
	public int deleteItemMany(long[] no) {
		try {
			int cnt = 0;
			// 조건 1개에 n개를 지우는 것은 가능
			// 조건 n개에 n개를 지우기 위해서는 반복문 돌려야함
			// long[] no = {1,2,5,6}
			for (int i = 0; i < no.length; i++) {
				DeleteResult result = this.items.deleteOne(Filters.eq("_id", no[i]));
				cnt += result.getDeletedCount();
			}
			// 삭제한 개수 == 배열의 개수
			if (cnt == no.length) {
				return 1;
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// 물품 수정(name, content, price, quantity)를 변경하기
	@Override
	public int updateItemOne(Item item) {
		try {
			Bson filter = Filters.eq("_id", item.getNo());

			Bson update1 = Updates.set("name", item.getName());
			Bson update2 = Updates.set("content", item.getContent());
			Bson update3 = Updates.set("price", item.getPrice());
			Bson update4 = Updates.set("quantity", item.getQuantity());

			Bson update = Updates.combine(update1, update2, update3, update4);

			UpdateResult result = this.items.updateOne(filter, update);
			System.out.println(result.toString());
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	@Override
	public List<Item> selectItemList(int n) {
		try {
			Bson sort = Filters.eq("_id", -1);
			FindIterable<Document> docs = this.items.find().sort(sort).limit(n);

			// List<Item> 타입으로 반환해서 리턴
			List<Item> list = new ArrayList<>();
			for (Document doc : docs) {
				Item item = new Item();
				item.setNo(doc.getLong("_id"));
				item.setName(doc.getString("name"));
				item.setContent(doc.getString("content"));
				item.setPrice(doc.getInteger("price"));
				item.setQuantity(doc.getInteger("quantity"));
				item.setRegdate(doc.getDate("regdate"));

				list.add(item);
			}
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
