package io.inputstream_read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
	
	public static void main(String[] args) {
			
		InputStream is = null;
		
		try {
			is = new FileInputStream("c:/Temp/file1.txt");
			int readByte;
			while(true) {
				readByte = is.read();
				if(readByte == -1) {
					break;
				}
				System.out.println((char)readByte);
			}			
		}catch(IOException e){
			System.out.println("파일을 읽을 수 없습니다. : "+e.getMessage());
		}finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {}
			}
		}
		
		
	}
}
