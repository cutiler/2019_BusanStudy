package sec1.url;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class InetAddressExample {
	
	public static void main(String[] args) {
		
		
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("local :"+ local);			
			System.out.println("내 컴퓨터의 아이피 주소 : "+local.getHostAddress());
			
			InetAddress[] iArr = InetAddress.getAllByName("www.naver.com");
			
			for(InetAddress naver : iArr) {
				System.out.println("naver ip 주소 :" + naver.getHostAddress());
			}
			
			InetSocketAddress isa = new InetSocketAddress("www.naver.com",80);
			System.out.println(isa.getAddress());
			System.out.println(isa.getHostString());
			System.out.println(isa.getPort());
			System.out.println(isa);
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
