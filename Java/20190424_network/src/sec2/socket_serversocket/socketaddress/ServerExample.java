package sec2.socket_serversocket.socketaddress;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	
	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket client = null;
		
		try {
			server = new ServerSocket();
			//server.bind(new InetSocketAddress(5001));
			server.bind(new InetSocketAddress("192.168.0.26",5001));
			System.out.println("[ Server Open ]");
			
			while(true) {
				System.out.println("[ 연결 대기중 ]");
				client = server.accept();
				InetSocketAddress address = (InetSocketAddress)client.getRemoteSocketAddress();
				System.out.println("[ 연결수락 : "+ address.getHostName() +" ]");
				
				InputStream is = client.getInputStream();
				byte[] bytes = null;
				String message = null;
				
				bytes = new byte[100];
				int readByte = is.read(bytes);
				message = new String(bytes,0,readByte,"UTF-8");
				System.out.println("[ 데이터 받기 성공 ] "+message);
				
				OutputStream os = client.getOutputStream();
				message = "Hello 그 친구야!";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				is.close();
				os.close();
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
