package io.inputstream_read;

import java.io.FileInputStream;
import java.io.OutputStream;

public class ReadExample4 {
	
	public static final int EOF = -1;
	
	public static void main(String[] args) throws Exception {
		
		String path ="C:\\work\\java\\20190418_io\\src\\io\\inputstream_read\\ReadExample.java";
		
		FileInputStream fis = new FileInputStream(path);
		
		int data;
		
		while((data = fis.read()) != EOF) {
		
			System.out.println((char)data);
			
			/*OutputStream os = System.out;
			os.write(data);
			os.flush();
			*/
			//System.out.write(data);
		}
		
		fis.close();
		
	}

}
