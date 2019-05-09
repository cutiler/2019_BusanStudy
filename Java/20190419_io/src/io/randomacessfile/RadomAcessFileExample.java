package io.randomacessfile;

import java.io.RandomAccessFile;

public class RadomAcessFileExample {
	
	public static void main(String[] args) throws Exception{
		
		RandomAccessFile file = new RandomAccessFile("random.txt","rw");
		
		file.writeInt(100);//4byte
		System.out.println("파일포인터 위치 "+file.getFilePointer());
		file.writeDouble(3.141592); //8byte
		System.out.println("파일포인터 위치 "+file.getFilePointer());
		String s = "안녕하세요";
		System.out.println("s length : "+s.getBytes().length);
		file.writeUTF(s);
		System.out.println("파일포인터 위치 "+file.getFilePointer());

		file.seek(0);
		System.out.println("파일포인터 위치 "+file.getFilePointer());
		int i = file.readInt();
		System.out.println(i);
		double d = file.readDouble();
		System.out.println(d);
		String str = file.readUTF();
		System.out.println(str);
		System.out.println("파일포인터 위치 "+file.getFilePointer());
		
		file.seek(12);
		System.out.println("파일포인터 위치 "+file.getFilePointer());
		String str1 = file.readUTF();
		System.out.println("str1 : "+ str1);
		
		//file.seek(4);
		//file.writeUTF("여기값추가");
		
		file.close();
		
		
	}

}
