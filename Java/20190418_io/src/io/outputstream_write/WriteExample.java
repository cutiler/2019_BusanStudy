package io.outputstream_write;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExample {
	
	public static void main(String[] args) throws IOException {
		
		String path ="c:/temp/data.txt";
		//String path ="c:/aaa/data.txt";
		
		// true : append. 생략 or false 새로작성.
		FileOutputStream fos = new FileOutputStream(path,false);
		
		String s = "ABCDEFG";
		
		byte[] bytes = s.getBytes();
		
		//fos.write(bytes);
		// bytes 배열의 1번째 인덱스부터 3개의 값.
		//fos.write(bytes,1,3);
		
		for(int i=0; i <bytes.length;i++) {
			fos.write(bytes[i]);
			
		}
		
		
		
		
		
		
		fos.flush();
		fos.close();
		
	}

}
