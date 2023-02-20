package day13;

import java.util.Scanner;

import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		try {
			
			ChatClient chat = new ChatClient(); // 서버 접속
			chat.setSubcribe(); // 구독설정
			
			
			Scanner scanner = new Scanner(System.in);
			while (true) { // 무한 반복
				System.out.println("메시지 입력 => ");
				String msg = scanner.nextLine();
				if (msg.equals("exit")) {
					break; // 반복문 탈출
				}
				
				// { "name":"입력내용", "type":1}
				JSONObject jobj = new JSONObject();
				jobj.put("name", msg);
				jobj.put("content", "내용들..");
				jobj.put("price", "1234");
				jobj.put("quantity", "2345");
				
				//chat.sendMessage("/pknu/class303/all", msg); // 입력 메시지 보내짐
				
				// JSONObject=>String=>byte[] ~~~~ byte[]=>String=>JSONObject
				chat.sendMessage("/pknu/class303/id218", jobj.toString());
				Thread.sleep(200); // 0.2초 기다림
			}
			scanner.close();
			System.exit(0);
			}	
		catch (Exception e) {
			e.printStackTrace();
		}		
	}	
}


