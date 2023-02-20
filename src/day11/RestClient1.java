package day11;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// [ rest api 서버 ]
// 정보를 제공해주는 문서의 종류(xml, json...)
// 1. 영화진흥원에서 현재 사영하고 있는 영화정보 제공해줌
// 2. 카카오 결제를 위한 정보 제공해줌
// 3. 카카오 결제를 위한 정보를 제공해줌

// 위 정보들은 상대방 서버에서 가지고 있는 정보, 때문에 내가 사용하기 위해서는 해당 서버에 접속해서 정보를 받아와야함
// rest api 서버에 접속해서 정보를 받아오는 기능을 하는 라이브러리 okhttp3(pom.xml에 추가)

//http://1.234.5.158:23000/json/exam1.json
public class RestClient1 {

	// 접속해서 정보를 받아올 rest 서버 주소.
	final String URL = "http://1.234.5.158:23000/json/exam1.json";
	
	public RestClient1() {		
		try {
			// 라이브러리를 제공한 곳의 문서 참고
			// 1. 클라이언트 객체 생성
			OkHttpClient client = new OkHttpClient();
			
			// 2. 요청 정보 객체 만들기
			Request request = new Request.Builder().url(URL).get().build();
			
			// 3. 1과 2를 이용한 요청 후에 결과 받기
			Response response = client.newCall(request).execute(); // execute : 동기처리, enqueue : 비동기처리
			
			// 결과를 잘 받았는지 확인
			if(response.isSuccessful() == true) {
				// 실제로 받은 정보를 문자변수에 저장하기
				String strData = response.body().string().toString();
				
				// 필요한 데이터만 꺼냄 변수명X( {"ret":"y","data":"123"}에서 y와 123 )
				// JSONObject == Map형태, 키로 값을 알 수 있음
				JSONObject jobj = new JSONObject(strData);
				String ret = jobj.getString("ret");
				int data = jobj.getInt("data");
				
				// 콘솔에서 확인하기
				System.out.println(strData);
				System.out.println(ret);
				System.out.println(data);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
