package day13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import day8.Config;

public class ChatClient implements MqttCallback{
	
	private MqttClient client = null;
	private ItemDB iDB = new ItemDBImpl(); // items 컬렉션 연동 객체 생성
	
	public ChatClient() {
		try {
			
			// clientid : broker가 클라이언트를 식별하기 위한 고유 문자열
			String clientid = "id218_" + System.currentTimeMillis();
			this.client = new MqttClient(Config.BROKER, clientid); // topic은 client안에 있음
			
			// Mqtt프로토콜을 이용해서 broker에 연결하면서 연결정보를 설정할 수 있는 객체
			MqttConnectOptions options = new MqttConnectOptions();
			options.setUserName(Config.CONNECTID);
			options.setPassword(Config.CONNECTPW.toCharArray());
			options.setCleanSession(true);
			options.setKeepAliveInterval(30); 
			
			this.client.connect(options);
			this.client.setCallback(this); // 나라는 걸 알려줌
			System.out.println("접속성공 => " + client);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("접속실패");
		}
	}
	
	// 구독설정 ex)pknu/class303으로 오는 모든 메시지는 다 받음
	public boolean setSubcribe() {
		try {
			client.subscribe("/pknu/class303/id218"); 
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 메시지 보내기(보낼 토픽, 메시지)
	public boolean sendMessage(String topic, String msg) { 
		try {
			MqttMessage message = new MqttMessage(msg.getBytes());
			message.setPayload(msg.getBytes());
			client.publish(topic, message);
			return true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//커넥션이 종료되면 호출 - 통신오류로 연결이 끊어지는 경우 호출
	@Override
	public void connectionLost(Throwable cause) {
		System.out.println("connectionLost");
		
	}
	
	//메세지의 배달이 완료되면 호출
		@Override
		public void deliveryComplete(IMqttDeliveryToken token) {
			System.out.println("deliveryComplete");
			
		}
	
	//메세지가 도착하면 호출되는 메소드
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		try {
			// byte[]=>String=>JSONObject
			byte[] tmp = message.getPayload();
			String str = new String(tmp);
			
			// {"name":"물품명", "content":"물품내용", "price":1234, "quantity":1234};
			JSONObject jobj = new JSONObject(str);
			String name = jobj.getString("name");
			String content = jobj.getString("content");
			int price = jobj.getInt("price");
			int quantity = jobj.getInt("quantity");
			
			// map에 데이터 담기
			Map<String, Object> map = new HashMap<>();
			map.put("name", name);
			map.put("content", content);
			map.put("price", price);
			map.put("quantity", quantity);
			
			// 데이터 베이스에 추가하기
			int ret = iDB.insertItemMap(map); // 1 => 성공
			
			// 데이터 베이스에서 n개 조회
			List<Map<String, Object>> list = iDB.selectItemListMap(5);
			for(Map<String, Object> map1 : list) {
				System.out.println(map1.get("_id"));
				System.out.println(map1.get("name"));
				System.out.println("--------------------------------");
			}
			
			System.out.println("DB추가 유무 => " + ret);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
