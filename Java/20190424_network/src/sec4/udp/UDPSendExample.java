package sec4.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


public class UDPSendExample {
	
	public static void main(String[] args) throws Exception {
		
		
		DatagramSocket datagramSocket = new DatagramSocket();
			
		System.out.println("[ 발신 시작 ]");
		
		for(int i=0; i <3; i++) {
			String data = "datagram message - "+i;
			
			byte[] bytes = data.getBytes("UTF-8");
			
			DatagramPacket packet = new DatagramPacket(
					bytes,
					bytes.length,
					new InetSocketAddress("localhost",5001)
					);
			
			datagramSocket.send(packet);
			System.out.println("[ 보낸 바이트 수 : "+bytes.length+" byte ]");
			
		}
		
		System.out.println("발신 종료");
		datagramSocket.close();
		
	}

}
