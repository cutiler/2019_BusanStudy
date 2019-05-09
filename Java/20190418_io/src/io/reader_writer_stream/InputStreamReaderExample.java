package io.reader_writer_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {
	
	public static final int EOF = -1;
	
	public static void main(String[] args) throws Exception {
		
		String path = "c:/Temp/fos.txt";
		
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
			file.createNewFile();
		}
		
		
		FileInputStream fis = new FileInputStream(file);
		Reader reader = new InputStreamReader(fis);
		
		int readData;
		
		char[] cbuf = new char[100];
		
		while( ( readData = reader.read(cbuf) ) != EOF) {
			String data = new String(cbuf,0,readData);
			System.out.println(data);
		}
		
		reader.close();
		fis.close();
		
		
	}

}
