package io.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamExample {

	public static final int EOF = -1;
	
	public static void main(String[] args) throws Exception {
		
		long startTime = 0;
		long endTime = 0;
		
		String path ="c:/Temp/forest.jpg";
		File file = new File(path);
		
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		int data;
		startTime = System.nanoTime();		
		while((data = fis.read()) != EOF ) {}
		endTime = System.nanoTime();
		System.out.println("fis : "+(endTime - startTime)+"ns");
		
		startTime = System.nanoTime();		
		while((data = bis.read()) != EOF ) {}
		endTime = System.nanoTime();
		System.out.println("bis : "+(endTime - startTime)+"ns");
		
		
		String result = "c:/Temp/dir/forest";
		FileInputStream fis1 = new FileInputStream(file);
		BufferedInputStream bis1 = new BufferedInputStream(fis1);
		FileOutputStream fos = new FileOutputStream(result);
		BufferedOutputStream bos = new BufferedOutputStream(fos); 
		
		startTime = System.nanoTime();		
		while((data = fis1.read()) != EOF ) {
			fos.write(data);
		}
		endTime = System.nanoTime();
		System.out.println("fos : "+(endTime - startTime)+"ns");
		
		startTime = System.nanoTime();		
		while((data = bis1.read()) != EOF ) {
			bos.write(data);
		}
		endTime = System.nanoTime();
		System.out.println("bos : "+(endTime - startTime)+"ns");
		
		bos.flush();
		fos.flush();
		bos.close();
		fos.close();
		bis1.close();
		fis1.close();
		bis.close();
		fis.close();
		
	}

}
