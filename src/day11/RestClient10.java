package day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestClient10 {

	private final String URL = "http://1.234.5.158:23000/json/exam10.json";
	private String data = null;

	public RestClient10() {
		try {
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(URL).get().build();
			Response response = client.newCall(request).execute();

			if (response.isSuccessful() == true) {
				this.data = response.body().string().toString();
				//System.out.println(this.data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void parseData() {
		// {"ret":"y", "data":[{0},{1},{2},{3},{4}]}
		JSONObject jobj = new JSONObject(this.data);
		String ret = jobj.getString("ret");

		// "data"부분만 가져오기 => [{0},{1},{2},{3},{4}]
		JSONArray jary = jobj.getJSONArray("data");
		for (int i = 0; i < jary.length(); i++) {
			// data[i]번째 => {"id": "id1","name": "가나다1","age": 31,"score": {"math":
			// 50,"eng": 90,"kor": 69}}
			JSONObject jobj1 = jary.getJSONObject(i);
			String id = jobj1.getString("id");
			String name = jobj1.getString("name");
			int age = jobj1.getInt("age");

			// score 가져외 => {"math": 50,"eng": 90,"kor": 69}
			JSONObject score = jobj1.getJSONObject("score");
			int math = score.getInt("math");
			int eng = score.getInt("eng");
			int kor = score.getInt("kor");

			System.out.println(id + "," + name + "," + age + "," + math + "," + eng + "," + kor);

		}

	}

	public List<Score1> parseData1() {
		// 반환 객체 만들기
		List<Score1> list = new ArrayList<Score1>();

		JSONObject jobj = new JSONObject(this.data);
		String ret = jobj.getString("ret");

		JSONArray jary = jobj.getJSONArray("data");
		for (int i = 0; i < jary.length(); i++) {
			JSONObject jobj1 = jary.getJSONObject(i);
			
			Score1 s1 = new Score1();
			s1.setId(jobj1.getString("id"));
			s1.setName(jobj1.getString("name"));
			s1.setAge(jobj1.getInt("age"));

			JSONObject score = jobj1.getJSONObject("score");
			s1.setMath(score.getInt("math")); 
			s1.setEng(score.getInt("eng"));
			s1.setKor(score.getInt("kor")); 

			list.add(s1);

		}
		return list;
	}
	
	// 국어점수 합께 구하기
	public int sumKor() {
		int sum = 0;				
		List<Score1> list = this.parseData1();
		
		for( Score1 s1 : list) {
			int kor = s1.getKor();
			sum += kor;
		}		
		return sum;
	}
	
	
	// 영어점수 최대값 구하기
	public int maxEng() {
		int max = 0; // 초기값을 범위 값보다 작은것으로(0~100)
		int min = 101;
		List<Score1> list = this.parseData1();
		
		for(Score1 s1: list) {
			int eng = s1.getEng();
			if (max < eng) {
				max = eng;
			}
			if(min > eng) {
				min = eng;
			}
		}
		return max;
		
	}
	
	
	// 국어, 영어, 수학 합계 구하기
	public int[] sumKorMathEng() {
		int[] sumArray = new int[3];
		
		List<Score1> list = this.parseData1();
		
		for(Score1 s1:list) {
			sumArray[0] += s1.getMath();
			sumArray[1] += s1.getEng();
			sumArray[2] += s1.getKor();							
		}
		return sumArray;
	}
	
	
	// 학생별 총점 구하기
	// map에는 학생아이디, 학생이름, 총점정보 포함하기
	public List<Map<String, Object>> sumStudent(){
		int sumStudent = 0;
		
		List<Score1> list = this.parseData1();
		List<Map<String, Object>> retList = new ArrayList<>();
		
		for(Score1 s1:list) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", s1.getId());
			map.put("name", s1.getName());
			map.put("total", s1.getKor()+s1.getMath()+s1.getEng());
			map.put("avg", (s1.getKor()+s1.getMath()+s1.getEng())/3);
			
			retList.add(map);		
		}	
		return retList;
	}
}
