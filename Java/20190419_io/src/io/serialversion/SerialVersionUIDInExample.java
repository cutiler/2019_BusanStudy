package io.serialversion;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerialVersionUIDInExample {
	
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("object.dat");
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		ClassA a = (ClassA)ois.readObject();
		System.out.println(a.field1);
		System.out.println(a.field2);
		ois.close();
		
	}

}
