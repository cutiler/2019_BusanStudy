package sec2.socket_serversocket.base;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	
	public static void main(String[] args) {
		
		ServerSocket server = null;
		
		try {
			
			server = new ServerSocket(5001);
			while(true){
					System.out.println("[ 연결대기중 ]");
					Socket client = server.accept();						
					InetSocketAddress isa = (InetSocketAddress)client.getRemoteSocketAddress();			
					System.out.println("[ 연결수락 ]"+isa.getHostName());			
				}
			
			} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
