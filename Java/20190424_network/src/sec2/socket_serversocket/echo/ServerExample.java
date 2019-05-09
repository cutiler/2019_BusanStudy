package sec2.socket_serversocket.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class ServerExample {
	
	public static String localhost;
	
	ServerSocket serverSocket;
	List<Client> connections = new Vector<>();
	
	
	public ServerExample() {
		startServer();
	}
	
	
	public void startServer() {
		localhost = "192.168.0.26";
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("192.168.0.26",5001));
		} catch (IOException e) {
			if(!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}
		
		Thread t = new Thread(()->{
			while(true) {
				
				try {
					System.out.println("[ 연결대기중 ]");
					Socket socket = serverSocket.accept();
					System.out.println("[ 연결수락 : " + ((InetSocketAddress)socket.getRemoteSocketAddress()).getHostName() + " ]");
					connections.add(new Client(socket));
					System.out.println("연결 개수 : " + connections.size());
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
		}
				);
		
		t.start();
		
	}
	
	public void stopServer() {
		
		try {
			System.out.println("서버 종료");
			for(Client c : connections){
				if(!c.socket.isClosed()) {
					c.socket.close();
				}
			}
			serverSocket.close();
		} catch (IOException e) {}
		
	}
	
	class Client{
		
		Socket socket;
		
		public Client(Socket socket) {
			this.socket = socket;
			receive();
		}
	
	
		// 메세지를 수신 받는 메소드
		public void receive() {
			
		//new Thread(()->{
		Thread t = new Thread(()->{
				while(true) {
					
					try {
						byte[] bytes = new byte[100];
						InputStream is = socket.getInputStream();
						int readBytes = is.read(bytes);
						String message = "요청 처리 완료"+socket.getRemoteSocketAddress();
						System.out.println(message);
						String data = new String(bytes,0,readBytes,"UTF-8");
						for(Client c : connections) {
							c.send(data);
						}						
						
					} catch (IOException e) {
						connections.remove(Client.this);
						System.out.println("클라이언트 통신 안됨 :"+socket.getRemoteSocketAddress());
						break;
					}
				}
			});//.start();
			t.start();
			
		}
		
		// 메세지 송신
		public void send(String data) {
		
			OutputStream os = null;
			try {
				String message = socket.getRemoteSocketAddress() +" "+ data;
				byte[] bytes = message.getBytes("UTF-8");
				os = socket.getOutputStream();
				os.write(bytes);
				os.flush();
			} catch (Exception e) {
				try {
					System.out.println("클리언트 통신 안됨");
					if(os != null) {
						os.close();
					}
					connections.remove(Client.this);
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch (IOException e1) {}
			}
		}
	}	
		
	
	
	
	public static void main(String[] args) {
		
		new ServerExample();
		
	}

}
