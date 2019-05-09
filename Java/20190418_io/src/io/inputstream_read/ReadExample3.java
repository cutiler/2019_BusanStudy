package io.inputstream_read;

import java.io.FileInputStream;

public class ReadExample3 {
	
	public static final int EOF = -1;
	
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("c:/temp/file1.txt");
		
		byte[] bytes = new byte[8];
		fis.read(bytes,2,3);
		
		for(int i=0; i < bytes.length; i++) {
			System.out.print((char)bytes[i]+" ");
			
		}
		fis.close();
		
	}

}
