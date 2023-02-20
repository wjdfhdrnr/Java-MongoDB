package day11;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestClient7 {

	private final String URL = "http://1.234.5.158:23000/json/exam7.json";
	private String data = null;

	public RestClient7() {

		try {
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(URL).get().build();
			Response response = client.newCall(request).execute();

			if (response.isSuccessful() == true) {
				this.data = response.body().string().toString();
				System.out.println(this.data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void parseData() {
		// 7은 Object안에 Array를 가지고 있는 형태
		JSONObject jobj = new JSONObject(this.data);
		String ret = jobj.getString("ret"); // 데이터의 성공유무
		String ret1 = new String("y"); // 실제 데이터

		// 문자는 "=="이 아니라 equal를 사용해 같은지 비교해야함!!
		JSONArray jary = jobj.getJSONArray("data");
		if (ret.equals(ret1)) {
			for (int i = 0; i < jary.length(); i++) {
				JSONObject jobj1 = jary.getJSONObject(i);

				System.out.println(jobj1.getString("id"));
				System.out.println(jobj1.getString("name"));
				System.out.println(jobj1.getInt("age"));
				System.out.println(jobj1.getFloat("height"));
				System.out.println(jobj1.getFloat("weight"));
				System.out.println("---------------------------");
			}

		}

	}

	public List<Member1> parseData1() {
		try {
			List<Member1> list = new ArrayList<Member1>();
			
			JSONObject jobj = new JSONObject(this.data);
			String ret = jobj.getString("ret");
			JSONArray jary = jobj.getJSONArray("data");
			if (ret.equals("y")) {
				
				for (int i = 0; i < jary.length(); i++) {
					// JSONObject => Member1로 복사하기
			
					JSONObject jobj1 = jary.getJSONObject(i);
					Member1 m1 = new Member1();
					
					m1.setId(jobj1.getString("id"));
					m1.setName(jobj1.getString("name"));
					m1.setAge(jobj1.getInt("age"));
					m1.setHeight(jobj1.getFloat("height"));
					m1.setWeight(jobj1.getFloat("weight"));
					
					list.add(m1);
				}		
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	/*
	// JSONArray => ArrayList
	private List<Member1> JSONObjectToList(JSONObject obj) {
		List<Member1> list = new List<Member1>();
	
	}
	*/

}
