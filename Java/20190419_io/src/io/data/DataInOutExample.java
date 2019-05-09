package io.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInOutExample {
	
	public static void main(String[] args) throws Exception {
		/*
		 * FileOutputStream fos = new FileOutputStream("primitive.txt");
		 * DataOutputStream dos = new DataOutputStream(fos);
		 */
		
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("primitive.txt"));
		
		dos.writeUTF("최기근");
		dos.writeDouble(99.9);
		dos.writeInt(100);
		dos.writeByte(10);
		
		dos.writeUTF("박준현");
		dos.writeDouble(59.9);
		dos.writeInt(50);
		dos.writeByte(30);
		
		
		dos.flush();
		dos.close();
		
		DataInputStream dis = new DataInputStream(new FileInputStream("primitive.txt"));
		
		for(int i=0; i < 2; i++) {
		String name = dis.readUTF();
		double score = dis.readDouble();
		int order = dis.readInt();
		byte age = dis.readByte();
		System.out.println("name : "+name+" score : "+score+" order : "+order+" age : "+age );
		
		}
		
		dis.close();
		
		
	}

}
