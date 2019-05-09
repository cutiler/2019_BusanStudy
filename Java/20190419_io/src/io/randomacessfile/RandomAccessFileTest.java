package io.randomacessfile;

import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) throws Exception {


		RandomAccessFile file = new RandomAccessFile("random1.txt","rw");
		
		String s1 = "첫번째";
		file.writeUTF(s1);
		System.out.println("파일포인터 위치 "+file.getFilePointer());
		String s2 = "두번째";
		file.writeUTF(s2);
		System.out.println("파일포인터 위치 "+file.getFilePointer());
		String s3 = "세번째";
		file.writeUTF(s3);
		System.out.println("파일포인터 위치 "+file.getFilePointer());
		
		file.seek(22);
		String s4 = "네번째";
		file.writeUTF(s4);
		
		
		//System.out.println("파일포인터 위치 "+file.getFilePointer());

//		file.seek(0);
		
		//String str = file.readUTF();
	//	System.out.println(str);
				
		

	}

}
