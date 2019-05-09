package io.writer;

import java.io.FileWriter;
import java.io.Writer;

public class WriterExample {
	
	public static void main(String[] args) throws Exception{
		
		Writer writer = new FileWriter("c:/Temp/data.txt");
		
		byte[] bytes = "최기근님".getBytes();
		char[] data = "최기근".toCharArray();
		for(char c : data) {
			System.out.println(c);
		}
		
		writer.write(new String(bytes));
		//writer.write(data);
		//writer.write(data,1,2);
		//writer.write("최기근");
		writer.flush();
		writer.close();
		
		
	}

}
