package sec4.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiveExample {
	
	public static void main(String[] args) throws Exception {
		
		DatagramSocket socket = new DatagramSocket(5001);
		
		System.out.println("[ 수신시작 ]");
		
		while(true) {
		
			try {
				DatagramPacket packet = new DatagramPacket(new byte[100],100);
				
				socket.receive(packet);
				String data = new String(packet.getData(),0,packet.getLength(),"UTF-8");
				System.out.println("[ 받은 내용 : "+packet.getSocketAddress()+" ]"+ data);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("[ 수신완료 ]");
				break;
			}
		
		}
		
		socket.close();
	}

}
