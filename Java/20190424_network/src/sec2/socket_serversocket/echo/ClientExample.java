package sec2.socket_serversocket.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientExample {
	
	Socket socket;
	
	
	public ClientExample() {
		startClient();
	}
	
	public void startClient() {
		boolean isRun = true;
		
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("192.168.0.26",5001));
			System.out.println("연결 완료 : " + socket.getRemoteSocketAddress());
			
			receive();
			
			while(isRun) {
				Scanner sc = new Scanner(System.in);
				String message = sc.nextLine();
				send(message);
				//sc.close();
			}
		} catch (IOException e) {
			System.out.println("서버와 통신 안됨");
			stopClient();
			return;
		}
	}	
	
	public void stopClient() {
		try {
			System.out.println("연결 종료");
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {}
	}
	
	public void send(String message) {
		try {
			byte[] bytes = message.getBytes("UTF-8");
			OutputStream os = socket.getOutputStream();
			os.write(bytes);
			os.flush();
		} catch (Exception e) {
			stopClient();
		}
	}
	
	public void receive() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						byte[] bytes = new byte[100];
						InputStream is = socket.getInputStream();
						int readByte = is.read(bytes);
						String message = new String(bytes,0,readByte,"UTF-8");
						System.out.println(message);						
					} catch (IOException e) {
						stopClient();
						break;
					}
				}
			}
		});
		t.start();
	}
	
	public static void main(String[] args) {
		new ClientExample();
	}

}
