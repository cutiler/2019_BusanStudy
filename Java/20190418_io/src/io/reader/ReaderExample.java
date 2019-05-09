package io.reader;

import java.io.FileReader;
import java.io.Reader;

public class ReaderExample {
	
	public static final int EOF = -1;
	
	public static void main(String[] args) throws Exception{
		
		Reader reader = new FileReader("c:/Temp/data.txt");
		
		int readData;
		
		char[] cbuf = new char[100];
		while(true) {
			readData = reader.read(cbuf);
			System.out.println(readData);
			if(readData == EOF) {
				break;
			}
			for(int i=0; i<cbuf.length; i++) {
				System.out.print(cbuf[i]);
			}
		}
		
		reader.close();
		
		
	}

}
