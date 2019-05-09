package io.reader_writer_stream;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWriterExample {
	
	public static void main(String[] args) throws Exception {
		
		FileOutputStream fos = new FileOutputStream("c:/Temp/fos.txt");
		
		Writer writer = new OutputStreamWriter(fos);
		
		String data = "바이트 출려 스트림 문자기반 출력 스트림으로 변환 !";
		
		writer.write(data);
		writer.flush();
		writer.close();
		fos.close();
		
		
	}

}
