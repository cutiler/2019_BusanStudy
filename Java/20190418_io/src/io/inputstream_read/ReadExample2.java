package io.inputstream_read;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExample2 {
	
	public static final int EOF = -1;
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("c:/temp/file1.txt");
		
		int readByte;
		byte[] bytes = new byte[100];
		String data = "";
		int count =0;
		
		while(true) {
			readByte = fis.read(bytes);

			System.out.println(readByte);			
			if(readByte == EOF) {
				break;				
			} else count = readByte;			
			data += new String(bytes);
		}
		
		
		System.out.println("data : "+data);
		System.out.println("==========================");
		for(int i =0; i<count ; i++) {
			System.out.print((char)bytes[i]);
		}
		
		
	}

}
