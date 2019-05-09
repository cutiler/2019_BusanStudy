package sec3.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ChatClientExample {
	
	public final static int PORT = 5001;
	String ip;
	String userid;
	
	Socket server;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	BufferedReader read;
	String sendData;
	String receiveData;
	
	ChatClientExample(String userid, String ip) {
		this.userid = userid;
		this.ip = ip;
		
		try {
			System.out.println("****** 클라이언트    ********");
			System.out.println("연결 요청 : "+ ip + ":"+PORT);		
			server = new Socket();
			server.connect(new InetSocketAddress(ip,PORT));
			System.out.println("연결 성공");
			
			read = new BufferedReader(new InputStreamReader(System.in));
			
			ois = new ObjectInputStream(server.getInputStream());
			oos = new ObjectOutputStream(server.getOutputStream());
			oos.writeObject(userid);
			oos.flush();
			
			ReceiveDataThread rdt = new ReceiveDataThread(server,ois);
			Thread t = new Thread(rdt);
			t.start();
			
			while(true) {
				sendData = read.readLine();
				oos.writeObject(sendData);
				oos.flush();
				
				if(sendData.trim().equals("/quit")) {
					t.interrupt();
					break;
				}
			}
			
			
		} catch (IOException e) {
			
		}finally {
			try {
				if(server != null && !server.isClosed()) {
					ois.close();
					oos.close();
					read.close();				
					server.close();
					System.out.println("종료");
					System.exit(0);
				}
			} catch (IOException e) {}
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		// id, 연결 ip
		new ChatClientExample("User2","192.168.0.26");
		
	}

}
