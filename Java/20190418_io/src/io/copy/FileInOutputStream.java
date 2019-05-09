package io.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInOutputStream {
	
	public static final int EOF = -1;
	
	public static void main(String[] args) {
		
		String orginal = "c:/Temp/house.jpg";
		String target = "c:/Temp/dir/house2.jpg";
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		//int count = 0;
		
		try {
			fis = new FileInputStream(orginal);
			fos = new FileOutputStream(target);
			
			int readByte;
			byte[] bytes = new byte[100];
			
			while((readByte = fis.read(bytes)) != EOF) {
				fos.write(bytes,0,readByte);
				//count++;
			}			
			fos.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//System.out.println("while문"+count+"번 반복");
			try {
				if(fos != null) {fos.close();}
				if(fis != null) {fis.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
