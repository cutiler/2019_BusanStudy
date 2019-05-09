package sec2.socket_serversocket.socketaddress;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {
	
	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			socket = new Socket();
			System.out.println("연결요청");
			socket.connect(new InetSocketAddress("192.168.0.26",5001));
			System.out.println("[연결 성공]");
			
			OutputStream os = socket.getOutputStream();
			
			byte[] bytes = null;
			String message = null;
			
			message = "Hello 이 친구야!";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
											
			InputStream is = socket.getInputStream();
			
			int readByte = is.read(bytes);
			
			message = new String(bytes,0,readByte,"UTF-8");
			System.out.println("[ 서버에서 전달 받은 데이터 :  ]"+message);
			os.close();
			is.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
