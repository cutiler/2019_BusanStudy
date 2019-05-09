package sec1.url;

import java.net.URL;

public class UrlExample {
	
	public static void main(String[] args) throws Exception {
		
		URL url = new URL("https://www.naver.com:80/index/index.html?name=database");
		
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		System.out.println(url.getQuery());
		System.out.println(url.getFile());
		
	}

}
