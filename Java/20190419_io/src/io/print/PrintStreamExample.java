package io.print;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {
	
	public static void main(String[] args) throws Exception{
		
		PrintStream ps = new PrintStream(new FileOutputStream("data.txt"));
		
		ps.println("[ 프린트 보조 스트림 ]");
		ps.print("마치");
		ps.println("콘솔에 출력 하는 것 처림~");
		ps.println("데이터를 출력 합니다.");
		ps.flush();
		ps.close();
		
	}

}
