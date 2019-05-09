package sec3.chat.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class ServerThread implements Runnable{
	
	Socket socket;
	HashMap<String, ObjectOutputStream> hm;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	String userid;
	
	ServerThread(Socket socket, HashMap<String, ObjectOutputStream> hm){
		this.socket =socket;
		this.hm = hm;
		
		try {
			System.out.println(socket.getInetAddress()+" 로 부터 연결 요청 받음");
			oos = new ObjectOutputStream(this.socket.getOutputStream());
			ois = new ObjectInputStream(this.socket.getInputStream());
			
			userid = (String)ois.readObject();
			
			broadcast(userid+"님이 입장 하셨습니다.");
			
			synchronized(hm) {
				hm.put(userid, oos);
			}
			
			System.out.println("접속한 클라이언트의 아이디는 :"+userid+"입니다.  방인원 : "+hm.size());
			
			
		} catch (Exception e) { }
		
		
	}
	
	@Override
	public void run() {
		
		String receiveData;
		
		// /quit		 => 연결 종료
		// /to 아이디 메시지	 => 귓속말
		// 나머지는 전체말.
		
		
		while(true) {
			
			try {
				receiveData = (String)ois.readObject();
				if(receiveData.trim().equals("/quit")) {
					break;
				}else if(receiveData.indexOf("/to") > -1) {
					//귓속말
					sendMsg(receiveData);
				}else {
					broadcast(userid+" : "+ receiveData);
				}
				
				
			} catch (Exception e) {	}
		}
		synchronized (hm) {
			hm.remove(userid);
		}
		
		System.out.println(userid+"님이 나가셨습니다.");		
	}
	
	// 메시지 전달
	public void broadcast(String message) {
		
		
		try {
			for(ObjectOutputStream oos : hm.values()) {		
				
					oos.writeObject(message);
					oos.flush();			
			}
			System.out.println(message);
		} catch (IOException e) {}
		
	}
	
	// /to 아이디 메시지	 => 귓속말
	// 메세지 (귓속말)
	public void sendMsg(String message) {
		
		int begin = message.indexOf(" ")+1;
		int end = message.indexOf(" ",begin); // begin:첫번째 공백. 공백 다음글자부터 다음 공백찾기.
		
		if(end != -1) {
			String id = message.substring(begin, end);
			String msg = message.substring(end+1);
			ObjectOutputStream  oos = hm.get(id);
			
			try {
				if(oos != null) {
					oos.writeObject(userid+"님이 귓속말을 보냈어요 : "+ msg);
					oos.flush();
				}
			} catch (IOException e) {	}
			
		}
		
		
	}
	

}
