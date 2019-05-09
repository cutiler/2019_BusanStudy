package sec2.socket_serversocket.base;


import java.net.Socket;


public class ClientExample {
	
	public static void main(String[] args) {
		
		Socket client = null;
		
		try {
			System.out.println("[연결요청]");
			client = new Socket("192.168.0.26",5001);
			System.out.println("[연결성공]");

		} catch (Exception e) {			
			e.printStackTrace();
			System.out.println("연결실패");
		}
		
	}

}
